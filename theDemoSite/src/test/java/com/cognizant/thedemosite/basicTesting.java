package com.cognizant.thedemosite;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class basicTesting {
	WebDriver driver;
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/jmmore/Desktop/chromedriver");
		 driver = new ChromeDriver();
		 
//		 driver.get("http://thedemosite.co.uk/addauser.php");
//			
//			WebElement userName = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
//			WebElement password = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
//			WebElement save = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
//			userName.sendKeys("jjjj");
//			password.sendKeys("zzzz");
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			save.click();

			
	}
	
	@Test
	public void userLogin() throws Exception {
		FileInputStream file = null;
		
		file = new FileInputStream("/Users/jmmore/eclipse-workspace/theDemoSite/DemoSiteDDT.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
				
		XSSFSheet sheet = workbook.getSheetAt(0);
		
//		for(int rowNum = 0 ; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) { // for i<num rows
//			for(int colNum=0;colNum < sheet.getRow(rowNum).getPhysicalNumberOfCells(); colNum++) {// for j<num columns
//				XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
//				String userCell = cell.getStringCellValue();
//			}
//		}
		
		
		
		for(int rowNum = 1 ; rowNum < sheet.getPhysicalNumberOfRows(); rowNum++) { // for i<num rows
			driver.get("http://thedemosite.co.uk/addauser.php");
			
			WebElement userName = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
			WebElement password = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
			WebElement save = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input"));
			
				XSSFCell cellUsername = sheet.getRow(rowNum).getCell(0);
				XSSFCell cellPassword = sheet.getRow(rowNum).getCell(1);
					
				System.out.println(cellUsername.getStringCellValue());
					
					userName.sendKeys(cellUsername.getStringCellValue());
					password.sendKeys(cellPassword.getStringCellValue());
					
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					save.click();
					Thread.sleep(500);
					
					driver.get("http://thedemosite.co.uk/login.php");
				
				WebElement userLog = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input"));
				WebElement passLog = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input"));
				WebElement testLogin = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input"));

				
				userLog.sendKeys(cellUsername.getStringCellValue());
				passLog.sendKeys(cellPassword.getStringCellValue());
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				testLogin.click();
				
				WebElement success = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
				
				XSSFRow rowOutput = sheet.getRow(rowNum);
				XSSFCell cellResult = rowOutput.getCell(4);
				XSSFCell cellExpectedValue = rowOutput.getCell(5);
				
				if(cellResult== null) {
					cellResult = rowOutput.createCell(4);
					continue;
				}
				if(cellExpectedValue == null) {
					cellExpectedValue = rowOutput.createCell(5);
					continue;
				}
				if(success.isDisplayed()) {
					cellResult.setCellValue("Test Passed");
					System.out.println(success.getText());
					file.close();
				}
				else {
					cellResult.setCellValue("Test Failed");
					file.close();
				}
				
				FileOutputStream fileOut = new FileOutputStream("/Users/jmmore/eclipse-workspace/theDemoSite/DemoSiteDDT.xlsx");
				workbook.write(fileOut);
				workbook.close();
				fileOut.flush();
				fileOut.close();
				
				//writing:
//				XSSFRow row = sheet.getRow(1);
//				XSSFCell cell = row.getCell(1);
//				
//				if(cell == null) {
//					cell = row.createCell(1);
//				}
//				cell.setCellValue("hello");
//				file.close();
//				
//				
//				
//				FileOutputStream fileOut = new FileOutputStream("/Users/jmmore/eclipse-workspace/theDemoSite/DemoSiteDDT.xlsx");
				
//				workbook.write(fileOut);
//				fileOut.flush();
//				fileOut.close();
				
				
			
		}
		
		
	}
	
	
	@After
	public void teardown() {
		try {
			Thread.sleep(5000); //otherwise thread doeesnt sleep even if window appears to be closed.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}

