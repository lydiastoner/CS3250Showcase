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

class bearstoreTest {
	
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
		driver.close();
	}
	
////// HEADER TESTS //////
	
	@ Test
	void smartbearHeaderTest() {
		driver.findElement(By.xpath("//img[@title='SmartStore']")).click();
		assertEquals("Shop", driver.getTitle());
	}
	
	@Test
	void basketHeaderTest() {
		driver.findElement(By.xpath("(//strong[text()='Basket'])")).click();
		assertEquals("Shop", driver.getTitle());
	}
	
	@Test
	void compareHeaderTest() {
		driver.findElement(By.xpath("(//strong[text()='Products'])")).click();
		assertEquals("Shop", driver.getTitle());
	}
	
	@Test
	void wishListHeaderTest() {
		driver.findElement(By.xpath("(//strong[text()='List'])")).click();
		assertEquals("Shop", driver.getTitle());
	}
	
	@Test
	void usDollarHeaderTest() {
		driver.findElement(By.xpath("(//i[@class='fa fa-angle-down'])")).click();
		driver.findElement(By.xpath("//span[text()='US Dollar']")).click();
		assertEquals("Shop", driver.getTitle());
	}
	
	@Test
	void poundHeaderTest() {
		driver.findElement(By.xpath("(//i[@class='fa fa-angle-down'])")).click();
		driver.findElement(By.xpath("//span[text()='Pound Sterling']")).click();
		assertEquals("Shop", driver.getTitle());	
	}
	
	@Test
	void australianHeaderTest() {
		driver.findElement(By.xpath("(//i[@class='fa fa-angle-down'])")).click();
		driver.findElement(By.xpath("//span[text()='Australian Dollar']")).click();
		assertEquals("Shop", driver.getTitle());
	}
	
	@Test
	void canadianHeaderTest() {
		driver.findElement(By.xpath("(//i[@class='fa fa-angle-down'])")).click();
		driver.findElement(By.xpath("//span[text()='Canadian Dollar']")).click();
		assertEquals("Shop", driver.getTitle());
	}
	
	@Test
	void searchValidHeaderTest() {
		driver.findElement(By.name("q")).sendKeys("street football");
		driver.findElement(By.xpath("(//i[@class='icm icm-magnifier instasearch-icon'])")).click();
		assertEquals("Shop. Search result for \"street football\"", driver.getTitle());
	}
	
	@Test
	void searchInvalidHeaderTest() {
		driver.findElement(By.name("q")).sendKeys("abc");
		driver.findElement(By.xpath("(//i[@class='icm icm-magnifier instasearch-icon'])")).click();
		assertTrue(driver.getPageSource().contains("Your search did not match any products"));
	}
	
	@Test
	void contactUsHeaderTest() {
		driver.findElement(By.xpath("(//a[text()='Contact us'])")).click();
		assertEquals("Shop. Contact Us", driver.getTitle());
	}
	
	@Test
	void newsHeaderTest() {
		driver.findElement(By.xpath("(//a[@href='/news'])")).click();
		assertEquals("Shop. News Archive", driver.getTitle());
	}
	
	@Test
	void blogHeaderTest() {
		driver.findElement(By.xpath("(//a[@href='/blog'])")).click();
		assertEquals("Shop", driver.getTitle());
	}
	
	// SERVICE DROPDOWN
	
		@Test
		void whatsNewServiceDropdownPageTest() {
			driver.findElement(By.xpath("//span[text()='Service']")).click();
			driver.findElement(By.xpath("//span[text()=\"What's New\"]")).click();
			assertEquals("Shop. Recently Added Products", driver.getTitle());
		}
	
		@Test
		void recentlyViewedServiceDropdownTest() {
			driver.findElement(By.xpath("//span[text()='Service']")).click();
			driver.findElement(By.xpath("(//span[text()='Recently viewed products'])")).click();
			assertEquals("Shop. Recently Viewed Products", driver.getTitle());	
		}
		
		@Test
		void compareProductsServiceDropdownTest() {
			driver.findElement(By.xpath("//span[text()='Service']")).click();
			driver.findElement(By.xpath("(//span[text()='Compare products list'])")).click();
			assertEquals("Shop. Compare Products", driver.getTitle());
		}
		
		@Test
		void aboutServiceDropdownTest() {
			driver.findElement(By.xpath("//span[text()='Service']")).click();
			driver.findElement(By.xpath("(//span[text()='About Us'])")).click();
			assertEquals("Shop. About Us", driver.getTitle());
		}
		
		@Test
		void disclaimerServiceDropdownTest() {
			driver.findElement(By.xpath("//span[text()='Service']")).click();
			driver.findElement(By.xpath("(//span[text()='Disclaimer'])")).click();
			assertEquals("Shop. Disclaimer", driver.getTitle());
		}
		
		@Test
		void shippingServiceDropdownTest() {
			driver.findElement(By.xpath("//span[text()='Service']")).click();
			driver.findElement(By.xpath("(//span[text()='Shipping & Returns'])")).click();
			assertEquals("Shop. Shipping & Returns", driver.getTitle());
		}
		
		@Test
		void conditionsServiceDropdownTest() {
			driver.findElement(By.xpath("//span[text()='Service']")).click();
			driver.findElement(By.xpath("(//span[text()='Conditions of use'])")).click();
			assertEquals("Shop. Conditions of use", driver.getTitle());
		}
	
	// Login //
	
	@Test
	void registerNewAccount () {
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		driver.findElement(By.xpath("//a[@href='/register?returnUrl=%2f']")).click();

		driver.findElement(By.name("FirstName")).sendKeys("lydia");
		driver.findElement(By.name("LastName")).sendKeys("stoner");
		driver.findElement(By.xpath("//option[text()='Day']")).click();
		driver.findElement(By.xpath("//option[text()='10']")).click();
		driver.findElement(By.xpath("//option[text()='Month']")).click();
		driver.findElement(By.xpath("//option[text()='June']")).click();
		driver.findElement(By.xpath("//option[text()='Year']")).click();
		driver.findElement(By.xpath("//option[text()='2002']")).click();
		driver.findElement(By.name("Email")).sendKeys("lcs6bak@virginia.edu");
		driver.findElement(By.name("Username")).sendKeys("lydiastoner");
		driver.findElement(By.name("Password")).sendKeys("password");
		driver.findElement(By.name("ConfirmPassword")).sendKeys("password");
		driver.findElement(By.name("register-button")).click();
	
	}
	
	// USER DROPDOWN //
	
	@Test
	void myAccountHeaderTest() {
		driver.findElement(By.xpath("/html/body/div/div[2]/header/div[1]/div/nav/nav[4]/div/a/span")).click();
		driver.findElement(By.xpath("//*[@id='UsernameOrEmail']")).sendKeys("lydiastoner");
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("password");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/section/div/div/div/div[2]/div[1]/div/form/div[4]/button")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/header/div[1]/div/nav/nav[4]/div/a/span")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/header/div[1]/div/nav/nav[4]/div/div/a[1]/span")).click();
		assertEquals("Shop. Account", driver.getTitle());
	}
	
	@Test
	void wishlistHeaderTest() {
		driver.findElement(By.xpath("/html/body/div/div[2]/header/div[1]/div/nav/nav[4]/div/a/span")).click();
		driver.findElement(By.xpath("//*[@id='UsernameOrEmail']")).sendKeys("lydiastoner");
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("password");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/section/div/div/div/div[2]/div[1]/div/form/div[4]/button")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/header/div[1]/div/nav/nav[4]/div/a/span")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/header/div[1]/div/nav/nav[4]/div/div/a[2]/span[1]")).click();
		assertEquals("Shop. Wishlist", driver.getTitle());
	}
	
	@Test
	void shoppingCartHeaderTest() {
		driver.findElement(By.xpath("/html/body/div/div[2]/header/div[1]/div/nav/nav[4]/div/a/span")).click();
		driver.findElement(By.xpath("//*[@id='UsernameOrEmail']")).sendKeys("lydiastoner");
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("password");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/section/div/div/div/div[2]/div[1]/div/form/div[4]/button")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/header/div[1]/div/nav/nav[4]/div/a/span")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/header/div[1]/div/nav/nav[4]/div/div/a[3]/span[1]")).click();
		assertEquals("Shop. Shopping Cart", driver.getTitle());
	}
	
	@Test
	void logoutHeaderTest() {
		driver.findElement(By.xpath("/html/body/div/div[2]/header/div[1]/div/nav/nav[4]/div/a/span")).click();
		driver.findElement(By.xpath("//*[@id='UsernameOrEmail']")).sendKeys("lydiastoner");
		driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("password");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/section/div/div/div/div[2]/div[1]/div/form/div[4]/button")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/header/div[1]/div/nav/nav[4]/div/a/span")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/header/div[1]/div/nav/nav[4]/div/div/a[4]/span")).click();
		assertTrue(driver.getPageSource().contains("Log in"));
	}
	
		
	// BOOKS DROPDOWN
	
		@Test
		void spigelBooksDropdownPageTest() {
			driver.findElement(By.xpath("//span[text()='Books']")).click();
			driver.findElement(By.xpath("//span[text()='SPIEGEL-Bestseller']")).click();
			assertEquals("Shop. SPIEGEL-Bestseller", driver.getTitle());
		}
		
		@Test
		void cookBooksDropdownPageTest() {
			driver.findElement(By.xpath("//span[text()='Books']")).click();
			driver.findElement(By.xpath("//span[text()='Cook and enjoy']")).click();
			assertEquals("Shop. Cook and enjoy", driver.getTitle());
		}

	// FURNITURE DROPDOWN
		
		@Test
		void chairsFurnitureDropdownPageTest() {
			driver.findElement(By.xpath("//span[text()='Furniture']")).click();
			driver.findElement(By.xpath("//span[text()='Chairs']")).click();
			assertEquals("Shop. Chairs", driver.getTitle());
		}
		
		@Test
		void sofasFurnitureDropdownPageTest() {
			driver.findElement(By.xpath("//span[text()='Furniture']")).click();
			driver.findElement(By.xpath("//span[text()='Sofas']")).click();
			assertEquals("Shop. Sofas", driver.getTitle());
		}

		@Test
		void tablesFurnitureDropdownPageTest() {
			driver.findElement(By.xpath("//span[text()='Furniture']")).click();
			driver.findElement(By.xpath("//span[text()='Tables']")).click();
			assertEquals("Shop. Tables", driver.getTitle());
		}
	
	// SPORTS DROPDOWN
	
	@Test
	void basketballSportsDropdownPageTest() {
		driver.findElement(By.xpath("//span[text()='Sports']")).click();
		driver.findElement(By.xpath("//span[text()='Basketball']")).click();
		assertEquals("Shop. Basketball", driver.getTitle());
	}
	
	@Test
	void golfSportsDropdownPageTest() {
		driver.findElement(By.xpath("//span[text()='Sports']")).click();
		driver.findElement(By.xpath("//span[text()='Golf']")).click();
		assertEquals("Shop. Golf", driver.getTitle());
	}

	@Test
	void soccerSportsDropdownPageTest() {
		driver.findElement(By.xpath("//span[text()='Sports']")).click();
		driver.findElement(By.xpath("//span[text()='Soccer']")).click();
		assertEquals("Shop. Soccer", driver.getTitle());
	}
	
	
	// GAMING DROPDOWN
	
		@Test
		void accessoriesGamingDropdownPageTest() {
			driver.findElement(By.xpath("//span[text()='Gaming']")).click();
			driver.findElement(By.xpath("//span[text()='Gaming Accessories']")).click();
			assertEquals("Shop. Gaming Accessories", driver.getTitle());
		}
		
	// WATCHES
		@Test
		void watchesHeaderPageTest() {
			driver.findElement(By.xpath("//span[text()='Watches']")).click();
			assertEquals("Shop. Watches", driver.getTitle());
		}
		
	// GIFT CARDS
		@Test
		void giftcardsHeaderPageTest() {
			driver.findElement(By.xpath("//span[text()='Gift Cards']")).click();
			assertEquals("Shop. Gift cards", driver.getTitle());
		}
		
