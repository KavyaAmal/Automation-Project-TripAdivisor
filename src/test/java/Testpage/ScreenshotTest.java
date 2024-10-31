package Testpage;

import java.io.IOException;

import org.testng.annotations.Test;
import Basepkg.BaseClass;
import Pagepkg.Screenshotpage;

public class ScreenshotTest extends BaseClass {


	@Test 
	public void testScreenshot() throws IOException
	{
		Screenshotpage ssobj = new Screenshotpage();
		ssobj.Screenshot(driver);
		ssobj.screenshotpage();
		ssobj.screenshotelement();
	}
}
