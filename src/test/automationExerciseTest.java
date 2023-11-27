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

import java.util.concurrent.TimeUnit;

class automationExerciseTest {
	
	private WebDriver driver;
	private String url = "https://bearstore-testsite.smartbear.com/";
	
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
	}

	@AfterEach
	void tearDown() throws Exception {
		//close the browser
//		driver.close();
	}

	@Test
	void gotoProductsPageTest() {
	   
	}

}
