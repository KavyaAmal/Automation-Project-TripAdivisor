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
			 String password = Excelutils.getCellValue(xl, sheet, i, 1);
			 
			 loginobj.Login(emailid,password);
			 loginobj.Loginclick();
		 }
}
}
