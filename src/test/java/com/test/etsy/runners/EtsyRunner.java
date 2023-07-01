package com.test.etsy.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/test/smartbear",//feature files location
        glue = "com/test/etsy/stepdefinitions",//step definition files location
        dryRun=true,
        tags = "@regression",
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt"}
)
public class EtsyRunner {
}
