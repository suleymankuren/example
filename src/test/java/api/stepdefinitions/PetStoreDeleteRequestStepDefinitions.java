package api.stepdefinitions;

import api.pojo.PetStorePojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PetStoreDeleteRequestStepDefinitions {
    Response response;

    @Given("User checks pet is created")
    public void user_checks_pet_is_created() {
        response = given().accept(ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/401040")
                .then().extract().response();

        if (response.getStatusCode() != 200){
            PetStorePojo petStorePojo = new PetStorePojo();
            petStorePojo.setId(401040);
            petStorePojo.setName("NewPet");
            petStorePojo.setStatus("successfully created");

            given().accept(ContentType.JSON).contentType(ContentType.JSON).body(petStorePojo)
                    .when().post("https://petstore.swagger.io/v2/pet")
                    .then().statusCode(200);
        }
    }
    @When("User executes delete request for pet")
    public void user_executes_delete_request_for_pet() {
        response = given().accept(ContentType.JSON)
                .when().delete("https://petstore.swagger.io/v2/pet/401040")
                .then().extract().response();
    }
    @Then("User validates status code is {int} for pet")
    public void user_validates_status_code_is_for_pet(Integer int1) {
        response.then().statusCode(200);
    }

    @Then("User executes get request to check status code is {int}")
    public void user_executes_get_request_to_check_status_code_is(Integer int1) {
        given().accept(ContentType.JSON)
                .when().get("https://petstore.swagger.io/v2/pet/401040")
                .then().statusCode(int1);
    }
}
