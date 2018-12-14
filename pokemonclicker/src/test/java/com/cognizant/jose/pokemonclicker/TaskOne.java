package com.cognizant.jose.pokemonclicker;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class TaskOne {
	WebDriver driver = TestRunner.driver;
	
	@Before
	public void setup() {
		
	}
	
	@After
	public void teardown() {
	
		
	}
	
	@Test
	public void taskOne() throws NullPointerException {
		driver.get("http://ishadijcks.github.io/");
		
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		
		mainPage.pokemonChoose().click();
		mainPage.startAdventure.click();
		
		//assertEquals("Pokemon not caught",true, mainPage.successfulCaught.isDisplayed());
		
	}
	
}
