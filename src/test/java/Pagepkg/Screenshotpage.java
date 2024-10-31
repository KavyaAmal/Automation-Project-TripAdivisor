package Pagepkg;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class Screenshotpage {

	WebDriver driver;
	
	By icon = By.xpath("//*[@id=\"lithium-root\"]/main/div[2]/h1/div");
	

	public void Screenshot(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//ss of webpage
	public void screenshotpage() throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./Screenshot/screenshotofpage.png"));  
	}
	
	
	//ss of an element in page
	public void screenshotelement() throws IOException 
	{
		WebElement element = driver.findElement(icon);
		File src = element.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./Screenshot/screenshotofelement.png"));  
	}
}
