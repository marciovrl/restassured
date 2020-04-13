package com.example;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AppTest {
    
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void validateGetReturn() {
        given().
            contentType("application/json").
        when().
            get("/posts").
        then().
            statusCode(200);
    }

    @Test
    public void validatePostReturn() {
        given().
            contentType("application/json").
            body("{\"title\":\"Testing\", \"body\":\"Testing API example\"}").
        when().
            post("/posts").
        then().
            statusCode(201).
            body("title", is("Testing"));
    }

    @Test
    public void validatePutReturn() {
        given().
            contentType("application/json").
            body("{\"title\":\"New Testing\"}").
            pathParam("id", 1).
        when().
            put("posts/{id}").
        then().
            statusCode(200).
            body("title", is("New Testing"));
    }

    @Test
    public void validateDeleteReturn() {
        given().
            contentType("application/json").
            pathParam("id", 1).
        when().
            delete("posts/{id}").
        then().
            statusCode(200);
    }
}
