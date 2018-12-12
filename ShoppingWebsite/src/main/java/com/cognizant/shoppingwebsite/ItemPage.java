package com.cognizant.shoppingwebsite;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class ItemPage {

	@FindBys({
	@FindBy(id = "center_column"),
	@FindBy(tagName = "h5")
	})
	public List<WebElement> itemList;
	
	public boolean itemFound(String searchterm) {
		
		boolean itemExists = false;
		
		for(WebElement item: itemList) {
			String value = item.getText();
			try {
				if(value.contains(searchterm)) {
					itemExists = true;
					break;
				}
			}
			catch(Exception e) {
				
			}
			
		}
		return itemExists;
	}
}
