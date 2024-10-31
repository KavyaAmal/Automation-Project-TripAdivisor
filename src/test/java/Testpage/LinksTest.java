package Testpage;

import org.testng.annotations.Test;
import Basepkg.BaseClass;
import Pagepkg.LinksPage;

public class LinksTest extends BaseClass {

@Test
	
	public void links()
	{
		LinksPage linkobj = new LinksPage(driver);
		linkobj.linkvalidation();
		}
	}
	

