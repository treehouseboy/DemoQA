package com.qa.quickstart.ActionPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DemoQAResizeablePage {
	
	@FindBy(xpath = "//*[@id=\"resizable\"]/div[3]") WebElement resize;
	
	public void resize(WebDriver driver) {
		Actions action = new Actions(driver);
		action.clickAndHold(resize).moveByOffset(100, 100).release().perform();
	}

}
