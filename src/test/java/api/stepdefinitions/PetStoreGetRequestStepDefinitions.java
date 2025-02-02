package api.stepdefinitions;

import api.pojo.PetStorePojo;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PetStoreGetRequestStepDefinitions {

    Response response;
    @When("User executes get call")
    public void user_executes_get_call() {
      response = given().accept(ContentType.JSON)
              .when().get("https://petstore.swagger.io/v2/pet/301030")
              .then().extract().response();
    }
    @Then("User validates status code is {int}")
    public void user_validates_status_code_is(Integer int1) {
        response.then().statusCode(int1);
    }
    @Then("Pet has following items")
    public void pet_has_following_items(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String,String>> maps = dataTable.asMaps();
        Map<String,String> petData = maps.get(0);

        String petName = petData.get("petName");
        String petStatus = petData.get("petStatus");
        long petId = Long.parseLong(petData.get("petId"));

        PetStorePojo petStorePojo = response.as(PetStorePojo.class);

        Assert.assertEquals(petId,petStorePojo.getId());
        Assert.assertEquals(petName,petStorePojo.getName());
        Assert.assertEquals(petStatus,petStorePojo.getStatus());
    }

}
