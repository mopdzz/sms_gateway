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

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path(Constants.MN_SMS)
    public Response getEmapUrl(@InjectParam MnSmsRequest request) {
        log.info("gateway receive an sms from mn" + request);
        /** do validation */
        validator(request);
        /** set GetEmapUrlResponse and return */
        MnSmsResponse response = new MnSmsResponse();
        response.setStatus(Status.SUCCESS.getHttpStatusCode());
        response.setMessage(Arrays.asList(Status.SUCCESS.getReasonPhrase()));
        response.setFlg("true");

        return Response.status(Response.Status.OK).entity(response).build();
    }
}
