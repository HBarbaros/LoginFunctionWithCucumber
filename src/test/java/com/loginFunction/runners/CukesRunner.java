package com.loginFunction.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "json:target/cucumber.json"
        },
        features = "src/test/resources/features",
        glue = "com/loginFunction/step_definitions",
        dryRun = false,
        tags = "@TRN-1582",
        publish = false
)
public class CukesRunner {
}
