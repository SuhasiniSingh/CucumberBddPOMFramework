package stepdefinitions;

import java.util.Properties;

import org.junit.Assert;

import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private ConfigReader configreader;
	Properties prop;
	@Given("user is on login page")
	public void user_is_on_login_page() {
		configreader = new ConfigReader();
		prop = configreader.init_prop();
		String url =prop.getProperty("url");
	   DriverFactory.getDriver()
	.get(url);
		
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	  title= loginPage.getLoginPageTitle();  
	  System.out.println("Page title of the page " + title);
	  
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitlepage) {
	   Assert.assertTrue(title.contains(expectedTitlepage));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		Assert.assertTrue(loginPage.isForgotpwdLinkExist());
	}

	@When("user enters username {string}")
	public void user_enters_username(String uname) {
	   loginPage.enterUserName(uname);
	}
	@When("user enters password {string}")
	public void user_enters_password(String password) {
	    loginPage.enterPassword(password);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    loginPage.clickonLogin();
	}

	


}
