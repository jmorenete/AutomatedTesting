package com.cognizant.jose.BDDCucumber;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Step {
	WebDriver driver;
	int counter = 0;
	
	@Before
	public void setup() {
	
		if(counter == 0) {
			//BeforeClass Logic.
		}
		counter++;
	
	System.setProperty("webdriver.chrome.driver", "/Users/jmmore/Desktop/chromedriver");
	driver = new ChromeDriver();
	System.out.println("hi");
	}
	
	@After
	public void teardown() throws InterruptedException {	
		Thread.sleep(500);
		driver.quit();
	}
	
	@Given("^the correct web address$")
	public void the_correct_web_address() {
		driver.get("http://automationpractice.com/index.php");
		
		Assert.assertEquals("Page not found or reached", "http://automationpractice.com/index.php", driver.getCurrentUrl());
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws InterruptedException {
		WebElement menu = driver.findElement(By.linkText("Women"));
		System.out.println(driver.getCurrentUrl());
		menu.click();
		Thread.sleep(500);
		
		Assert.assertEquals("http://automationpractice.com/index.php?id_category=3&controller=category", driver.getCurrentUrl());
		
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() throws Exception {
		WebElement browse = driver.findElement(By.id("center_column")).findElement(By.xpath("//*[@id=\"center_column\"]/ul"));
		
		
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
