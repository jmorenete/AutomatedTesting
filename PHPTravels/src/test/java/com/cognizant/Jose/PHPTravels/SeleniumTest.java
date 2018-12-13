package com.cognizant.Jose.PHPTravels;

//Purpose is to check whether we have correctly booked a hotel room in London for 3 nights and 3 people.

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTest {
	WebDriver driver;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/jmmore/Desktop/chromedriver");
		 driver = new ChromeDriver();
		
	}
	
	@Test
	public void testBooking() {
		 
		 driver.get("https://www.phptravels.net/hotels/detail/London/Grand-Plaza-Apartments");
		 Actions action  = new Actions(driver);
//
//		 List<WebElement> rooms = driver.findElement(By.xpath("//*[@id=\"ROOMS\"]/div")).findElements(By.tagName("div"));
//		 WebElement scrollTo = driver.findElement(By.xpath("//*[@id=\"ROOMS\"]/div/div[1]"));
//		 WebElement bookButton = driver.findElement(By.xpath("//*[@id=\"ROOMS\"]/div/button"));
//		 WebElement right = null;
//		 
//		 try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
		 action.moveToElement(scrollTo).perform();
		 action.sendKeys(Keys.PAGE_DOWN).perform();
		 

//		 WebElement button = right.findElement(By.className("control__indicator"));
//		 button.click();
//		 bookButton.click();
		 
		 WebElement firstName = driver.findElement(By.xpath("//*[@id=\"guestform\"]/div[1]/div[2]/input"));
		 WebElement lastName = driver.findElement(By.xpath("//*[@id=\"guestform\"]/div[1]/div[3]/input"));
		 WebElement email = driver.findElement(By.xpath("//*[@id=\"guestform\"]/div[2]/div[2]/input"));
		 WebElement email2 = driver.findElement(By.xpath("//*[@id=\"guestform\"]/div[2]/div[3]/input"));
		 WebElement tel = driver.findElement(By.xpath("//*[@id=\"guestform\"]/div[3]/div[2]/input"));
		 WebElement address = driver.findElement(By.xpath("//*[@id=\"guestform\"]/div[4]/div[2]/input"));
		 WebElement country = driver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]/a/span[1]"));
		 WebElement confirm = driver.findElement(By.xpath("//*[@id=\"body-section\"]/div/div/div[1]/div/div[1]/div[2]/div[4]/button"));
		 
		 action.click(firstName).sendKeys("j").perform();
		 action.click(lastName).sendKeys("j").perform();
		 action.click(email).sendKeys("jj@mail.com").perform();
		 action.click(email2).sendKeys("jj@mail.com").perform();
		 action.click(tel).sendKeys("j").perform();
		 action.click(address).sendKeys("j").perform();
		 try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 action.click(country).sendKeys("a").sendKeys(Keys.ENTER).perform();
		 action.click(confirm).perform();
		 
		 
		 try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		 System.out.println(driver.getCurrentUrl());
		 boolean invoice = driver.getCurrentUrl().contains("invoice");
		 assertEquals("Invoice URL not reached",true,invoice);
		 
		
	}
	
	
	@After
	public void teardown() {
		try {
			Thread.sleep(9000); //otherwise thread doesn't sleep even if window appears to be closed.
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}

}
