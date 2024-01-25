package ApplicationHooks;


import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import Driver.DriverFactory;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import utilities.ConfigReader;


public class AppHooks {
	
	public static DriverFactory driverFactory;
public static WebDriver driver;

public static ConfigReader configReader;
	public static Properties prop;
	@BeforeAll (order=0)
	public static void getProperty() throws IOException
	{
		configReader = new ConfigReader();
		prop = ConfigReader.init_prop();
	}
	@BeforeAll (order=1)
	public static void launchBrowser() throws InvalidFormatException, IOException
	{
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
				}
		
	@AfterAll 
	public static void quitBrowser()
	{
		driver.quit();
	}


}
