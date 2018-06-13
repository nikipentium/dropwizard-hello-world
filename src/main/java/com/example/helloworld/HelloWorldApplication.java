package com.example.helloworld;

import com.example.helloworld.resources.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class HelloWorldApplication extends Application<HelloWorldConfiguration>{

    public static void main(String[] args) throws Exception{
        new HelloWorldApplication().run(args);
    }

    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {
        final HelloWorldResource resource = new HelloWorldResource(
                helloWorldConfiguration.getTemplate(), helloWorldConfiguration.getDefaultName());
        environment.jersey().register(resource);
        environment.jersey().register(new CustomExceptionMapper());
        environment.jersey().register(new ResponseExceptionMapper());
    }
}

