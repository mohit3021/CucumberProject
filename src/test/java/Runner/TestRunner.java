package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


	@RunWith(Cucumber.class)
	@CucumberOptions(features="Features", glue={"StepDef"}, format = {"pretty", "html:target/cucumber-html-report"})
	public class TestRunner {
	}

	
