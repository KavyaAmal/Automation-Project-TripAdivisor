package Pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	
	By signinicon = By.id("lithium-root/span/header/div/nav/div[3]/a");
	By continuewithemail = By.id("ssoButtons/button");
	By Emailid = By.id("regSignIn.email");
	By Password = By.id("regSignIn.password");
	By signinbutton = By.id("regSignIn/div[4]/button[1]");
	By iframeLocator = By.xpath("//iframe[@title='regcontroller']"); 
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void Login()
	{		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(signinicon)).click();
    
        WebElement iframeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));
        driver.switchTo().frame(iframeElement);
        System.out.println("Switched to iframe.");
          
		wait.until(ExpectedConditions.visibilityOfElementLocated(continuewithemail)).click();
	}
	
	public void setvalues(String emailid, String password)
	{
		driver.findElement(Emailid).sendKeys(emailid);
		driver.findElement(Password).sendKeys(password);
	}

	public void Loginclick()
	{
		driver.findElement(signinbutton).click();
	}
	}

