package com.test.pages;

import java.util.HashMap;
import com.test.library.WebElementOperations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Signup {
	private String registerXpath = "//a[contains(text(),'REGISTER')]";
	private String firstNameXpath = "//input[@name='firstName']";
	private String lastNameXpath = "//input[@name='lastName']";
	private String phoneXpath = "//input[@name='phone']";
	private String emailXpath = "//input[@name='userName']";
	private String address1Xpath = "//input[@name='address1']";
	private String address2Xpath = "//input[@name='address2']";
	private String cityXpath = "//input[@name='city']";
	private String stateXpath = "//input[@name='state']";
	private String postalCodeXpath = "//input[@name='postalCode']";
	private String countryXpath = "//select[@name='country']";
	private String userNameXpath = "//input[@name='email']";
	private String passwordXpath = "//input[@name='password']";
	private String confirmPasswordXpath = "//input[@name='confirmPassword']";
	private String SubmitXpath = "//input[@name='register']";
	
	private WebDriver driver;
	
	public Signup(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void clickregister(){
		driver.findElement(By.xpath(registerXpath)).click();
	}
	
	private void setFirstName(String strFirstname){
		driver.findElement(By.xpath(firstNameXpath)).sendKeys(strFirstname);
	}
	
	private void setLastName(String strLastname){
		driver.findElement(By.xpath(lastNameXpath)).sendKeys(strLastname);
	}
	
	private void setPhone(String strPhone){
		driver.findElement(By.xpath(phoneXpath)).sendKeys(strPhone);
	}
	
	private void setEmail(String strEmail){
		driver.findElement(By.xpath(emailXpath)).sendKeys(strEmail);
	}
	
	private void setAddress1(String strAddress1){
		driver.findElement(By.xpath(address1Xpath)).sendKeys(strAddress1);
	}
	
	private void setAddress2(String strAddress2){
		driver.findElement(By.xpath(address2Xpath)).sendKeys(strAddress2);
	}
	private void setCity(String strCity){
		driver.findElement(By.xpath(cityXpath)).sendKeys(strCity);
	}
	
	private void setState(String strState){
		driver.findElement(By.xpath(stateXpath)).sendKeys(strState);
	}
	
	private void setPostalCode(String strPostalCode){
		driver.findElement(By.xpath(postalCodeXpath)).sendKeys(strPostalCode);
	}
	
	private void selectCountry(String strCounty){
		WebElement country = driver.findElement(By.xpath(countryXpath));
		WebElementOperations.selectWebList(country, strCounty);
	}
	
	private void setUsername(String strUsername){
		driver.findElement(By.xpath(userNameXpath)).sendKeys(strUsername);
	}
	
	private void setPassword(String strPassword){
		driver.findElement(By.xpath(passwordXpath)).sendKeys(strPassword);
	}
	
	private void setConfirmPassword(String strConfirmPassword){
		driver.findElement(By.xpath(confirmPasswordXpath)).sendKeys(strConfirmPassword);
	}
	
	private void clickSubmit(){
		driver.findElement(By.xpath(SubmitXpath)).click();
	}
	
	public void procedureSignUp(HashMap<String,String> credentials){
		
		//fill data entry form
		clickregister();
		enterContactInfromation(credentials);
		enterMailingInformation(credentials);
		enterUserInformation(credentials);
		clickSubmit();		
	}
	
	public void enterContactInfromation(HashMap<String,String> credentials)
	{
		String sFirstname = credentials.get("Firstname");
		String sLastname = credentials.get("Lastname");
		String sPhone = credentials.get("Phone");
		String sEmail = credentials.get("Email");
		
		setFirstName(sFirstname);
		setLastName(sLastname);
		setPhone(sPhone);
		setEmail(sEmail);
	}
	
	public void enterMailingInformation(HashMap<String,String> credentials){
		
		String sAddress1 = credentials.get("Address1");
		String sAddress2 = credentials.get("Address2");
		String sCity = credentials.get("City");
		String sState = credentials.get("State");
		String sPostalCode = credentials.get("PostalCode");
		String sCountry = credentials.get("Country");
		
		setAddress1(sAddress1);
		setAddress2(sAddress2);
		setCity(sCity);
		setState(sState);
		setPostalCode(sPostalCode);
		selectCountry(sCountry);
	}
	
	public void enterUserInformation(HashMap<String,String> credentials)
	{
		String sUsername = credentials.get("Username");
		String sPassword = credentials.get("Password");
		
		setUsername(sUsername);
		setPassword(sPassword);
		setConfirmPassword(sPassword);
	}
	
	
}