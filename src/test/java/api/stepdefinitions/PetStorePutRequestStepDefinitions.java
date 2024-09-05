package api.stepdefinitions;

import api.pojo.PetStorePojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PetStorePutRequestStepDefinitions {

    Response response;
    PetStorePojo petStorePojo = new PetStorePojo();

    @Given("User creates a pet")
    public void user_creates_a_pet() {

        petStorePojo.setId(501050);
        petStorePojo.setName("Marry");
        petStorePojo.setStatus("successfully created");

        given().accept(ContentType.JSON).contentType(ContentType.JSON).body(petStorePojo)
                .when().post("https://petstore.swagger.io/v2/pet")
                .then().statusCode(200);
    }
    @When("User executes put request for pet")
    public void user_executes_put_request_for_pet() {
        petStorePojo.setId(205010);
        petStorePojo.setName("Mark");
        petStorePojo.setStatus("successfully updated");

        response = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(petStorePojo)
                .when().put("https://petstore.swagger.io/v2/pet")
                .then().extract().response();
    }
    @Then("Status code is {int} or not")
    public void status_code_is_or_not(Integer int1) {
        response.then().statusCode(int1);
    }

    @Then("Pet has following data")
    public void pet_has_following_data(io.cucumber.datatable.DataTable dataTable) {
        List<Map <String,String>> maps = dataTable.asMaps();
        Map<String,String> petData = maps.get(0);

        String petName = petData.get("petName");
        String petStatus = petData.get("petStatus");
        long petId = Long.parseLong(petData.get("petId"));

        PetStorePojo petStorePojo1 = response.as(PetStorePojo.class);

        Assert.assertEquals(petName,petStorePojo1.getName());
        Assert.assertEquals(petStatus,petStorePojo1.getStatus());
        Assert.assertEquals(petId,petStorePojo1.getId());

    }
    @Then("User deletes updated pet")
    public void user_deletes_updated_pet() {
        given().contentType(ContentType.JSON)
                .when().delete("https://petstore.swagger.io/v2/pet/205010")
                .then().statusCode(200);
    }
}
