package com.example.user_register_ee.endpoints;

//import javax.enterprise.context.ApplicationScoped;
//import javax.servlet.annotation.WebServlet;
import com.example.user_register_ee.dto.User;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

@Path("/user")
//@ApplicationScoped
//@ApplicationPath("/rest")
public class UserEndpoint /*extends Application*/ {
//    private final Rest rest = new Rest();


    @GET
//    @Path("/test")
    @Produces({MediaType.APPLICATION_JSON})
//    @Consumes(MediaType.APPLICATION_JSON)
    public User getClichedMessage() {
        return new User("Poxos");
    }
}
