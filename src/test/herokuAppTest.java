package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;     // for firefox

class herokuAppTest {

	private WebDriver driver;
	private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		// configure path to the driver
		  System.setProperty("webdriver.gecko.driver", "C:/Users/lydia/Downloads/geckodriver-v0.33.0-win64/geckodriver.exe");
		             
		  // create an instance of the web browser and open it    
		  driver = new FirefoxDriver();  
	      
	      driver.get(url);  
	      Thread.sleep(3000);
//	      driver.findElement(By.name("username")).sendKeys("Admin");
//	      driver.findElement(By.name("password")).sendKeys("admin123");
//	      driver.findElement(By.xpath("//button[text()=' Login ']")).click();
//	      Thread.sleep(2000);
	      
	}

	@AfterEach
	void tearDown() throws Exception {
		//close the browser
//		driver.close();
	}

	@Test
	public void loginInvalidTest() {
		//exe
		driver.findElement(By.name("username")).sendKeys("lydia");
	    driver.findElement(By.name("password")).sendKeys("password");
	    driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	    //verify
	    assertTrue(driver.getPageSource().contains("Invalid credentials"));
		
	}
	
	@Test
	public void loginValidTest() {
		//exe
		driver.findElement(By.name("username")).sendKeys("Admin");
	    driver.findElement(By.name("password")).sendKeys("admin123");
	    driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	    //verify
	    assertTrue(driver.getPageSource().contains("Dashboard"));
		
	}
//	@Test
//	public void adminSearchNoResultsTest() {
//		//setup
//		driver.findElement(By.xpath("//span[text()='Admin']")).click();
//
//		// exe
//		driver.findElement(By.xpath("//div[class()='oxd-select-text-input']")).click();
//		driver.findElement(By.xpath("//div[contains(text(),'ESS')]")).click();
//	    driver.findElement(By.xpath("//button[text()='Search']")).click();
//
//
//		//verify
//		assertTrue(driver.getPageSource().contains("(7) Records Found"));
//		
//	}
	
//	@Test
//	public void myInfoChangeNameTest() {
//		//setup
//		driver.findElement(By.xpath("//span[text()='My Info']")).click();
//		
//		//exe
//	    driver.findElement(By.name("firstName")).clear();
//	    driver.findElement(By.name("firstName")).sendKeys("Lydia");
//	    driver.findElement(By.name("lastName")).clear();
//	    driver.findElement(By.name("lastName")).sendKeys("Stoner");
//	    driver.findElement(By.xpath("//button[text()='Save']")).click();
//		
//		//verify
//		driver.findElement(By.xpath("//span[text()='Dashboard']")).click();
//		assertTrue(driver.getPageSource().contains("Lydia Stoner"));
//
//
//	}
//	
//	@Test
//	public void timeSearchInvalidTest() {
//		//setup
//		driver.findElement(By.xpath("//span[text()='Time']")).click();
//		
//		// exe
//	    driver.findElement(By.xpath("//input[placeholder()='Type for hints...']")).sendKeys("Z");
//	    driver.findElement(By.xpath("//button[text()='View']")).click();
//
//	    //verify
////	    Thread.sleep(1000);
//		assertTrue(driver.getPageSource().contains("Invalid"));
//
//
//				
//	}
//	
//	@Test
//	public void logoutTest() {
//		//exe
//		
//	}
	
}


