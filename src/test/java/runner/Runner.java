package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


	@RunWith(Cucumber.class)
	@CucumberOptions
	(
	features="classpath:feature",
			//below is for remote machine and above one is for ur own VDI
	//		features="C:/Users/automatedtesting4/.jenkins/workspace/NewSCD WebApplication Functionality/src/test/java/feature/NewSCDLoginFeature.feature",
			glue= {"stepdefinition"},
		plugin={"pretty", "html:target/cucumber-reports/cucumberhtml.html", "json:target/cucumber-reports/CucumberTestReport.json",
				"junit:target/cucumber-reports/Cucumberjunit.xml"},
	//plugin = ("json:target/cucumber-reports/CucumberTestReport.json"),
		//1)from 1 to 5 for creating new user by admin user,test data file name "create new user formdetails"
				//tags="@Smoketest1 or @Smoketest2 or @Smoketest3 or @Smoketest4 or @Smoketest5",	
				
				
		//2)for editing a already created user by admin,test data file name "edit user details & delete"	 
	//tags="@Smoketest1 or @Smoketest2 or @Smoketest6",
	
			//3)for deleting a already created user by admin,test data file name "edit user details & delete"	 
			//tags="@Smoketest1 or @Smoketest2 or @Smoketest7",
	
			//4)
			tags="@Smoketest1 or @Smoketest5 or @Smoketest8 or Smoketest9 or @Smoketest10",
			publish = true,
			
			//@Smoketest2 or @Smoketest3 or @Smoketest4 or @Smoketest5
			//tags="@Smoketest1 or @Smoketest5 or @Smoketest10",
	monochrome = true
			)
		
	public class Runner {

}
//1)feture file location chnage2)cinfig location in base3)chromedriver location  chnage