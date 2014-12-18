/**
 * 
 */
package com.sp.platform.gateway.resource;


import com.sp.platform.domain.User;
import com.sp.platform.gateway.constant.Constants;
import com.sp.platform.gateway.constant.Status;
import com.sp.platform.gateway.request.UserRequest;
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
import java.util.Date;

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
        UserResponse response = new UserResponse();
        response.setStatus(Status.SUCCESS.getHttpStatusCode());
        response.setMessage(Arrays.asList(Status.SUCCESS.getReasonPhrase()));
        response.setUser(userService.get(id));

        return Response.status(Response.Status.OK).type(MediaType.APPLICATION_XML).entity(response).build();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Path(Constants.USER_SAVE)
    public Response saveUser(UserRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setPasswd(request.getPasswd());
        Date now = new Date();
        user.setCtime(now);
        user.setUtime(now);
        userService.save(user);

        UserResponse response = new UserResponse();
        response.setStatus(Status.SUCCESS.getHttpStatusCode());
        response.setMessage(Arrays.asList(Status.SUCCESS.getReasonPhrase()));
        response.setUser(user);

        return Response.status(Response.Status.OK).type(MediaType.APPLICATION_JSON).entity(response).build();
    }

}
