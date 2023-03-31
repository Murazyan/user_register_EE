package com.example.user_register_ee.endpoints;

//import javax.enterprise.context.ApplicationScoped;
//import javax.servlet.annotation.WebServlet;

import com.example.user_register_ee.dto.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
public class UserEndpoint {


    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public User etClichedMessage() {
        return new User("Poxos", 0);
    }


    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public User postExample(User user) {
        System.out.println("+++++ " + user);
        return new User("Poxossss", 0);
    }

    @GET
    @Path("/id/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public User getById(@PathParam("id") int id) {
        return new User("Poxos", id);
    }

    @GET
    @Path("/xx")
    @Produces({MediaType.APPLICATION_JSON})
    public User getByIdAndHome(@QueryParam("id") int id,
                               @QueryParam("home") String home) {
        System.out.println("*** " + home);
        return new User("Poxos", id);
    }
}
