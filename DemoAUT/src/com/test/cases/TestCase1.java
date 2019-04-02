package com.test.cases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.test.library.TestData;
import com.test.library.WebDriverOperations;
import com.test.pages.Signup;

public class TestCase1 {
	TestData data;
	WebDriver driver;
	
  @Test
  public void TC01() {
	  Signup signup = new Signup(driver);
	  signup.procedureSignUp(data.getData("Signup", "TC01"));
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