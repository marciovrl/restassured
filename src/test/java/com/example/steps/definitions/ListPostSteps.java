package com.example.steps.definitions;

import static io.restassured.RestAssured.given;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ListPostSteps {

    private Response response;
    private RequestSpecification request;

    private String ENDPOINT_TOKEN = "https://jsonplaceholder.typicode.com/posts";

    @Given("^use endpoint list posts$")
    public void use_endpoint_list_posts(){ 
        request = given()
        .header("Content-Type", "application/json", "Accept-Charset", "utf-8");
    }

    @When("^ready all Post item$")
    public void ready_all_Post_item(){
        response = request.when().get(ENDPOINT_TOKEN);
    }
    
    @Then("^I view all Post items$")
    public void i_view_all_Post_items(){
        response.then().statusCode(200);
    }

}