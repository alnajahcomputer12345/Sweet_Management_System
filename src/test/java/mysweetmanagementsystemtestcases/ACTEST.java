package mysweetmanagementsystemtestcases;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
	features="user_cases",
	plugin = {"summary","html:target/cucumber/report.html"},
			 monochrome = true,
			 snippets = SnippetType.CAMELCASE,
			glue = "mysweetmanagementsystemtestcases" // Ensure this path is correct
		)

public class ACTEST {

}
