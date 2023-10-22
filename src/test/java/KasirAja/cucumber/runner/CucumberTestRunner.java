import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/KasirAja/cucumber/resource/features",
        glue = "KasirAja.cucumber.stepDef", // Specify the package name here
        plugin = {"html:target/HTML_report.html"}
)
public class CucumberTestRunner {

}
