package com.qa.quickstart.ActionPOM;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class DemoQASelectablePage {

	@FindAll({ @FindBy(xpath = "//*[@id=\"selectable\"]/li") })
	List<WebElement> checkList;

	public List<WebElement> multiSelect(WebDriver driver) {
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).perform();
		for (int i = 0; i <= 6; i += 2) {
			checkList.get(i).click();
		}

		return checkList;

	}

}
