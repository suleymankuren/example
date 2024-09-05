package ui.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/uifeatures",
        glue = "ui/stepdefinitions",
        tags = "@positiveLogin",
        dryRun = false,
        plugin = {"pretty","json:target/uiReport.json","html:target/uiReport.html","rerun:target/uiFailedTests.txt"})
public class UiRunner {
}
