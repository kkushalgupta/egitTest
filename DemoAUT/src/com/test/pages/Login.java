package com.test.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	private String signonXpath = "//a[contains(text(),'SIGN-ON')]";
	private String usernameXpath = "//input[@name='userName']";
	private String passwordXpath = "//input[@name='password']";
	private String SubmitXpath = "//input[@value='Login']";
	private WebDriver driver;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void clickSignOn(){
		driver.findElement(By.xpath(signonXpath)).click();
	}
	
	private void setUsername(String strUsername){
		driver.findElement(By.xpath(usernameXpath)).sendKeys(strUsername);
	}
	
	private void setPassword(String strPassword){
		driver.findElement(By.xpath(passwordXpath)).sendKeys(strPassword);
	}
	
	private void clickSubmit(){
		driver.findElement(By.xpath(SubmitXpath)).click();
	}
	
	private String getTitle()
	{
		return driver.getTitle();
	}
	
	public boolean procedureLogin(HashMap<String,String> credentials){
		String sUsername = credentials.get("Username");
		String sPassword = credentials.get("Password");
		String expTitle = "Welcome: Mercury Tours";
		clickSignOn();
		setUsername(sUsername);
		setPassword(sPassword);
		clickSubmit();

		return getTitle().equals(expTitle);
	}
}

