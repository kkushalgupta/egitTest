package com.test.library;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebElementOperations {
	
	public static void selectWebList(WebElement webList, String value){
		Select webListSelect = new Select(webList);
		webListSelect.selectByVisibleText(value);
	}
}