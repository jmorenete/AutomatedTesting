package com.cognizant.shoppingwebsite;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
	
	@FindBy (xpath ="//*[@id=\"search_query_top\"]")
	private WebElement textBox;
	
	public void search(String item) {
		textBox.sendKeys(item);
		
		 	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			textBox.submit();
	}
	

}
