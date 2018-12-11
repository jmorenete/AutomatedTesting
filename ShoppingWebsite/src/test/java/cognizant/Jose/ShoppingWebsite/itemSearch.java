package cognizant.Jose.ShoppingWebsite;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class itemSearch {
	WebDriver driver;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/jmmore/Desktop/chromedriver");
		 driver = new ChromeDriver();
		 
		 driver.get("http://automationpractice.com/index.php");
		
		 WebElement textBox = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
			
		 textBox.sendKeys("dress");
		 	try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			textBox.submit();
	
	}
	
	@Test
	public void itemSearch() {
		
		//driver.get("http://automationpractice.com/index.php?controller=search&orderby=position&orderway=desc&search_query=dress&submit_search=");
		
		WebElement dress = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1/span"));
		boolean present;
		try {
			   driver.findElement(By.xpath("//*[@id=\"center_column\"]/p"));
			    present = true;
			} 
		catch (NoSuchElementException e) {
			   present = false;
			}
		boolean dressExists = dress.getText().contains("DRESS");
		boolean success = present | dressExists;
		
		
		assertEquals("Dress not found",true,success);
		
	}
	
	
	@After
	public void teardown() {
		try {
			Thread.sleep(3000); //otherwise thread doeesnt sleep even if window appears to be closed.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}

}
