package com.cognizant.jose.pokemonclicker;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TaskTwo {
	
	@Before
	public void setup() {
		
	}
	
	@After
	public void teardown() {
	
	}
	
	@Test
	public void taskTwo() throws InterruptedException{
		Thread.sleep(1000);
		WebDriver driver = TestRunner.driver;
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

//		String[] comp = mainPage.counterText().split(" ");
//		String[] semiCount = comp[comp.length-1].split(" ");
//		semiCount = semiCount[semiCount.length-1].split("/");
//	
//		String[] firstNums = semiCount[semiCount.length - 2].split(" ");
//		
//		String firstCount = firstNums[firstNums.length-1];
//		
//		String secondCount = semiCount[semiCount.length-1];

		while(!mainPage.counterText().contains("10/10")) {	
			System.out.println(mainPage.counterText());
			try {
				mainPage.enemy.click();
			} catch (Exception e) {
				
			}
		}
		((JavascriptExecutor)driver).executeScript("document.getElementById('oakModal').remove()");
		
		((JavascriptExecutor)driver).executeScript("(document.getElementsByClassName('modal-backdrop fade in')[0]).remove()");

	}
	

}
