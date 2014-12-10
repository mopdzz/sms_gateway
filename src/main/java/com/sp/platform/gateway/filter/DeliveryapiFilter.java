package com.sp.platform.gateway.filter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.core.util.ReaderWriter;
import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

/**
 * @author yang lei
 */
public class DeliveryapiFilter implements ContainerRequestFilter,ContainerResponseFilter{

    @Context
    private HttpServletRequest httpServletRequest;
    
    private static ThreadLocal<StringBuilder> requestRawData = new ThreadLocal<StringBuilder>();
    
    private static Logger log = LoggerFactory.getLogger(DeliveryapiFilter.class);
    
    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        
        //request finished time
        long requestTime = (Long) httpServletRequest.getAttribute("requestTime");
        
        log.info(("END {millsec=" + (System.currentTimeMillis() - requestTime) + "} ").toString());
        
        return response;
    }

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        log.info("start do filter");

        httpServletRequest.setAttribute("requestTime", System.currentTimeMillis());
        
        requestRawData.set(new StringBuilder());
        
        try {
            InputStream in = request.getEntityInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ReaderWriter.writeTo(in, out);
            byte[] requestEntity = out.toByteArray();
            
            if(StringUtils.isBlank(requestEntity.toString())){
                throw new RuntimeException("error");
            }
            
            loadEntity(requestRawData.get(), requestEntity);
            request.setEntityInputStream(new ByteArrayInputStream(requestEntity));
        } catch (IOException e) {
           
        }
        
        return request;
    }
 
    
    private void loadEntity(StringBuilder sb, byte[] entity) throws IOException {
        if (entity.length == 0) return;
        sb.append(new String(entity)).append("\n");
    }
}
