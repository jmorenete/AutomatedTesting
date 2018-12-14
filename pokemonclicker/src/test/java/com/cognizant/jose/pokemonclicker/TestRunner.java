package com.cognizant.jose.pokemonclicker;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/jmmore/Desktop/chromedriver");
		driver = new ChromeDriver();
		start();
		walkCatch();
		Thread.sleep(2000);
		
	}
	public static void start() {
		JUnitCore.runClasses(TaskOne.class);
	}
	public static void walkCatch() {
		JUnitCore.runClasses(TaskTwo.class);
	}

}
