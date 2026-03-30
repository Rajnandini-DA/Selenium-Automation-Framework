package com.comcast.crm.Testng;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcost.crm.generic.fileutility.ExcelUtility;

public class GetProductInfowithExcel {

	@Test(dataProvider = "getData")
	public void getProductInfo(String brandName, String productName) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");

		// Search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName, Keys.ENTER);

		// Capture productr info

		String x = "//span[text()='" + productName
				+ "']/../../../../div[3]/div[1]/div/div[1]/div[1]/div/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		driver.quit();
	}

	@DataProvider

	public Object[][] getData() throws IOException {
		ExcelUtility eutil = new ExcelUtility();
		int rowcount = eutil.getRowCount("products");

		Object[][] objArr = new Object[rowcount][2];

		for (int i = 0; i < rowcount; i++) {
			objArr[i][0] = eutil.getDatafromExcelFile("products", i + 1, 0);
			objArr[i][1] = eutil.getDatafromExcelFile("products", i + 1, 1);

		}

		return objArr;

	}

	
	
}
