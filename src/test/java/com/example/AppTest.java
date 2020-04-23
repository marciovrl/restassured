package com.example;

import org.junit.Test;
import java.util.Map;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

import com.example.BaseTest;

public class AppTest extends BaseTest {

    @Test
    public void validateGetReturn() {
        given().
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
            pathParam("id", 1).
        when().
            delete("posts/{id}").
        then().
            statusCode(200);
    }
}
