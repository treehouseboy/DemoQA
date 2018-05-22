package com.qa.quickstart.ActionPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class DemoQADroppablePage {
	
	@FindBy(id = "draggableview") private WebElement dragBox;
	@FindBy(id = "droppableview") private WebElement dropBox;
	
	
	public void dragBox(WebDriver driver) {
		Actions action = new Actions(driver);
		action.dragAndDrop(dragBox, dropBox).perform();
		
	}
	

}


