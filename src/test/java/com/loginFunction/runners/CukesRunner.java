package com.loginFunction.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html"
        },
        features = "src/test/resources/features",
        glue = "com/loginFunction/step_definitions",
        dryRun = true,
        tags = ""
)
public class CukesRunner {
}
