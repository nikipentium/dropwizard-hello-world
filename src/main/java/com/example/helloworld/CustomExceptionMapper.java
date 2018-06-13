package com.example.helloworld;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class CustomExceptionMapper implements ExceptionMapper<MyCustomException>{
    @Override
    public Response toResponse(MyCustomException exception) {
        return Response.status(exception.getCode())
                .entity(exception.getMessage())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
