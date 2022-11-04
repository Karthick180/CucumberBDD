package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/Login.feature", glue= {"StepDefinitions"},
monochrome = true, plugin = {"pretty", "html:Reports/HtmlReports/FirstReport.html","json:Reports/JSONReports/jsonReport.json","junit:Reports/JUnitReports/XmlReport.xml"}
)
public class TestRunner {

}
