package com.travelhelper.config;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.travelhelper.exception.AlreadyExistsExceptionHandler;
import com.travelhelper.exception.NotFoundExceptionHandler;
import com.travelhelper.resources.PlaceResource;

import java.util.*;

@ApplicationPath("/api")
public class RestConfig extends Application {
    public Set<Class<?>> getClasses() {
        return new HashSet<Class<?>>(Arrays.asList(PlaceResource.class, NotFoundExceptionHandler.class, AlreadyExistsExceptionHandler.class));
    }

    @Override
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<String, Object>();
        properties.put("jersey.config.server.provider.packages", "com.travelhelper.resources");
        return properties;
    }
}
