package Pagepkg;

import java.net.HttpURLConnection;
import java.net.URI;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinksPage {
	WebDriver driver;
	
	public LinksPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void linkvalidation()
	{
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No.of Links="+links.size());
		for(WebElement li:links)
		{
			String linktext = li.getText();
			String linkhref = li.getAttribute("href");
			System.out.println("Text of link="+linktext+"url of Links="+linkhref);
		
			if (linkhref != null && !linkhref.isEmpty()) {
		try
		{
			URI obj = new URI(linkhref);
			HttpURLConnection c = (HttpURLConnection)obj.toURL().openConnection();
			if(c.getResponseCode()==200)
			{
				System.out.println("link is valid");
			}
			else if(c.getResponseCode()==404)
			{
				System.out.println("link is broken");
			}
		}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			}else 
			 {
	                System.out.println("Link is invalid (href is null or empty)");
	            }
	
			}
	}
}

		
		

