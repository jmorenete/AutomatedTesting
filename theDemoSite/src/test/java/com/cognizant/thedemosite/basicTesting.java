package com.cognizant.thedemosite;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class basicTesting {
	WebDriver driver;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/jmmore/Desktop/chromedriver");
		 driver = new ChromeDriver();
		 
		 driver.get("http://thedemosite.co.uk/addauser.php");
			
			WebElement userName = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
			WebElement password = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
			WebElement save = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
			userName.sendKeys("jjjj");
			password.sendKeys("zzzz");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			save.click();

			
	}
	
	@Test
	public void userLogin() {
		
		driver.manage().window().maximize();
		driver.get("http://thedemosite.co.uk/login.php");
		

		WebElement userLog = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
		WebElement passLog = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
		WebElement login = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));
		
		userLog.sendKeys("jjjj");
		passLog.sendKeys("zzzz");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		login.click();
		WebElement success = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));

		
		assertEquals("User logged in",true,success.isDisplayed());
		
	}
	
	
	@After
	public void teardown() {
		try {
			Thread.sleep(5000); //otherwise thread doeesnt sleep even if window appears to be closed.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}

