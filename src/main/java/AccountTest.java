import org.openqa.selenium.By;
//import necessary Selenium WebDriver classes
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class AccountTest {
	  //declare Selenium WebDriver
	  private WebDriver webDriver;		
	  

	  @Test
	  public void checkLogin() {
		  //Load website as a new page
		  webDriver.navigate().to("http://localhost:8080/Moview-0.0.1-SNAPSHOT/Signin.jsp");
		  
		  //Assert the title to check that we are indeed in the correct website
		  Assert.assertEquals(webDriver.getTitle(), "Sign In");
		  
		  System.out.println("title: "+webDriver.getTitle());
		  
		  webDriver.findElement(By.className("username")).sendKeys("Ryhano");
		  webDriver.findElement(By.className("password")).sendKeys("ryhan321");
		  
		  //Retrieve link using it's class name and click on it
		  webDriver.findElement(By.className("logInBtn")).click();
		  
		  //Assert the new title to check that the title contain Home and the button had successfully bring us to the new page
		  Assert.assertTrue(webDriver.getTitle().contains("Home"));
		  System.out.println("new title: "+webDriver.getTitle());
	  }
	  @Test
	  public void checkRegister() {
		//Load website as a new page
		  webDriver.navigate().to("http://localhost:8080/Moview-0.0.1-SNAPSHOT/Register.jsp");
		  
		  //Assert the title to check that we are indeed in the correct website
		  Assert.assertEquals(webDriver.getTitle(), "Sign up");
		  
		  webDriver.findElement(By.name("username")).sendKeys("Test");
		  webDriver.findElement(By.name("password")).sendKeys("Test");
		  webDriver.findElement(By.name("email")).sendKeys("Testing@gmail.com");
		  webDriver.findElement(By.name("contact")).sendKeys("12345678");
		  webDriver.findElement(By.name("address")).sendKeys("Test address");
		  webDriver.findElement(By.className("registerBtn")).click();
		  
	  }
	  
	  
	  
	  @BeforeTest
	  public void beforeTest() {
		  //Setting system properties of ChromeDriver
		  //to amend directory path base on your local file path
		  String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";

		  System.setProperty("webdriver.chrome.driver", chromeDriverDir);

		  //initialize FirefoxDriver at the start of test
		  webDriver = new ChromeDriver();  
	  }

	  @AfterTest
	  public void afterTest() {
		  //Quit the ChromeDriver and close all associated window at the end of test
		  webDriver.quit();			
	  }

	}

	    

