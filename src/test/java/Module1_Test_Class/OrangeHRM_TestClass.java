package Module1_Test_Class;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library_Files.OrangeHRM_BaseClass;
import Library_Files.OrangeHRM_UtilityClass;
import Module1.OrangeHRM_DashBoard;
import Module1.OrangeHRM_Login;


public class OrangeHRM_TestClass extends OrangeHRM_BaseClass{
	OrangeHRM_Login login;
	OrangeHRM_DashBoard Dashboard;
	String TestCaseID;
	@BeforeClass
	public void Open_Browser() throws InterruptedException
	{
		Initilize_Browser();
	//create object of pom1
	login = new OrangeHRM_Login(driver);
	//create object of pom2
	Dashboard = new OrangeHRM_DashBoard(driver);
	}
	
	@BeforeMethod
	public void LoginToApp() throws InterruptedException {
		Thread.sleep(2000);
		login.EnterUsername();
		Thread.sleep(2000);
		login.EnterPassword();
		Thread.sleep(2000);
		login.ClickLoginButton();
		
	}
	@Test(priority = 1) 
	public void VerifyUserNameofDashboard	() throws EncryptedDocumentException, IOException
	{
		
		TestCaseID="TC001";
		String Actualresult = Dashboard.gettextofUsername();
		String Expectedresult = OrangeHRM_UtilityClass.getdatafromExcelSheet(0, 0);
		
		Assert.assertEquals(Actualresult, Expectedresult);
	}
	@Test(priority = 2) 
	public void VerifyTitle() throws EncryptedDocumentException, IOException {
		TestCaseID="TC002";
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = OrangeHRM_UtilityClass.getdatafromExcelSheet(1, 0);
		Assert.fail();
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	@AfterMethod
	public void LogoutOutfromApp(ITestResult Result) throws InterruptedException, IOException
	{
		if (Result.getStatus()== ITestResult.FAILURE)
		{
			OrangeHRM_UtilityClass.CaptureScreenshot(driver, TestCaseID);
		}
		Thread.sleep(2000);
		Dashboard.ClickUsername();
		Thread.sleep(2000);
		Dashboard.ClickLogout();
	}
	@AfterClass
	public void CloseBrowser() {
		driver.close();
	}
	}

