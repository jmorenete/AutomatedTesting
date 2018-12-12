package com.cognizant.shoppingwebsite;

import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class itemSearch {
	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/jmmore/Desktop/chromedriver");
		 driver = new ChromeDriver();
	}
	
	@Test
	public void itemPresent() {
		driver.get("http://automationpractice.com/index.php");
		
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.search("Dress");
		
		ItemPage itemPage = PageFactory.initElements(driver, ItemPage.class);
					
		if(itemPage.itemFound("dress")==true) {
			
		}
		else {
			fail();
		}
	}
	
	@After
	public void teardown() {
		try {
			Thread.sleep(3000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
