package com.cognizant.Jose.PHPTravels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class roomChoice {
	
	@FindBys({
		@FindBy(xpath ="//*[@id=\"ROOMS\"]/div"), 
		@FindBy(tagName = "div")
	})
	public List<WebElement> rooms;
	
	@FindBy(xpath = "//*[@id=\"ROOMS\"]/div/div[1]")
	public WebElement scrollTo; 
	
	@FindBy(xpath = "//*[@id=\"ROOMS\"]/div/button")
	public WebElement bookButton;
	
	public void hotelBooking() {
		WebElement right = null;

		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		 
		 for(WebElement room:rooms) { 
			String roomsClass = room.getAttribute("class");
			
			if(roomsClass.equals("col-md-10 col-xs-7 g0-left")) {
				String text = room.findElement(By.tagName("small")).getText();
				if(text.contains("ADULTS 3")) {
					right = room;
					break;
				}
				continue;
			}
		 }
		 WebElement button = right.findElement(By.className("control__indicator"));
		 button.click();
		 bookButton.click();
	}
//	@FindBy()
//	public WebElement ki;
}
