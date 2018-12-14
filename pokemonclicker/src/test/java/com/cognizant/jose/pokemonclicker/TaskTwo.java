package com.cognizant.jose.pokemonclicker;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskTwo {
	
	@Before
	public void setup() {
		
	}
	
	@After
	public void teardown() {
	
	}
	
	@Test
	public void taskTwo() throws InterruptedException{
		WebDriver driver = TestRunner.driver;
		Thread.sleep(1000);
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//WebElement enemyWait = driver.findElement(By.id("enemy"));
		
//		String[] comp = mainPage.counterText().split(" ");
//		String[] semiCount = comp[comp.length-1].split(" ");
//		semiCount = semiCount[semiCount.length-1].split("/");
//	
//		String[] firstNums = semiCount[semiCount.length - 2].split(" ");
//		
//		String firstCount = firstNums[firstNums.length-1];
//		
//		String secondCount = semiCount[semiCount.length-1];

//		System.out.println(firstN);
		//System.out.println(secondCount);
		
		while(!mainPage.counterText().contains("10/10")) {	
			System.out.println(mainPage.counterText());
			try {
				WebElement element = driver.findElement(By.id("enemy"));
				element.click();
			} catch (Exception e) {
				
			}
		}
		
	}
	

}
