package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features={"classpath:features}
		features = {"src//test//resources//AppFeatures"},
		glue = {"stepdefinitions","AppHooks"},
		tags = "@Login",
		monochrome=true,
		dryRun = false,
		plugin = {"pretty"
				
		}
		)
public class MyTestRunner {

}
