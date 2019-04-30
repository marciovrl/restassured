package com.example.steps.definitions;

import static io.restassured.RestAssured.given;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddPostSteps {

    private Response response;
    private RequestSpecification request;

    private String ENDPOINT_TOKEN = "https://jsonplaceholder.typicode.com/posts";


    @Given("^use endpoint add posts$")
    public void use_endpoint_add_posts(){ 
        request = given()
        .header("Content-Type", "application/json", "Accept-Charset", "utf-8");
        
    }

    @When("^add item Post with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void add_item_Post_with_and(String tittle, String body){
        request.body("{\"title\": tittle, \"body\":\body\"}");
        
        response = request.when()
        .post(ENDPOINT_TOKEN);
    }
    
    @Then("^I see inserted item$")
    public void i_see_inserted_item(){
        response.then().statusCode(201);
    }
} 