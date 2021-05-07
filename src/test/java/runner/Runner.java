package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions
	(
	features="C:/Users/Deepak.Badgotya/eclipse-workspace/NewSCD/src/test/java/feature/NewSCDLoginFeature.feature",
	glue= {"stepdefinition"},
		plugin={"pretty", "html:target/cucumber", "json:target/cucumber-reports/CucumberTestReport.json"},
	//plugin = ("json:target/cucumber-reports/CucumberTestReport.json"),
			publish = true,
	tags="@Smoketest1 or @Smoketest2",
			//tags="@Smoketest1 or @Smoketest2 or @Smoketest6", 
				//tags="@Smoketest1 or @Smoketest2 or @Smoketest7", 
			//@Smoketest2 or @Smoketest3 or @Smoketest4 or @Smoketest5
	monochrome = true
			)
		
	public class Runner {

}
