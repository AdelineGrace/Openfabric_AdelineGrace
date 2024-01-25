package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Openfabric_page {
	
	 By LoginWithOther = By.xpath("//div/a[contains(@class, 'of-button') and contains(@class, 'of-button--login')]");
	 By Register       = By.xpath("//p/a[contains(text(), 'Register')]");
	 By FirstName      = By.xpath("//div/input[contains(@formcontrolname, 'firstName')]");
	 By LastName       = By.xpath("//div/input[contains(@formcontrolname, 'lastName')]");
	 By Email          = By.xpath("//div/input[contains(@formcontrolname, 'email')]");
     By Terms          = By.xpath("//span/input[contains(@type,'checkbox')]");
     By RegisterWithWallet = By.xpath("//div/strong[contains(.,'Register with {{walletType}}')]");
     By Firstname_errmsg = By.xpath(" //div//mat-error[contains(.,' The first name is required ')] ");
     By Lastname_errmsg  = By.xpath(" //div//mat-error[contains(.,' The last name is required ')] ");
     By Email_errmsg     = By.xpath(" //div//mat-error[contains(.,' The email is required ')] ");
     By InvCrede_errmsg     = By.xpath(" //div//mat-error[contains(.,' Invalid credentials ')] ");
  

     private WebElement placeholder;

		
   WebDriver driver; 		
		public  Openfabric_page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		public void Click_LoginWithOther() throws InterruptedException
		{
			driver.findElement(LoginWithOther).click();
		}
		public void Click_Register() throws InterruptedException
		{
			driver.findElement(Register).click();
		}
		
		public void Enter_FirstName() throws InterruptedException
		{
			driver.findElement(FirstName).sendKeys("George");
		}
		public void Enter_LastName() throws InterruptedException
		{
			driver.findElement(LastName).sendKeys("Nick");
		}
		public void Enter_Email() throws InterruptedException
		{
			driver.findElement(Email).sendKeys("georgenick@gmail.com");
		}
		public void Enter_InvalidEmail() throws InterruptedException
		{
			driver.findElement(Email).sendKeys("$$$$");
		}
		public void Click_Terms() throws InterruptedException
		{
			driver.findElement(Terms).click();
		}
		public void Click_RegisterWithWallet() throws InterruptedException
		{
			driver.findElement(RegisterWithWallet).click();
		}
		public String FirstName_errMsg() throws InterruptedException
		{
			return driver.findElement(Firstname_errmsg).getText();
		}
		public String LastName_errMsg() throws InterruptedException
		{
			return driver.findElement(Lastname_errmsg).getText();
		}
		public String Email_errMsg() throws InterruptedException
		{
			return driver.findElement(Email_errmsg).getText();
		}
		public String InvCredentials_errMsg() throws InterruptedException
		{
			return driver.findElement(InvCrede_errmsg).getText();
		}
		
		 public WebElement CreateInstance() {
		        return placeholder;
		    }
		 public WebElement Click_CreateInstance() {
		        return placeholder;
		    }
		 public WebElement Infrastructure() {
		        return placeholder;
		    }
		 public WebElement Click_Infrastructure() {
		        return placeholder;
		    }
}
