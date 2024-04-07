package runner;
import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.junit.CucumberOptions;

@Cucumber
@CucumberOptions(
        features = {"src/test/resources/features/Request.feature"},
        glue = {"Stepdefs"}
)
public class Runner {
}

