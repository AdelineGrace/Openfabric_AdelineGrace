package Driver;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


	public class DriverFactory {
		
  public WebDriver driver;
  public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
  
  public WebDriver init_driver(String browser)
  {
	  System.out.println("Brower value is:" + browser);
	  if(browser.equals("chrome"))
	  {
		 
		    tlDriver.set(new ChromeDriver());
		
	  }
	  else if (browser.equals("edge"))
	  {
		  tlDriver.set(new EdgeDriver());
	  }
	  else 
	  {
		  System.out.println("Please pass the correct value:"+ browser);
	  }
	  getDriver().manage().deleteAllCookies();
	  getDriver().manage().window().maximize();
	  getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  return getDriver();
  }
	


	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}

}

