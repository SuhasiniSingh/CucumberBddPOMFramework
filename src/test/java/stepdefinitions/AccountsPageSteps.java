package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.Pages.AccountsPage;
import com.Pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountsPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private AccountsPage accountsPage;
	
	@Given("user has already logged into an application")
	public void user_has_already_logged_into_an_application(DataTable credTable) {
	 List<Map<String,String>>  crdList= credTable.asMaps();
		String userName = crdList.get(0).get("username");
		String password = crdList.get(0).get("password");
		  DriverFactory.getDriver()
		   .get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountsPage = loginPage.doLogin(userName, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
	  String accountsPageTitle =  accountsPage.getAccountsPagetitle();
	  System.out.println("Accounts Page title is " + accountsPageTitle);
	}

	@Then("user gets Accounts section")
	public void user_gets_accounts_section(DataTable sectionsTable) {
		List<String> expAccountscountsList = sectionsTable.asList();
		System.out.println("Expected accounts section list " + expAccountscountsList);
		List<String> actualAccountscountsList = accountsPage.getAccountsSectionsList();
		System.out.println("Actual accounts section list " + actualAccountscountsList);
		Assert.assertTrue(expAccountscountsList.containsAll(actualAccountscountsList));
		
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedSectionCount) {
	 Assert.assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
	}

	
	
}
