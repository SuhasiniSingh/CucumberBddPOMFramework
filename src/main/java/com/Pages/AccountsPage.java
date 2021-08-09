package com.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;
	
	private By accountSelectors = By.cssSelector("div#center_column span");
	
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		
	}
	public String getAccountsPagetitle() {
		return driver.getTitle();
	}
	
	public int getAccountsSectionCount() {
		return driver.findElements(accountSelectors).size();
	}
	
	public List<String> getAccountsSectionsList() {
		List<String> accountsList = new ArrayList<>();
		List<WebElement > accountsHeaderList= driver.findElements(accountSelectors);
		
		for(WebElement e :accountsHeaderList ) {
			String text= e.getText();
			accountsList.add(text);
		}
		return accountsList;
	}
	
}
