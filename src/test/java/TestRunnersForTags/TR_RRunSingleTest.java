package TestRunnersForTags;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/FeaturesWithTags/Tags.feature", glue= {"StepDefinitions"},
        monochrome = true, tags = "(@smoke and @regression) and @important" // we can use  or to choose multiple tags
)
public class TR_RRunSingleTest {

}
