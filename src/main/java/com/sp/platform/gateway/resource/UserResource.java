/**
 * 
 */
package com.sp.platform.gateway.resource;


import com.sp.platform.domain.User;
import com.sp.platform.gateway.constant.Constants;
import com.sp.platform.gateway.constant.Status;
import com.sp.platform.gateway.response.UserResponse;
import com.sp.platform.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;

/**
 * @author zhengqiang.shi
 */
@Controller
@Path("/user")
public class UserResource extends BaseResource {

    private static Logger log = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserService userService;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path(Constants.USER_GET)
    public Response getUser(@QueryParam("id") Integer id) {
        /** set GetEmapUrlResponse and return */
        UserResponse response = new UserResponse();
        response.setStatus(Status.SUCCESS.getHttpStatusCode());
        response.setMessage(Arrays.asList(Status.SUCCESS.getReasonPhrase()));
        User user = userService.get(id);
        response.setUser(userService.get(id));

        return Response.status(Response.Status.OK).type(MediaType.APPLICATION_XML).entity(response).build();
    }

}
