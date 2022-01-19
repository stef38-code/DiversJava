package org.example.java.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:org/example/java/cucumber",
        glue = "org.example.java",
        plugin = {"pretty", "html:target/cucumber.html",
                "junit:target/cucumber.xml",
                "json:target/cucumber-report.json"},
        monochrome = true
)
public class CucumberRunner {
}
