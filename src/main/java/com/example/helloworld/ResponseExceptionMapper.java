package com.example.helloworld;

import org.eclipse.jetty.http.HttpStatus;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class ResponseExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        return Response.status(HttpStatus.BAD_REQUEST_400)
                .entity(e.getMessage())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
