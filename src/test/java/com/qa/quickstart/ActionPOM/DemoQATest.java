package com.qa.quickstart.ActionPOM;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class DemoQATest {

	WebDriver driver;
	WebElement checkElement;
	
	public static ExtentReports report;
	public ExtentTest test;
	
	@BeforeClass
	public static void startReport(){
		report = new ExtentReports("C:\\WebDev\\Reports\\DemoQAReport.html", true);	
	}
	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDev\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	
	@Test
	public void testDragBox() {
		
		test = report.startTest("Check that automated drag and drop works");
		
		test.log(LogStatus.INFO, "Browser has started");
		
		driver.get("http://demoqa.com/droppable/");
		DemoQADroppablePage page = PageFactory.initElements(driver, DemoQADroppablePage.class);
		page.dragBox(driver);
		checkElement = driver.findElement(By.xpath("//*[@id=\"droppableview\"]/p"));
		
		if(checkElement.getText().equals("Dropped!")) {
			test.log(LogStatus.PASS, "Box successfully dragged and dropped");
			
		} else {
			test.log(LogStatus.FAIL, "Drag and drop failed");
		}
		assertEquals("Dropped!", checkElement.getText());
	}
	
	@Test
	public void testMultiSelect() {
		
		test = report.startTest("Check that multi-select works");
		
		test.log(LogStatus.INFO, "Browser has started");
		
		driver.get("http://demoqa.com/selectable/");
		DemoQASelectablePage page = PageFactory.initElements(driver, DemoQASelectablePage.class);
		List<WebElement> checkList = page.multiSelect(driver);
		// assertEquals("ui-widget-content ui-corner-left ui-selected",
		// checkList.get(0).getAttribute("class"));
		if(checkList.get(0).getAttribute("class").contains("ui-selected")) {
			test.log(LogStatus.PASS, "Multi-select successful");
			
		} else {
			test.log(LogStatus.FAIL, "Multi-select fail");
		}
		
		for (int i = 0; i <= 6; i += 2) {
			assertTrue(checkList.get(i).getAttribute("class").contains("ui-selected"));
		}
	}
	
	@Test
	public void testResize() {
		
		test = report.startTest("Check that resize works");
		
		test.log(LogStatus.INFO, "Browser has started");
		
		driver.get("http://demoqa.com/resizable/");
		DemoQAResizeablePage page = PageFactory.initElements(driver, DemoQAResizeablePage.class);
		checkElement = driver.findElement(By.id("resizable"));
		String size = checkElement.getCssValue("width") + checkElement.getCssValue("height");
		page.resize(driver);
		
		if(size != checkElement.getCssValue("width") + checkElement.getCssValue("height")) {
			test.log(LogStatus.PASS, "Resize successful");
			
		} else {
			test.log(LogStatus.FAIL, "Resize fail");
		}
		
		assertNotEquals(size, checkElement.getCssValue("width") + checkElement.getCssValue("height"));		
	}

	
	@After
	public void teardown() {
		report.endTest(test);
		driver.quit();
	}
	
	@AfterClass
	public static void endReport() {
		report.flush();	
	}

}
