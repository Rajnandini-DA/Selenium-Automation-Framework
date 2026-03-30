package practice.pom.repository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPom{
	
	@FindBy(name="user_name")
	WebElement username;
	
	@FindBy(name="user_password")
	WebElement password;
	
	@FindBy(id="submitButton")
	WebElement loginbtn;
	
	@Test
	public void sampleTest() {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		
		SampleTestWithPom s = PageFactory.initElements(driver,SampleTestWithPom.class);
		
		s.username.sendKeys("admin");
		s.password.sendKeys("password");
		s.loginbtn.click();
		
		driver.quit();
		
	}
	
	

}
