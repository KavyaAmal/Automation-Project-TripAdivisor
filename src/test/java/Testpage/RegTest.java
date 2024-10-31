package Testpage;

import org.testng.annotations.Test;
import Basepkg.BaseClass;
import Pagepkg.RegPage;

public class RegTest extends BaseClass {
	
	@Test 
	public void Registration()
	{
		RegPage Regobj = new RegPage(driver);
		Regobj.TripAdvisorRegpage();
	}
}
