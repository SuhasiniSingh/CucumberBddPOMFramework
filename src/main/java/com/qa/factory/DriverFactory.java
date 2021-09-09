package com.qa.factory;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.util.ElementUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	/**
	 * This method is used to initailize the threadlocal driver on the basis of given browser
	 * 
	 * @param browser
	 * @return
	 */
	public  WebDriver init_driver(String browser) {
		
		System.out.println("browser value is : " + browser);
		
		if(browser.equals("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			
			tlDriver.set(new ChromeDriver());
			
		}
		 else if (browser.equals("firefox")) {
			
		WebDriverManager.firefoxdriver().setup();
		
		tlDriver.set(new FirefoxDriver());
	}
		
		 
		 else if (browser.equals("safari")) {
			 
		tlDriver.set(new SafariDriver());
	}
		 else {
			 System.out.println("please pass the correct value of browser" + browser);
		 }
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(ElementUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(ElementUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		return getDriver();
		
}
	
	/**
	 * This is used to get the driver with threadlocal
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		
		return tlDriver.get();
		
	}

}