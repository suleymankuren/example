package ui.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import ui.page.LoginOpenMrsPage;
import utils.Driver;
import utils.PropertyReader;

public class LoginOpenMrsStepDefinitions {

    WebDriver driver = Driver.driver();
    LoginOpenMrsPage loginOpenMrsPage = new LoginOpenMrsPage(driver);

    @When("User navigates to open Mrs home page")
    public void user_navigates_to_open_mrs_home_page() {
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }

    @When("User logs in with username and password")
    public void user_logs_in_with_username_and_password() {
        loginOpenMrsPage.userName.sendKeys(PropertyReader.uiPropertyValue("username"));
        loginOpenMrsPage.passWord.sendKeys(PropertyReader.uiPropertyValue("password"));
        loginOpenMrsPage.location.click();
        loginOpenMrsPage.loginButton.click();
    }
    @Then("User is logged in correctly")
    public void user_is_logged_in_correctly() {
        String actualUrl= driver.getCurrentUrl();
        String expectedUrl="https://demo.openmrs.org/openmrs/referenceapplication/home.page";
        Assert.assertEquals(expectedUrl,actualUrl);

        // Log out
        loginOpenMrsPage.logoutButton.click();
    }

}
