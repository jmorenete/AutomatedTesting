package cognizant.Jose.PHPTravels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class roomChoice {
	
	@FindBy(xpath ="//*[@id=\"ROOMS\"]/div") 
	
	public WebElement room;
	public List<WebElement> rooms = room.findElements(By.tagName("div"));
	
	@FindBy(xpath = "//*[@id=\"ROOMS\"]/div/div[1]")
	public WebElement scrollTo; 
	
	
}
