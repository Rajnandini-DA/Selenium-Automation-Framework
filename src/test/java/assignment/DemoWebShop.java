package assignment;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcost.crm.generic.fileutility.ExcelUtilityforDWS;
import com.comcost.crm.generic.webdriverutility.Javautility;
import com.comcost.crm.objectrepositoryutility.ChekoutPage;
import com.comcost.crm.objectrepositoryutility.RegisterPage;

public class DemoWebShop {

	@Test
	public void registerpage() throws EncryptedDocumentException, IOException {
		
		Javautility jutil = new Javautility();
		ExcelUtilityforDWS eutil = new ExcelUtilityforDWS();
		
		String computers = eutil.getDataFromExcelFile("DWS",1,0);
		String dekstop = eutil.getDataFromExcelFile("DWS",1,1);
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.linkText("Register")).click();
		
		RegisterPage rp = new RegisterPage(driver);
		rp.toRegister("Raj"+jutil.getRandomNumber(), "prah", jutil.getRandomNumber()+"praharag3@gmail.com");
		
		driver.findElement(By.partialLinkText("Computers")).click();
		driver.findElement(By.partialLinkText("Desktops")).click();
		
		driver.findElement(By.xpath("//img[@alt='Picture of Build your own cheap computer']")).click();
		driver.findElement(By.id("add-to-cart-button-72")).click();
		driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();
	
		driver.findElement(By.id("termsofservice")).click();
		driver.findElement(By.id("checkout")).click();
		
		ChekoutPage ck = new ChekoutPage(driver);
		WebElement city = driver.findElement(By.id("BillingNewAddress_CountryId"));
		city.click();
		Select sel = new Select(city);
		sel.selectByIndex(2);
		ck.Continue("bihar", "abcd", "562120", "9876541230");
		
		String subtotal = driver.findElement(By.xpath("//span[text()=815.00 and @class='product-subtotal']")).getText();
		String Totalorder = driver.findElement(By.xpath("//strong[text()='822.00']")).getText();
		
		
		
		eutil.setDataFromExcelFile("DWS",1,2,subtotal);
		eutil.setDataFromExcelFile("DWS",1,3,Totalorder);
		
		ck.getConfirmbtn().click();
		
		String Orderno = driver.findElement(By.xpath("//li[contains(text(),'Order number:')]")).getText();
		eutil.setDataFromExcelFile("DWS",1,4,Orderno);
		
		driver.quit();
		
		
	}
	
}
