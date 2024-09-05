package database.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/databasefeatures",
        glue = "database/stepdefinitions",
        tags = "@hrTest",
        dryRun = false,
        plugin = {"pretty","json:target/databaseReport.json","html:target/databaseReport.html","rerun:target/databaseFailedTests.txt"})
public class DatabaseRunner {
}
