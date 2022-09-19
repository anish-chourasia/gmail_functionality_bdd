package testRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
		(
				features="/Users/achourasia/git/gmail_functionality_bdd/Gmail_Functionality_Test/Features",
				glue="stepDefinitions",
				plugin= {"pretty","html:test-output"}
		)
public class TestRun {

	
}