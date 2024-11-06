package Testpage;

import org.testng.annotations.Test;
import Basepkg.BaseClass;
import Pagepkg.LoginPage;
import Utils.Excelutils;

public class LoginTest extends BaseClass {

	@Test
	public void logintest()
	{
	LoginPage loginobj = new LoginPage(driver);
	
		 String xl = "C:\\Users\\kvjos\\OneDrive\\Desktop\\Software Testing\\logindata.xls";
		 String sheet = "sheet1";
		 int rowcount= Excelutils.getRowCount(xl, sheet);
		 System.out.println(rowcount);
		 
		 for(int i=1;i<=rowcount;i++)
		 {
			 String emailid = Excelutils.getCellValue(xl, sheet, i, 0);
			 System.out.println("EmailId="+emailid);
			 String password = Excelutils.getCellValue(xl, sheet, i, 1);
			 System.out.println("Password="+password);
			 
			 loginobj.Login();
			 loginobj.setvalues(emailid, password);
			 loginobj.Loginclick();
			 
			 String expectedurl = "https://www.tripadvisor.in/";
			 String actualurl = driver.getCurrentUrl();
			 if(actualurl.equals(expectedurl))
			 {
				 System.out.println("Login Successful");
			 }
			 else
			 {
				 System.out.println("Login Unsuccessful");
			 }
		 }
}
}
