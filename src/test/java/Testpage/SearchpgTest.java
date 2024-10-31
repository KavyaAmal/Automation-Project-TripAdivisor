package Testpage;

import org.testng.annotations.Test;
import Basepkg.BaseClass;
import Pagepkg.SearchPage;

public class SearchpgTest extends BaseClass {

	@Test
	public void datepicker()
	{
		SearchPage searchobj = new SearchPage(driver);
		searchobj.search();
		searchobj.datepicker();
		
	}
	
}
