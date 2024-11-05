package Pagepkg;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegPage {

    WebDriver driver;

    By signinicon = By.xpath("//*[contains(text(),'Sign in')]");
    By continuewithemail = By.xpath("//span[contains(text(),'Continue with email')]");
    By join = By.xpath("//span[contains(text(),'Join')]");
    By firstname = By.id("regSignUp.firstName");
    By lastname = By.id("regSignUp.lastname");
    By emailid = By.id("regSignUp.email");
    By password = By.id("regSignUp.password");
    By joinbutton = By.id("regSignUp.submit");
    By iframeLocator = By.id("google_ads_top_frame"); 
    
    public RegPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void TripAdvisorRegpage() 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try 
        {     
            wait.until(ExpectedConditions.elementToBeClickable(signinicon)).click();
         
           try 
           {
                WebElement iframeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));
                driver.switchTo().frame(iframeElement);
                System.out.println("Switched to iframe.");
            }
           catch (Exception e) 
           {
                System.out.println("Iframe not found or not needed.");
            }

            wait.until(ExpectedConditions.elementToBeClickable(continuewithemail)).click();
            wait.until(ExpectedConditions.elementToBeClickable(join)).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(firstname)).sendKeys("Kavya");
            wait.until(ExpectedConditions.visibilityOfElementLocated(lastname)).sendKeys("Mejo");
            wait.until(ExpectedConditions.visibilityOfElementLocated(emailid)).sendKeys("Kavyamejo2000@gmail.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(password)).sendKeys("Kavyamejo#09");
            wait.until(ExpectedConditions.elementToBeClickable(joinbutton)).click();


        } catch (Exception e) {
            System.out.println("Error during registration: " + e.getMessage());
        }
    }
}
