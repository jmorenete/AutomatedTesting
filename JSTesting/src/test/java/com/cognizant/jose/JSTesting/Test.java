package com.cognizant.jose.JSTesting;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class Test {
	
WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/jmmore/Desktop/chromedriver");
		 driver = new ChromeDriver();
		
	}
	
	@After
	public void teardown() throws InterruptedException {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@org.junit.Test
	public void test() throws InterruptedException {
		driver.get("https://www.bing.com");		
		driver.findElement(By.id("sb_form_q")).sendKeys("helooooo");
		
		((JavascriptExecutor)driver).executeScript("document.getElementById(\"sb_form_q\").value = 'Changed'");
		Thread.sleep(1000);

		
	}
}
