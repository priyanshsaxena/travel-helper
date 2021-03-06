package com.travelhelper.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class AlreadyExistsExceptionHandler implements ExceptionMapper<PlaceAlreadyExists> {
    public Response toResponse(PlaceAlreadyExists ex) {
        return Response.status(Response.Status.CONFLICT.getStatusCode()).build();
    }
}
