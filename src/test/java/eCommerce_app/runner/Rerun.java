package eCommerce_app.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/failedTests.txt",
        glue = "eCommerce_app/stepDef",
        plugin = {"rerun:target/failedTests.txt"}
)
public class Rerun {
}
