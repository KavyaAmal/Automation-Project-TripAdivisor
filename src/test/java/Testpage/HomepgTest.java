package Testpage;

import org.testng.annotations.Test;
import Basepkg.BaseClass;
import Pagepkg.HomePage;


	public class HomepgTest extends BaseClass {
	
	
	@Test
	public void titleverification()
	{	
        HomePage homeobj = new HomePage(driver);
		homeobj.titleverify();
	}
	
	@Test
	public void logoverification()
	{
		 HomePage homeobj = new HomePage(driver);
			homeobj.logo();
	}
			
}
