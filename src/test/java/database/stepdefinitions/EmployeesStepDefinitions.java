package database.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeesStepDefinitions {

    public Connection connection;
    public Statement statement;
    public ResultSet resultSet;

    @Given("User connect to database")
    public void user_connect_to_database() throws SQLException {
        connection = DatabaseUtils.establishConnection();
        statement = DatabaseUtils.connectStatement();
    }
    @When("User gets the first employee from the table")
    public void user_gets_the_first_employee_from_the_table() throws SQLException {
        resultSet = DatabaseUtils.resultSet;
        resultSet = statement.executeQuery("select * from employees order by employee_id");
        resultSet.next();
    }
    @Then("User validates employee information with the following data: {string},{string},{string},{string}")
    public void user_validates_employee_information_with_the_following_data(String expectedEmployeeId, String expectedFirstName, String expectedLastName, String expectedEmail) throws SQLException {
       String actualEmployeeId = resultSet.getString("employee_id");
       String actualFirstName = resultSet.getString("first_name");
       String actualLastname = resultSet.getString("last_name");
       String actualEmail = resultSet.getString("email");

        Assert.assertEquals(expectedEmployeeId,actualEmployeeId);
        Assert.assertEquals(expectedFirstName,actualFirstName);
        Assert.assertEquals(expectedLastName,actualLastname);
        Assert.assertEquals(expectedEmail,actualEmail);
    }
    @Then("User validates employee information with the data: {string},{string},{string},{string},{string}")
    public void user_validates_employee_information_with_the_data(String expectedPhoneNumber, String expectedHireDate, String expectedJobId, String expectedSalary, String expectedComissionPct) throws SQLException {
        String actualPhoneNumber = resultSet.getString("phone_number");
        String actualHireDate = resultSet.getString("hire_date");
        String actualJobId = resultSet.getString("job_id");
        String actualSalary = resultSet.getString("salary");
        String actualComissionPct = resultSet.getString("commission_pct");

        Assert.assertEquals(expectedPhoneNumber,actualPhoneNumber);
        Assert.assertEquals(expectedHireDate,actualHireDate);
        Assert.assertEquals(expectedJobId,actualJobId);
        Assert.assertEquals(expectedSalary,actualSalary);
        Assert.assertEquals(expectedComissionPct,actualComissionPct);
    }
    @Then("User validates employee information with the employee data: {string},{string}")
    public void user_validates_employee_information_with_the_employee_data(String expectedManagerId, String expectedDepartmentId) throws SQLException {
        String actualManagerId = resultSet.getString("manager_id");
        String actualDepartmentId = resultSet.getString("department_id");

        Assert.assertEquals(expectedManagerId,actualManagerId);
        Assert.assertEquals(expectedDepartmentId,actualDepartmentId);

        DatabaseUtils.closeConnection();
    }

}
