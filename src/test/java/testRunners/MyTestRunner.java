package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src//test//resources//AppFeatures//loginPage.feature"},
		glue = {"stepdefinitions","AppHooks"},
		monochrome=true,
		//tags = "not @Skip" or ~@Smoke,
		dryRun = false,
		plugin = {"pretty"
				
		}
		)
public class MyTestRunner {

}
