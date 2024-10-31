package Pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	WebDriver driver;
	
	By logo = By.xpath("//*[@id='lithium-root']/span/header/div/nav/div[1]/a/picture[2]/img");
		
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void titleverify()
	{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        wait.until(ExpectedConditions.titleIs("Tripadvisor: Over a billion reviews & contributions for Hotels, Attractions, Restaurants, and more"));
			String acttitle = driver.getTitle();
		    String exptitle = "Tripadvisor: Over a billion reviews & contributions for Hotels, Attractions, Restaurants, and more";
		    Assert.assertEquals(acttitle,exptitle,"Title does not match"); 
		}
	
	
	public void logo()
	 {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    WebElement logoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(logo));
		    Assert.assertTrue(logoElement.isDisplayed(), "Logo is not displayed");
		    System.out.println("LOGO IS DISPLAYED");
		}

	}
	

   

