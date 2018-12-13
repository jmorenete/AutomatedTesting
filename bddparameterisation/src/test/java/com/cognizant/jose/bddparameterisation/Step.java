package com.cognizant.jose.bddparameterisation;

import cucumber.api.PendingException;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {
	WebDriver driver;
	static int counter = 0;
	static ExtentReports reports;
	ExtentTest test;
	String searchTerm;
	
	@Before
	public void setup() {
		if(counter==0) {
			reports = new ExtentReports("/Users/jmmore/Desktop/Report_test/reportParam.html");
		}
		
		System.setProperty("webdriver.chrome.driver", "/Users/jmmore/Desktop/chromedriver");
		driver = new ChromeDriver();
		counter++;
	}
	
	@After
	public void teardown() {
		reports.endTest(test);
		reports.flush();
		driver.quit();
				
		if(counter == 4) {
			reports.close();
		}
	}
	
	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String arg1) throws Exception {
		String title="";
		switch(counter) {
		case(1):
			title = "First search";
		case(2):
			title = "Second search";
		case(3):
			title = "Third search";
		case(4):
			title = "Fourth search";
		}
		
	    test = reports.startTest(title);
		driver.get(arg1);
	    Thread.sleep(1000);
	    String currentURL = driver.getCurrentUrl();
	    
	    if(currentURL.contains("bing")) {
	    	test.log(LogStatus.PASS, "Right website returned");
	    }
	    else {
	    	test.log(LogStatus.FAIL, "Wrong website returned");
	    	fail();
	    }
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Exception {
		searchTerm = arg1.toLowerCase();
		WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"sb_form_q\"]"));
		searchBox.sendKeys(arg1);
		Thread.sleep(500);
		
		searchBox.submit();	   
	}

	@Then("^I am taken to a list of data for that search$")
	public void i_am_taken_to_a_list_of_data_for_that_search() throws Exception {
	   List<WebElement> results = driver.findElement(By.id("b_results")).findElements(By.tagName("h2"));
	   boolean itemFound = false;
	  
	   for(WebElement element :results) {
		   if(element.getText().toLowerCase().contains(searchTerm)) {
			   itemFound = true;
			   break;
		   }
	   }
	   
	   if(itemFound) {
		   test.log(LogStatus.PASS, "Search term is in the returned page");
	   }
	   else {
		   test.log(LogStatus.FAIL, "Search term is NOT in the returned page");
	   }
	   
	}

}
