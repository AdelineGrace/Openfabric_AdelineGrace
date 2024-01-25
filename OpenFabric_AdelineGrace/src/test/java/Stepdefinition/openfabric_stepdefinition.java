package Stepdefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Driver.DriverFactory;
import io.cucumber.java.en.*;
import pageobject.Openfabric_page;
import utilities.ConfigReader;
import utilities.Log;

public class openfabric_stepdefinition{
	
	public static WebDriver driver = DriverFactory.getDriver();
	Openfabric_page page = new Openfabric_page(DriverFactory.getDriver());
	
@Given("User wants to explore Openfabric AI Testnet")
public void user_wants_to_explore_openfabric_ai_testnet() {
	Log.info("Openfabric webpage navigation");
}

@When("User visits Openfabric webpage")
public void user_visits_Openfabric_webpage() throws IOException {
	driver.get(ConfigReader.getWebUrl());
	Log.info("Navigated to Home Page");
}


@Then("User lands on login page")
public void user_lands_on_login_page() {
    String expectedUrl = ConfigReader.getProperty("expectedUrl");
  	String actualUrl = driver.getCurrentUrl();
  	Assert.assertEquals(actualUrl, expectedUrl,"User is not in Openfabric login page");
}

@Given("User is in the Openfabric login page")
public void user_is_in_the_openfabric_login_page() {
    Log.info("User in Openfabric Login Page");
}

@When("User clicks Login with Metamask icon")
public void user_clicks_login_with_metamask_icon() throws InterruptedException {
	page.Click_LoginWithOther();
}

@Then("User finds the pop up with the message {string}")
public void user_finds_the_pop_up_with_the_message(String string) {
   Log.error("MetaMask Missing");
}

@Given("User finds Metamask is not installed")
public void user_finds_metamask_is_not_installed() {
    Log.info("...installing Metamask....");
}

@When("User follows onscreen instruction to install Metamask")
public void user_follows_onscreen_instruction_to_install_metamask() {
	String login_windowHandle = driver.getWindowHandle();
	String metamask_windowHandle = null;
	for (String windowHandle : driver.getWindowHandles())
	{
		if(!windowHandle.equals(login_windowHandle))
		{
			metamask_windowHandle = windowHandle;
			break;
		}
	}
	
	driver.switchTo().window(metamask_windowHandle);
   
}

@Then("User finds Metamask is installed")
public void user_finds_metamask_is_installed() {
    driver.findElement(By.id("Install Metamask for Chrome")).click();
    Log.info("MetaMask is installed");
    }

@When("User follows onscreen instruction to setup Metamask")
public void user_follows_onscreen_instruction_to_setup_metamask() {
    driver.findElement(By.id("Connect")).click();
    Log.info("Clicking connect in metamask window");
}

@Then("User connects the Openfabric AI with Metamask")
public void user_connects_the_openfabric_ai_with_metamask() {
    Log.info("....connecting...");
}

@Then("User finds Metamask is installed in the system")
public void user_finds_metamask_is_installed_in_the_system() {
	String login_windowHandle = driver.getWindowHandle();

	driver.switchTo().window(login_windowHandle);

}

@When("User Clicks {string} after Entering the valid values in the Registration Form")
public void user_clicks_after_entering_the_valid_values_in_the_registration_form(String string, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
   
   page.Click_Register();
   page.Enter_FirstName();
   page.Enter_LastName();
   page.Enter_Email();
   page.Click_Terms();
   page.Click_RegisterWithWallet();
}

@Then("User lands on the Openfabric AI Testnet page")
public void user_lands_on_the_openfabric_ai_testnet_page() {
    String expectedTestnetUrl = ConfigReader.getProperty("expectedTestnetUrl");
    String actualTestnetUrl = driver.getCurrentUrl();
    Assert.assertEquals(actualTestnetUrl, expectedTestnetUrl);
}

@When("User Clicks {string} after Entering the invalid values in the Registration Form")
public void user_clicks_after_entering_the_invalid_values_in_the_registration_form(String string, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	  page.Click_Register();
	  page.Enter_FirstName();
	   page.Enter_LastName();
	   page.Enter_InvalidEmail();
	   page.Click_Terms();
	   page.Click_RegisterWithWallet();
	   Log.error("Invalid Credentials");
    
}

@Then("User receives error message {string}")
public void user_receives_error_message(String string) throws InterruptedException {
	String ExpectederrorMessage = "Invalid Credentials";
	String ActualerrorMessage = page.InvCredentials_errMsg();
	Assert.assertEquals(ActualerrorMessage, ExpectederrorMessage);
}

@When("User Clicks {string} after Entering the missing FirstName in the Registration Form")
public void user_clicks_after_entering_the_missing_FirstName_in_the_registration_form(String string, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	   page.Click_Register();
	   page.Enter_LastName();
	   page.Enter_Email();
	   page.Click_Terms();
	   page.Click_RegisterWithWallet();
	   Log.error("FirstName Missing");

}
@Then("User receives First Name error message {string}")
public void user_receives_First_Name_error_message(String string) throws InterruptedException {
	String ExpectederrorMessage = "The first name is required";
	String ActualerrorMessage = page.FirstName_errMsg();
	Assert.assertEquals(ActualerrorMessage, ExpectederrorMessage);
}
	
@When("User Clicks {string} after Entering the missing LastName in the Registration Form")
public void user_clicks_after_entering_the_missing_LastName_in_the_registration_form(String string, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {	
	   page.Click_Register();
	   page.Enter_FirstName();
	   page.Enter_Email();
	   page.Click_Terms();
	   page.Click_RegisterWithWallet();
	   Log.error("LastName Missing");

}
@Then("User receives Last Name error message {string}")
public void user_receives_Last_Name_error_message(String string) throws InterruptedException {
	String ExpectederrorMessage = "The last name is required";
	String ActualerrorMessage = page.LastName_errMsg();
	Assert.assertEquals(ActualerrorMessage, ExpectederrorMessage);
}

@When("User Clicks {string} after Entering the missing Email in the Registration Form")
public void user_clicks_after_entering_the_missing_Email_in_the_registration_form(String string, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	   page.Click_Register();
	   page.Enter_FirstName();
	   page.Enter_LastName();
	   page.Click_Terms();
	   page.Click_RegisterWithWallet();
	   Log.error("Email Missing");

}
@Then("User receives Email error message {string}")
public void user_receives_Email_error_message(String string) throws InterruptedException {
	String ExpectederrorMessage = "The email is required";
	String ActualerrorMessage = page.Email_errMsg();
	Assert.assertEquals(ActualerrorMessage, ExpectederrorMessage);
}

@Given("User is in the Openfabric AI Testnet page")
public void user_is_in_the_openfabric_ai_testnet_page() {
    Log.info("User stays on the same Openfabric Login page");
}

@When("User clicks on {string} dropdown")
public void user_clicks_on_dropdown(String string) {
	//placeholder for dropdown 
    Log.info("Clicking AI Marketplace dropdown");
}

@Then("User sees all the available AI app")
public void user_sees_all_the_available_ai_app() {
	//placeholder for New AI app page URL
    Log.info("All available AI apps page");
}

@Then("User chooses his favorite available AI app")
public void user_chooses_his_favorite_available_ai_app() {
	//placeholder for AI app clicking
    Log.info("Clicking the favourite AI app");
}

@Then("User is not able to select his favorite available AI app")
public void user_is_not_able_to_select_his_favorite_available_ai_app() {
    Log.error("Not able to select AI app");
}

@When("User clicks on the favorite AI app")
public void user_clicks_on_the_favorite_ai_app() {
    Log.info("Click the AI app");
}

@Then("User navigates to the chosen AI app page")
public void user_navigates_to_the_chosen_ai_app_page() {
   //placeholder for selected AI app page URL validation
}

@Then("User stays on the same Openfabric Testnet page")
public void user_stays_on_the_same_openfabric_testnet_page() {
    Log.error("AI app selection failed");
}

@Given("User is in the chosen AI app")
public void user_is_in_the_chosen_ai_app() {
    Log.info("AI app page");
}

@When("User gets navigated to the chosen AI app page")
public void user_gets_navigated_to_the_chosen_ai_app_page() {
    //placeholder for WebElement AI app 
}

@Then("User sees the {string} icon")
public void user_sees_the_icon(String string) {
	WebElement icon = page.CreateInstance();
	Assert.assertTrue(icon.isDisplayed(), "+Create Instance Button is not displayed on the AI app page");
	}

@Then("User not able to see the {string} icon")
public void user_not_able_to_see_the_icon(String string) {
	WebElement icon = page.CreateInstance();
	Assert.assertFalse(icon.isDisplayed(), "+Create Instance Button is displayed on the AI app page");
}

@When("User clicks {string} icon")
public void user_clicks_icon(String string) {
    page.Click_CreateInstance(); // placeholder for WebElement Create instances
    Log.info("Clicking +Create Instances");
}

@Then("User starts the create instance flow")
public void user_starts_the_create_instance_flow() {
   Log.info("....Create instance flow starting...");
}

@Then("User doesnt get started with the create instance flow")
public void user_doesnt_get_started_with_the_create_instance_flow() {
    Log.error(" create instance flow not started");
}

@Then("User sees the options of {string}")
public void user_sees_the_options_of(String string) {
	WebElement icon = page.Infrastructure();
	Assert.assertTrue(icon.isDisplayed(), "Infrastructure option is not displayed on the AI app page");
}

@Then("User chooses the favorite Infrastructure option")
public void user_chooses_the_favorite_infrastructure_option() {
	page.Click_Infrastructure(); // placeholder for WebElement Infrastructure
    Log.info("Clicking Infrastructure");
}

@Then("User is not able to choose the favorite Infrastructure option")
public void user_is_not_able_to_choose_the_favorite_infrastructure_option() {
	WebElement icon = page.Infrastructure();
	Assert.assertFalse(icon.isDisplayed(), "Infrastructure option is displayed on the AI app page");
}

@When("User chooses an infrastructure option")
public void user_chooses_an_infrastructure_option() {
	page.Click_Infrastructure(); // placeholder for WebElement Infrastructure
    Log.info("Clicking Infrastructure");
}

@Then("User gets navigated to the Payment stage")
public void user_gets_navigated_to_the_payment_stage() {
   //placeholder for validation of Payment page URL
}

@Then("User stays on the infrastructure selection")
public void user_stays_on_the_infrastructure_selection() {
    //placeholder for not navigating to Payment page URL
}

@Given("User chosen infrastructure option")
public void user_chosen_infrastructure_option() {
    Log.info("Step 1: Infrastructure chosen");
}

@When("User sees that the Payment process started")
public void user_sees_that_the_payment_process_started() {
    //place holder for WebElement Payment flow process
}

@Then("User receives Payment success confirmation")
public void user_receives_payment_success_confirmation() {
   //placeholder for validating Payment success confirmation with Assert
}

@Then("User receives Payment process failed message")
public void user_receives_payment_process_failed_message() {
    //placeholder for validating payment failed error message
}

@Given("User has chosen the infrastructure selection for the AI app")
public void user_has_chosen_the_infrastructure_selection_for_the_ai_app() {
    Log.info("Infrastructure costs mentioned");
}

@When("User reviews the costs of both AI app and infrastructure")
public void user_reviews_the_costs_of_both_ai_app_and_infrastructure() {
    //placeholder for WebElements of price of both AI app and Infrastructure
}

@When("User gets payment successful confirmation")
public void user_gets_payment_successful_confirmation() {
    Log.info("Successfull Payment");
}

@Then("User enters the installation process of AI app")
public void user_enters_the_installation_process_of_ai_app() {
    //placeholder for validating Installation page URL
}

@When("User doesn't get payment successful confirmation")
public void user_doesn_t_get_payment_successful_confirmation() {
    Log.error("Payment failed");
}

@Then("User not able to enter the installation process of AI app")
public void user_not_able_to_enter_the_installation_process_of_ai_app() {
    //placeholder for Assertion fails validating
}

@Given("User enters installation process of AI app")
public void user_enters_installation_process_of_ai_app() {
   Log.info("Installation of AI app started");
}

@When("User sees installation complete")
public void user_sees_installation_complete() {
	//Validating if the installation is complete
	
}

@Then("User can able to access the AI app")
public void user_can_able_to_access_the_ai_app() {
	// Validating if the user can access the AI app
    // example Assert.assertTrue(user_access());
}

@Then("User not able to access the AI app")
public void user_not_able_to_access_the_ai_app() {
	// Validating if the user is not able to access the AI app
    // example Assert.assertFalse(user_access());
}

@Given("User able to access the AI app")
public void user_able_to_access_the_ai_app() {
	//placeholder code for when the user is able to access the AI app
}

@When("User follows the on-screen prompt to set up the app")
public void user_follows_the_on_screen_prompt_to_set_up_the_app() {
	// placeholder code for when the user follows on-screen prompts to set up the app
}

@When("User clicks {string}")
public void user_clicks(String string) {
	// placeholder code User clicks Run
}

@Then("User is able to set the app in motion")
public void user_is_able_to_set_the_app_in_motion() {
	// placeholder code for when the user is able to set the app in motion

}

@Then("User not able to set the app in motion")
public void user_not_able_to_set_the_app_in_motion() {
	// placeholder code for when the user is not able to set the app in motion
}

@Given("User can access the chosen AI app")
public void user_can_access_the_chosen_ai_app() {
	// placeholder code for when the user can access the chosen AI app
}

@When("User clicks ratings")
public void user_clicks_ratings() {
    //User clicks Ratings
}

@Then("User can rate the app")
public void user_can_rate_the_app() {
    //placeholder code for user rating the app
}

@Then("User not able to rate the app")
public void user_not_able_to_rate_the_app() {
    //placeholder code for user not able to rate the app
}

@When("User clicks the notes textbox")
public void user_clicks_the_notes_textbox() {
    // user clicks Notes to write his reviews on the AI app
}

@Then("User is able to add notes about the app experience")
public void user_is_able_to_add_notes_about_the_app_experience() {
    //validating Notes added Assert.assertTrue
}

@Then("User not able to add notes about the app experience")
public void user_not_able_to_add_notes_about_the_app_experience() {
    // validating Notes added Assert.assertFalse
}
}