package com.cognizant.jose.hate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitTest {
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/jmmore/Desktop/chromedriver");
		 driver = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		try {
			Thread.sleep(2000); //otherwise thread doesn't sleep even if window appears to be closed.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
	
//	@Test
//	public void testThread() {
//		driver.get("https://christophperrins.github.io/TestingSite/");
//		MainPage mainpage = PageFactory.initElements(driver, MainPage.class);
//		
//		if(mainpage.quoteFindThread()) {
//			
//		}
//		else {
//			fail();
//		}
//		
//	}
	@Test
	public void testImplicit() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MainPage mainpage = PageFactory.initElements(driver, MainPage.class);
		
		driver.get("https://christophperrins.github.io/TestingSite/");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(mainpage.quoteText.getText());
		if(mainpage.quoteText.getText().contains("Shafeeq")) {
			
		}
		else {
			fail();
		}
	}
	
	@Test
	public void testExplicit() {
		driver.get("https://christophperrins.github.io/TestingSite/");
		
		WebElement quote = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2")));
		if(quote.getText().contains("Shafeeq")) {
			
		}
		else {
			fail();
		}
	
	}

}
