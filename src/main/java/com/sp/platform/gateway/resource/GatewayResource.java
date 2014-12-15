/**
 * 
 */
package com.sp.platform.gateway.resource;


import com.sp.platform.gateway.constant.Constants;
import com.sp.platform.gateway.constant.Status;
import com.sp.platform.gateway.request.MnSmsRequest;
import com.sp.platform.gateway.response.MnSmsResponse;
import com.sun.jersey.api.core.InjectParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * @author zhengqiang.shi
 */
@Controller
@Path("/")
public class GatewayResource extends BaseResource {

    private static Logger log = LoggerFactory.getLogger(GatewayResource.class);

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path(Constants.MN_SMS)
    public Response receiveSms(MnSmsRequest request) {
        log.info("POST Method gateway receive an sms from mn" + request);
        /** do validation */
        validator(request);
        /** set GetEmapUrlResponse and return */
        MnSmsResponse response = new MnSmsResponse();
        response.setStatus(Status.SUCCESS.getHttpStatusCode());
        response.setMessage(Arrays.asList(Status.SUCCESS.getReasonPhrase()));
        response.setFlg("true");

        return Response.status(Response.Status.OK).type(MediaType.APPLICATION_XML).entity(response).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path(Constants.MN_SMS)
    public Response receiveSmsGet(@QueryParam("linkId") String linkId, @QueryParam("serviceId") String serviceId) {
        MnSmsRequest request = new MnSmsRequest();
        request.setLinkId(linkId);
        request.setServiceId(serviceId);
        log.info("Get Method gateway receive an sms from mn " + request);
        /** do validation */
        validator(request);
        /** set GetEmapUrlResponse and return */
        MnSmsResponse response = new MnSmsResponse();
        response.setStatus(Status.SUCCESS.getHttpStatusCode());
        response.setMessage(Arrays.asList(Status.SUCCESS.getReasonPhrase()));
        response.setFlg("true");

        return Response.status(Response.Status.OK).type(MediaType.APPLICATION_XML).entity(response).build();
    }
}
