package com.example.user_register_ee.endpoints;

import com.fasterxml.jackson.core.util.JacksonFeature;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/rest")
class RestConfiguration extends Application   {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(JacksonFeature.class);
        resources.add(UserEndpoint.class);
//        resources.add(JacksonAutoDiscoverable.class);
        return resources;
    }

//    public Set<Object> getSingletons() {
//        return new HashSet<>(Arrays.asList( new JacksonAutoDiscoverable()));
//    }

}