package Pagepkg;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	
	    WebDriver driver;
	 
	    By searchbar = By.xpath("//input[@placeholder='Places to go, things to do, hotels...']");
	    By clubmahindra = By.xpath("//*[contains(text(),'Club Mahindra Munnar')]");
	    By checkavailability = By.xpath("//*[contains(text(),'Check availability')]");
        By december = By.xpath("/html/body/div[3]/div[2]/div/div[2]/div/div[2]/div/div/div[1]/div/div[2]/div[2]/h2");
		By checkin = By.xpath("//div[text()='Check In']");
		
		public SearchPage(WebDriver driver)
		{
			this.driver=driver;
		}
		
		public void search() {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    try {
		        wait.until(ExpectedConditions.visibilityOfElementLocated(searchbar)).sendKeys("Club Mahindra Munnar");
		        Actions actions = new Actions(driver);
		        actions.sendKeys(Keys.ENTER).perform(); 
		      
		        wait.until(ExpectedConditions.visibilityOfElementLocated(clubmahindra)).click();
		    } 
		    catch (Exception e) 
		    {
		        System.out.println("Error during search: " + e.getMessage());
		    }
		    
		    // Wait for the new tab to open and switch to it
		    wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // Wait until two tabs are open
	       
		    String currentTab = driver.getWindowHandle(); // Get current tab handle
		    Set<String> newTabs = driver.getWindowHandles();
	        for (String newTab : newTabs )
	        {
	            if (!currentTab.equals(newTab)) 
	            {
	                driver.switchTo().window(newTab); // Switch to the new tab
	                break;
	            }
	        }
		}

		public void datepicker() 
		{
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    try 
		    {
		        wait.until(ExpectedConditions.elementToBeClickable(checkavailability)).click();
		        wait.until(ExpectedConditions.elementToBeClickable(checkin)).click();
		        datepicker("December 2024", "11");
		    } 
		    catch (Exception e) 
		    {
		        System.out.println("Error during datepicker: " + e.getMessage());
		    }
		}
		public void datepicker(String expmonth, String expdate) {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    boolean monthSelected = false;

		    while (!monthSelected) {
		        try {
		            WebElement monthDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(december));
		            String month = monthDetails.getText();
		            if (expmonth.equals(month)) 
		            {
		                System.out.println("Selected month: " + month);
		                monthSelected = true;
		            } else 
		            {
		                driver.findElement(By.xpath("//button[contains(@aria-label, 'Next month')]")).click();
		            }
		        } 
		        catch (Exception e) 
		        {
		            System.out.println("Error while selecting month: " + e.getMessage());
		            break; 
		        }
		    }

		    
		    List<WebElement> dateDetails = driver.findElements(By.xpath("//*[contains(@class, 'VVyhTp f j c z _S V wSSLS VNPcF gIglQ')]"));
		    for (WebElement date : dateDetails)
		    {
		        String d = date.getText();
		        if (expdate.equals(d)) 
		        {
		            date.click(); 
		            break;
		        }
		    }
			
		}
}

