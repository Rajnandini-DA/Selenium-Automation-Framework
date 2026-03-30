package com.comcast.crm.Assignment;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcost.crm.generic.fileutility.ExcelUtilityforDWS;

public class FlipkartExecution {

	@Test
	public void FlipkartIphone() throws IOException {
		
		FileUtilityFlipkart ff = new FileUtilityFlipkart();
		ExcelUtilityforDWS eutil = new ExcelUtilityforDWS();
		String URL = ff.getDataFromPropertyFile("url");
		String BROWSER = ff.getDataFromPropertyFile("browser");
		
			
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		
		driver.findElement(By.name("q")).sendKeys();
		
		
		
	}
	
	
	
}
