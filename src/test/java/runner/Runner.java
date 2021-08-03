package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions
	(
	//features="C:/Users/Deepak.Badgotya/eclipse-workspace/NewSCD/src/test/java/feature/NewSCDLoginFeature.feature",
			//below is for remote machine and above one is for ur own VDI
			features="C:/Users/automatedtesting4/.jenkins/workspace/NewSCD WebApplication Functionality/src/test/java/feature/NewSCDLoginFeature.feature",
			glue= {"stepdefinition"},
		plugin={"pretty", "html:target/cucumber-reports/cucumberhtml.html", "json:target/cucumber-reports/CucumberTestReport.json",
				"junit:target/cucumber-reports/Cucumberjunit.xml"},
	//plugin = ("json:target/cucumber-reports/CucumberTestReport.json"),
				tags="@Smoketest1 or @Smoketest2",	
	//tags="@Smoketest1 or @Smoketest2 or @Smoketest3 or @Smoketest4 or @Smoketest5 or @Smoketest8 or @Smoketest9",
			//tags="@Smoketest1 or @Smoketest2 or @Smoketest3 or @Smoketest4 or @Smoketest5",
			publish = true,
			//tags="@Smoketest1 or @Smoketest2 or @Smoketest6", 
				//tags="@Smoketest1 or @Smoketest2 or @Smoketest7", 
			//@Smoketest2 or @Smoketest3 or @Smoketest4 or @Smoketest5
			//tags="@Smoketest1 or @Smoketest5 or @Smoketest10",
	monochrome = true
			)
		
	public class Runner {

}
//1)feture file location chnage2)cinfig location in base3)chromedriver location  chnage