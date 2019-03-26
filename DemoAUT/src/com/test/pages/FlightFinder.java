package com.test.pages;

import java.util.HashMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.test.library.WebElementOperations;

public class FlightFinder {
	private String flightLinkXpath= ".//a[text()='Flights']";
	private String roundTripXpath ="//input[@value='roundtrip']";
	private String oneWayTripXpath="//input[@value='oneway']";
	private String passengersCountXpath="//select[@name='passCount']";
	private String departingFromXpath="//select[@name='fromPort']";
	private String departureMonthXpath="//select[@name='fromMonth']";
	private String departureDateXpath="//select[@name='fromDay']";
	private String arrivingInXpath="//select[@name='toPort']";
	private String returningMonthXpath="//select[@name='toMonth']";
	private String returningDateXpath="//select[@name='toDay']";
	private String economyclassXpath ="//input[@value='Coach']";
	private String businessclassXpath="//input[@value='Business']";
	private String firstclassXpath="//input[@value='First']";
	private String airlineXpath="//select[@name='airline']";
	private String findFlightXpath="//input[@name='findFlights']";
	
	private WebDriver driver;
	
	public FlightFinder(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void clickFlightLink() 
	{
			driver.findElement(By.xpath(flightLinkXpath)).click();
	}
	
	private void selectTripType(String strTripType) 
	{
		if(strTripType.equals("RoundTrip"))
		{
			driver.findElement(By.xpath(roundTripXpath)).click();
		}
		else if (strTripType.equals("OneWay"))
		{
			driver.findElement(By.xpath(oneWayTripXpath)).click();
		}
	}
	
	private void selectPassengersCount(String strPassengersCount) 
	{
			WebElement passengers = driver.findElement(By.xpath(passengersCountXpath));
			WebElementOperations.selectWebList(passengers, strPassengersCount);
	}
	
	private void selectDepartingFrom(String strDepartureFrom) 
	{
			WebElement departure = driver.findElement(By.xpath(departingFromXpath));
			WebElementOperations.selectWebList(departure, strDepartureFrom);
	}
	
	private void selectDepartureMonth(String strDepartureMonth) 
	{
			WebElement departureMonth = driver.findElement(By.xpath(departureMonthXpath));
			WebElementOperations.selectWebList(departureMonth, strDepartureMonth);
	}
	
	private void selectDepartureDay(String strDepartureDay) 
	{
			WebElement departureDay = driver.findElement(By.xpath(departureDateXpath));
			WebElementOperations.selectWebList(departureDay, strDepartureDay);
	}
	
	private void selectArrivingIn(String strArrivingIn) 
	{
			WebElement arrival = driver.findElement(By.xpath(arrivingInXpath));
			WebElementOperations.selectWebList(arrival, strArrivingIn);
	}
	
	private void selectReturnMonth(String strReturnMonth) 
	{
			WebElement returnMonth = driver.findElement(By.xpath(returningMonthXpath));
			WebElementOperations.selectWebList(returnMonth, strReturnMonth);
	}
	
	private void selectReturnDay(String strReturningDay) 
	{
			WebElement returnDay = driver.findElement(By.xpath(returningDateXpath));
			WebElementOperations.selectWebList(returnDay, strReturningDay);
	}
	
	private void selectServiceClass(String strServiceClass) 
	{
		if(strServiceClass.equals("EconomyClass")){
			driver.findElement(By.xpath(economyclassXpath)).click();
		}
		else if (strServiceClass.equals("BusinessClass")){
			driver.findElement(By.xpath(businessclassXpath)).click();
		}
		else if (strServiceClass.equals("FirstClass")){
			driver.findElement(By.xpath(firstclassXpath)).click();
		}
	}
	
	private void selectAirline(String strAirline) 
	{
			WebElement airline = driver.findElement(By.xpath(airlineXpath));
			WebElementOperations.selectWebList(airline, strAirline);
	}
	
	private void clickSearchFlight() 
	{
			driver.findElement(By.xpath(findFlightXpath)).click();
	}
	
	public void procedureSearchFlight(HashMap<String, String> searchFlight){
		
		//get values from the data sheet
		String sTripType = searchFlight.get("TripType");
		String sPassengersCount = searchFlight.get("PassengersCount");
		String sDepartureFrom = searchFlight.get("DepartureFrom");
		String sDepartureMonth = searchFlight.get("DepartureMonth");
		String sDepartureDay = searchFlight.get("DepartureDay");
		String sArrivingIn = searchFlight.get("ArrivingIn");
		String sReturnMonth = searchFlight.get("ReturnMonth");
		String sReturningDay = searchFlight.get("ReturningDay");
		String sServiceClass = searchFlight.get("ServiceClass");
		String sAirline = searchFlight.get("Airline");	
		
		//fill data entry form
		clickFlightLink();
		selectTripType(sTripType);
		selectPassengersCount(sPassengersCount);
		selectDepartingFrom(sDepartureFrom);
		selectDepartureMonth(sDepartureMonth);
		selectDepartureDay(sDepartureDay);
		selectArrivingIn(sArrivingIn);
		selectReturnMonth(sReturnMonth);
		selectReturnDay(sReturningDay);
		selectServiceClass(sServiceClass);
		selectAirline(sAirline);
		clickSearchFlight();
	}
}
