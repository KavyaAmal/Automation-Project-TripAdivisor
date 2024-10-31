package Pagepkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	
	By signinicon = By.id("lithium-root/span/header/div/nav/div[3]/a");
	By continuewithemail = By.id("ssoButtons/button");
	By Emailid = By.id("regSignIn.email");
	By Password = By.id("regSignIn.password");
	By signinbutton = By.id("regSignIn/div[4]/button[1]");
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void Login(String emailid, String password)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(signinicon).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(continuewithemail)).click();
		driver.findElement(Emailid).sendKeys(emailid);
		driver.findElement(Password).sendKeys(password);
		driver.findElement(signinbutton).click();
	}

	public void Loginclick()
	{
		driver.findElement(signinbutton).click();
	}
	}

