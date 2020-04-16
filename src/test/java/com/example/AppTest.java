package com.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

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
            contentType(ContentType.JSON).
        when().
            get("/posts").
        then().
            statusCode(200).
            body(matchesJsonSchemaInClasspath("posts.json"));
    }

    @Test
    public void validatePostReturn() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("title", "Testing");
        params.put("body", "Testing API example");

        given().
            contentType(ContentType.JSON).
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
            contentType(ContentType.JSON).
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
            contentType(ContentType.JSON).
            pathParam("id", 1).
        when().
            delete("posts/{id}").
        then().
            statusCode(200);
    }
}
