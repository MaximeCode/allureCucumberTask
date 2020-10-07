import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"glue"},
        tags = {"@all"},
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm" ,"pretty", "html:target/cucumber"}
)
public class CucumberRunner {
}
