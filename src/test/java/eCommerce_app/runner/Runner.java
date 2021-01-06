package eCommerce_app.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resource/features",
        glue = "eCommerce_app/stepDef",
        tags = "@CompletePurchaseAndTapOnCheckBox",
        dryRun = false,
        plugin = {"pretty","json:target/appiumTest.json","rerun:target/failedTests.txt"}
)
public class Runner {
}
