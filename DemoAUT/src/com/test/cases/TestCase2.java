package com.test.cases;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.test.library.TestData;
import com.test.pages.Login;
import com.test.pages.FlightFinder;

public class TestCase2 {
	TestData data;
	WebDriver driver;
	
  @Test
  public void TC02() {
	
	//step 1 
	Login login = new Login(driver);
	login.procedureLogin(data.getData("Login", "TestUser"));
	
	//step 2
	FlightFinder flightFinder = new FlightFinder(driver);
	flightFinder.procedureSearchFlight(data.getData("FlightFinder", "TC02"));
	
  }
  
  @BeforeMethod
  @Parameters({"dataSheet","appURL","webdriverLocation"})
  public void beforeMethod(String dataSheet, String appURL, String webdriverLocation) {
	 //initializing data
	 data = new TestData(dataSheet);
	 //initializing browser
	 System.setProperty("webdriver.chrome.driver",webdriverLocation);
	 ChromeOptions options = new ChromeOptions();
	 options.addArguments("--start-maximized");
	 options.addArguments("enable-automation");
	 //options.addArguments("--headless");
	 //options.addArguments("--window-size=1920,1080");
	 options.addArguments("--no-sandbox");
	 options.addArguments("--disable-extensions");
	 options.addArguments("--dns-prefetch-disable");
	 options.addArguments("--disable-gpu");
	 options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	 driver = new ChromeDriver(options);
	 driver.get(appURL);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
