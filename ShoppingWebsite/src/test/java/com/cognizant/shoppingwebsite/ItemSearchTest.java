package com.cognizant.shoppingwebsite;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ItemSearchTest {
	WebDriver driver;
	static ExtentReports reports;
	ExtentTest test;
	
	@BeforeClass
	public static void initial() {
		reports = new ExtentReports("/Users/jmmore/Desktop/Report_Test/ReportShopping.html", true);
		
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/jmmore/Desktop/chromedriver");
		 driver = new ChromeDriver();
	}
	
	@Test
	public void itemPresent() throws IOException {
		test = reports.startTest("Check whether products of searched item are returned");
		
		driver.get("http://automationpractice.com/index.php");
		
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
	
		mainPage.search(Consts.ITEMNAME);
		test.log(LogStatus.INFO, "Item: "+ Consts.ITEMNAME + " searched");
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(srcFile.getAbsolutePath());
				
		//Utils.copy(srcFile.getAbsolutePath(), "/Users/jmmore/Desktop/screen.png");
		
		Utils.copy2(srcFile, "/Users/jmmore/Desktop/screen.png");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		ItemPage itemPage = PageFactory.initElements(driver, ItemPage.class);
		
		System.out.println(itemPage.itemFound(Consts.ITEMNAME));
		if(itemPage.itemFound(Consts.ITEMNAME)==true) {
			test.log(LogStatus.PASS, Consts.ITEMNAME+ " (item) found in returned list");
		}
		else {
			test.log(LogStatus.FAIL, Consts.ITEMNAME+ "(item) not found");
			fail();
		}
	}
	
	@After
	public void teardown() {
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
	@AfterClass
	public static void end() {
		reports.close();
	}

}
