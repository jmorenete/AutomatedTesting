package com.cognizant.shoppingwebsite;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class itemSearch {
	WebDriver driver;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/jmmore/Desktop/chromedriver");
		 driver = new ChromeDriver();
		 
	
	}
	
	@Test
	public void itemSearch() {
		
		driver.get("http://automationpractice.com/index.php");
		
		WebElement textBox = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
		String searchItem = "dress";
		textBox.sendKeys(searchItem);
		
		 	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			textBox.submit();
			
		List<WebElement> dress = driver.findElement(By.id("center_column")).findElements(By.tagName("h5"));
		
		boolean dressExists = false;
		
		for(int i=0;i<dress.size();i++) {
			String value = dress.get(i).getText();
			System.out.println(value);
			if(value.toLowerCase().contains(searchItem)) {
				dressExists = true;
			}
			else {
				dressExists = false;
			}
		}
		boolean present;
		try {
			   driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
			    present = true;
			} 
		catch (NoSuchElementException e) {
			   present = false;
			}
		
		boolean success = present & !dressExists;
		
		
		assertEquals("Item not found",false,success);
		
	}
	
	
	@After
	public void teardown() {
		try {
			Thread.sleep(20000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