///// HOME PAGE /////
		
	//Sports
		@Test
		void sportsHomePageTest() {
			driver.findElement(By.xpath("(//span[text()='Sports'])[2]")).click();
			assertEquals("Shop. Sports", driver.getTitle());
		}
		
	//Furniture
		@Test
		void FurnitureHomePageTest() {
			driver.findElement(By.xpath("(//span[text()='Furniture'])[2]")).click();
			assertEquals("Shop. Furniture", driver.getTitle());
		}
	
	//Soccer
		@Test
		void soccerHomePageTest() {
			driver.findElement(By.xpath("(//span[text()='Soccer'])[2]")).click();
			assertEquals("Shop. Soccer", driver.getTitle());
		}
		
	//Basketball
		@Test
		void basketballHomePageTest() {
			driver.findElement(By.xpath("(//span[text()='Basketball'])[2]")).click();
			assertEquals("Shop. Basketball", driver.getTitle());
		}

	//Golf
		@Test
		void golfHomePageTest() {
			driver.findElement(By.xpath("(//span[text()='Golf'])[2]")).click();
			assertEquals("Shop. Golf", driver.getTitle());
		}
	
	//Jackets
	@Test
	void jacketsHomePageTest() {
		driver.findElement(By.xpath("(//span[text()='Jackets'])")).click();
		assertEquals("Shop. Jackets", driver.getTitle());

	}
	
	//Shoes
	@Test
	void shoesHomePageTest() {
		driver.findElement(By.xpath("(//span[text()='Shoes'])")).click();
		assertEquals("Shop. Shoes", driver.getTitle());

	}
	//Pants
		@Test
		void pantsHomePageTest() {
			driver.findElement(By.xpath("(//span[text()='Pants'])")).click();
			assertEquals("Shop. Trousers", driver.getTitle());

		}

	//Sunglasses
	@Test
	void sunglassesHomePageTest() {
		driver.findElement(By.xpath("(//span[text()='Sunglasses'])")).click();
		assertEquals("Shop. Sunglasses", driver.getTitle());
	}
	
	//Gaming
	@Test
	void gamingHomePageTest() {
		driver.findElement(By.xpath("(//span[text()='Gaming'])[2]")).click();
		assertEquals("Shop. Gaming", driver.getTitle());
	}
		
	//Watches
	@Test
	void watchesHomePageTest() {
		driver.findElement(By.xpath("(//span[text()='Watches'])[2]")).click();
		assertEquals("Shop. Watches", driver.getTitle());
	}
	
	//Gift Cards
	@Test
	void giftcardsHomePageTest() {
		driver.findElement(By.xpath("(//span[text()='Gift Cards'])[2]")).click();
		assertEquals("Shop. Gift cards", driver.getTitle());
	}
	
	@Test
	void cubeChairHomePageTest() {
		driver.findElement(By.xpath("//*[@id=\"artlist-6972552694\"]/article[10]/h3/a/span")).click();
		assertEquals("Shop. Cube Chair", driver.getTitle());
	}

	
	@Test
	void viewNewsHomePageTest() {
		driver.findElement(By.xpath("//*[@id=\"content-center\"]/div/div/div[4]/div[1]/div[2]/a[2]")).click();
		assertEquals("Shop. News Archive", driver.getTitle());
	}
	
	@Test
	void firstModernTextHomePageTest() {
		driver.findElement(By.xpath("//*[@id=\"content-center\"]/div/div/div[4]/div[2]/div/div/article[1]/div[2]/h4/a")).click();
		assertEquals("Shop. The first modern automobile", driver.getTitle());
	}
	
	@Test
	void firstModernPhotoHomePageTest() {
		driver.findElement(By.xpath("//*[@id=\"content-center\"]/div/div/div[4]/div[2]/div/div/article[1]/div[1]/a/img")).click();
		assertEquals("Shop. The first modern automobile", driver.getTitle());
	}
	
	@Test
	void readMoreHomePageTest() {
		driver.findElement(By.xpath("//*[@id=\"content-center\"]/div/div/div[4]/div[2]/div/div/article[1]/div[2]/div[2]/a")).click();
		assertEquals("Shop. The first modern automobile", driver.getTitle());
	}
	
	
	///// FOOTER /////
	
	// Informations //
	@Test
	void whatsNewFooterTest() {
		driver.findElement(By.xpath("(//span[text()=\"What's New\"])[2]")).click();
		assertEquals("Shop. Recently Added Products", driver.getTitle());
	}
	
	@Test
	void recentlyViewedFooterTest() {
		driver.findElement(By.xpath("(//span[text()='Recently viewed products'])[2]")).click();
		assertEquals("Shop. Recently Viewed Products", driver.getTitle());	
	}
	
	@Test
	void compareProductsFooterTest() {
		driver.findElement(By.xpath("(//span[text()='Compare products list'])[2]")).click();
		assertEquals("Shop. Compare Products", driver.getTitle());
	}
	
	// Service //
	@Test
	void contactUsFooterTest() {
		driver.findElement(By.xpath("(//span[text()='Contact us'])")).click();
		assertEquals("Shop. Contact Us", driver.getTitle());
	}
	
	@Test
	void blogFooterTest() {
		driver.findElement(By.xpath("(//span[text()='Blog'])")).click();
		assertEquals("Shop", driver.getTitle());
	}
	
	@Test
	void shippingFooterTest() {
		driver.findElement(By.xpath("(//span[text()='Shipping & Returns'])[2]")).click();
		assertEquals("Shop. Shipping & Returns", driver.getTitle());
	}
	
	@Test
	void paymentFooterTest() {
		driver.findElement(By.xpath("(//span[text()='Payment info'])")).click();
		assertEquals("Shop. Payment info", driver.getTitle());
	}
	
	// Company //
	@Test
	void aboutFooterTest() {
		driver.findElement(By.xpath("(//span[text()='About Us'])[2]")).click();
		assertEquals("Shop. About Us", driver.getTitle());
	}
	
	@Test
	void disclaimerFooterTest() {
		driver.findElement(By.xpath("(//span[text()='Disclaimer'])[2]")).click();
		assertEquals("Shop. Disclaimer", driver.getTitle());
	}
	
	@Test
	void privacyFooterTest() {
		driver.findElement(By.xpath("(//span[text()='Privacy'])")).click();
		assertEquals("Shop. Privacy policy", driver.getTitle());
	}
	
	@Test
	void conditionsFooterTest() {
		driver.findElement(By.xpath("(//span[text()='Conditions of use'])[2]")).click();
		assertEquals("Shop. Conditions of use", driver.getTitle());
	}
	
	@Test
	void facebookFooterTest() {
		driver.findElement(By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div/a[1]/i")).click();
		assertEquals("https://bearstore-testsite.smartbear.com/", driver.getCurrentUrl());
	}
	
	@Test
	void validEmailFooterTest() {
		driver.findElement(By.xpath("//*[@id=\"newsletter-email\"]")).sendKeys("lcs6bak@virginia.edu");
		driver.findElement(By.xpath("//*[@id=\"newsletter-unsubscribe\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"newsletter-subscribe-button\"]/i")).click();
		assertTrue(driver.getPageSource().contains("alert-success"));
	}
	
	@Test
	void invalidEmailFooterTest() {
		driver.findElement(By.xpath("//*[@id=\"newsletter-email\"]")).sendKeys("lcs6bak");
		driver.findElement(By.xpath("//*[@id=\"newsletter-subscribe\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"newsletter-subscribe-button\"]/i")).click();
		assertTrue(driver.getPageSource().contains("danger"));
	}
}
