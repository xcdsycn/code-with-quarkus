package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import jdk.jfr.Name;
import org.acme.service.GreetingService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolationException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@QuarkusTest
public class GreetingResourceTest {
    @Named("greetingService")
    GreetingService greetingService;

    //@InjectMock
    //GreetingService greetingServiceMock;

    @Test
    public void testHelloEndpoint() {
        //given()
        //  .when().get("/hello?asc")
        //  .then()
        //     .statusCode(200)
        //     .body(is("Hello RESTEasy"));
    }

    @Test
    public void testGreetingForYoungers() {
        Assertions.assertThatExceptionOfType(ConstraintViolationException.class)
                .isThrownBy(() -> greetingService.getGreeting(15));
    }

    @Test
    public void testGreetingForTeenagers() {
        String message = greetingService.getGreeting(18);
        System.out.println("<== message :  "  + message);
        Assertions.assertThat(message).isEqualTo("hello boys and girls");
    }

    @Test
    public void testGreetingForAdult() {
        String message=greetingService.getGreeting(21);
        Assertions.assertThat(message).isEqualTo("hello, ladies and Gentleman");
    }

    //@BeforeEach
    //public void prepareMocks() {
    //    when(greetingServiceMock.getGreeting(12)).thenReturn("你好，从mockito 返回");
    //}
}