package com.example.helloworld;


import com.example.helloworld.api.Saying;
import com.example.helloworld.resources.HelloWorldResource;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import io.dropwizard.testing.junit.ResourceTestRule;

import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
@Path("/hello-world")
template: Hello, %s!
defaultName: Stranger
 */
public class HelloWorldApplicationTest {
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new HelloWorldResource("Hello, %s!", "Stranger"))
            .build();


    @Test
    public void testSayHello() {
        final String value = String.format("Hello, %s!","Nikhil");
        assertThat(resources.client().target("/hello-world?name=Nikhil").request().get(Saying.class))
                .isEqualTo(new Saying(1,value));
    }

    @ClassRule
    public static final DropwizardAppRule<HelloWorldConfiguration> RULE =
            new DropwizardAppRule<HelloWorldConfiguration>(HelloWorldApplication.class, ResourceHelpers.resourceFilePath("hello-world.yml"));

    @Test()
    public void testSayHelloException() {
        Client client = new JerseyClientBuilder(RULE.getEnvironment()).build("test client");

        Response response = client.target(
                String.format("http://localhost:%d/hello-world", RULE.getLocalPort()))
                .request().get();
        System.out.println(response.getStatus());
    }
}
