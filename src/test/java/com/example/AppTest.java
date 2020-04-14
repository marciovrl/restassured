package com.example;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.HashMap;

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
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("title", "Testing");
        params.put("body", "Testing API example");

        given().
            contentType("application/json").
            body(params).
        when().
            post("/posts").
        then().
            statusCode(201).
            body("title", is("Testing"));
    }

    @Test
    public void validatePutReturn() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("title", "New Testing");

        given().
            contentType("application/json").
            body(params).
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
