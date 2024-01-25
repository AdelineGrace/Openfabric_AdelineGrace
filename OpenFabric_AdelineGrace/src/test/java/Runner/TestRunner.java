package Runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/resources/Feature"},
		glue= {"Stepdefinition","ApplicationHooks"},
		monochrome=false,  //console output color
			
		dryRun = false, 
		plugin = { "pretty",
		"json:target/cucumber-reports/reports.json", 
		"html:target/cucumber-reports/reports.html", 
		"html:test-output/index.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, 
		
		publish = true)
		 

public class TestRunner extends AbstractTestNGCucumberTests{
	@Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
				
		return super.scenarios();
    }
	
}
