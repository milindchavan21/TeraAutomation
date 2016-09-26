package TeraDataAutomation.TeraDataAutomation;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Hello world!
 *
 */
public class AppTest {
	public static WebDriver driver;
	
	@Before
	public void setUp(){
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://dev-vpc-967400985.us-east-1.elb.amazonaws.com/");
		
	}
	
	@Test
	public void loginPage() {
		WebElement TB_Username = driver.findElement(By
				.xpath(".//input[@name='username']"));
		TB_Username.sendKeys("admin");

		WebElement TB_Password = driver.findElement(By
			.xpath(".//input[@name='password']"));
		TB_Password.sendKeys("adm");

		// Click on login button

		WebElement BTN_Login = driver.findElement(By
				.xpath("//span[text()='Sign In']"));
		BTN_Login.click();
	}
	
	@After
	public void tearDown(){
		driver.quit();
	}

}
