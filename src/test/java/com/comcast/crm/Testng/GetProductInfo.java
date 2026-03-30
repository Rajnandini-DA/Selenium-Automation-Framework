package com.comcast.crm.Testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetProductInfo {

	@Test(dataProvider = "getData")
	public void getProductInfo(String brandName, String productName) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");

		// Search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);

		// Capture productr info

		String x = "//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] objArr = new Object[3][2];
		objArr[0][0] = "iphone";
		objArr[0][1] = "Apple iPhone 15 (128 GB) - Blue";
		//objArr[0][2] = 1234567890l;

		objArr[1][0] = "iphone";
		objArr[1][1] = "Apple iPhone 15 (128 GB) - Blue";
		//objArr[1][2] = 2136547890l;

		objArr[2][0] = "iphone";
		objArr[2][1] = "Apple iPhone 15 (128 GB) - Pink";
		//objArr[2][2] = 9876543210l;

		return objArr;

	}

}
