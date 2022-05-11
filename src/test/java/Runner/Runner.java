package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/sources/features",
    glue = "Steps",
    plugin = {"html:target/cucumber-html-report.html"},
    /*plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},*/
    tags = "@API"
)


public class Runner {
    
}
