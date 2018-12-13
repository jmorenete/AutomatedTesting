package com.cognizant.jose.report;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Report {
	WebDriver driver;
	static ExtentReports reports;
	ExtentTest test;
	
	@BeforeClass
	public static void initial() {
		reports = new ExtentReports("/Users/jmmore/Desktop/Report_Test/Report.html", true);
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/jmmore/Desktop/chromedriver");
		driver = new ChromeDriver();	
		
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
	
	
	@Test
	public void test() throws Exception{
		test = reports.startTest("Bing Search for Selenium");
		driver.get("https://www.bing.com/");
		WebElement element = driver.findElement(By.id("sb_form_q"));
		element.sendKeys("Selenium");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element.submit();
		test.log(LogStatus.INFO, "Selenium is submitted");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			WebElement sideBar = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li[1]/div/div[1]/h2"));
					
			if(sideBar.getText().equals("Selenium")) {
				test.log(LogStatus.PASS, "It has found Selenium at given xpath");
			}
			else {
				test.log(LogStatus.FAIL, "It has not found Selenium at given xpath");
				fail();
			}
		} catch(Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		}
		
	}
	
	@Test
	public void test2() throws Exception{
		test = reports.startTest("Bing Search for Kittens");
		driver.get("https://www.bing.com/");
		WebElement element = driver.findElement(By.id("sb_form_q"));
		element.sendKeys("kitten");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		element.submit();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			WebElement sideBar = driver.findElement(By.xpath("//*[@id=\"b_context\"]/li/div/div[2]/h2"));
					
			if(sideBar.getText().equals("Kitten")) {
				test.log(LogStatus.PASS, "It has found kitten at given xpath");
			}
			else {
				test.log(LogStatus.FAIL, "It has not found kitten at given xpath");
				fail();
			}
		} catch(Exception e) {
			test.log(LogStatus.FAIL, e.getStackTrace().toString());
			fail();
		}
		
	}

}
