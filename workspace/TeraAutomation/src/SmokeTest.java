
	import java.util.concurrent.TimeUnit;
	import org.junit.After;
	import org.junit.Before;
	import org.junit.Ignore;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;

	public class SmokeTest {

	    // Create WebDriver instance
	    WebDriver driver;

	    @Before
	    public void setUp() throws Exception {
	        // Initialize the WebDriver instance using FirefoxDriver and launch the web browser
	        driver = new FirefoxDriver();
	        // Open the application - "https://login.yahoo.com/"
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	        driver.get("http://dev-vpc-967400985.us-east-1.elb.amazonaws.com/");
	        String i = driver.getCurrentUrl();
	        System.out.println(i);
	        // Maximize the current window
	        
	    }
	    @Test
	    public void TestValidLogin() throws Exception {
	        // Verify the page title to check if the correct page is launched
	        String pageTitle = driver.getTitle();
	        System.out.println("Your page title Is : "+pageTitle);
	        System.out.println("Launched the correct webpage");
	        
	        // Enter an invalid username and password
//	        WebElement TB_Username = driver.findElement(By.xpath(".//*[@id='md-input-0-input']"));
	        System.out.println("-------------Strting script ---------------");
	        
	        WebElement TB_Username = driver.findElement(By.xpath(".//input[@name='username']"));
	        TB_Username.sendKeys("admin");
	        
	        WebElement TB_Password = driver.findElement(By.xpath(".//input[@name='password']"));        
	        TB_Password.sendKeys("admin");
	        
	        // Click on login button
	        WebElement BTN_Login = driver.findElement(By.xpath("//span[text()='Sign In']"));        
	        BTN_Login.click();
	        // Wait for authentication process
	        Thread.sleep(3000);
	    }	  
	          
	    @After
	    public void tearDown() {
	        // Quit the launched web browser
	      driver.quit();
	    }
	}



