package database.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( features = "target/databaseFailedTests.txt",
        tags = "regression",
        glue = "database/stepdefinitions",
        plugin = {"pretty","json:target/databaseReport.json","html:target/databaseReport.html","rerun:target/databaseFailedTests.txt"})
public class DatabaseRerun {
}
