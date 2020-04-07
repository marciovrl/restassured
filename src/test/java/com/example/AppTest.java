package com.example;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class AppTest {
    
    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts";
    }

    @Test
    public void validateGetReturn() {
        given().
            contentType("application/json").
        when().
            get("/").
        then().
            statusCode(200);
    }

    @Test
    public void validatePostReturn() {
        given().
            contentType("application/json").
            body("{\"title\":\"Testing\", \"body\":\"Testing API example\"}").
        when().
            post("/").
        then().
            statusCode(201).
            body("title", is("Testing"));
    }

    @Test
    public void validatePutReturn() {
        given().
            contentType("application/json").
            body("{\"title\":\"New Testing\"}").
        when().
            put("/1").
        then().
            statusCode(200).
            body("title", is("New Testing"));
    }

    @Test
    public void validateDeleteReturn() {
        given().
            contentType("application/json").
        when().
            delete("/1").
        then().
            statusCode(200);
    }

}
