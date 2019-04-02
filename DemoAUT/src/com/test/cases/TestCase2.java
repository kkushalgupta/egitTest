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
import com.test.library.WebDriverOperations;
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
  @Parameters({"dataSheet","appURL","webDriverLocation"})
  public void beforeMethod(String dataSheet, String appURL, String webDriverLocation) {
	 //initializing data
	 data = new TestData(dataSheet);
	 //initializing browser
	 WebDriverOperations wdo = new WebDriverOperations();
	 driver = wdo.initializeWebDriver(webDriverLocation);
	 //navigate to AUT url
	 driver.get(appURL);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
