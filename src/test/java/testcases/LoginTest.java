package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	LoginPage lp;
	DashboardPage dp;
	WebDriver dr;
  @Test(priority=0,description="Login Test", enabled=true)
  public void loginSuccessfull_001() throws IOException 
  {
	  lp.loginToApp(TestBase.prop.getProperty("Username"), TestBase.prop.getProperty("Password"));
	  boolean b=dp.isWelcomeMsgDisplayed();
	  TestUtility.embedScreenCapture();
	  Assert.assertTrue(b);
	  dp.logout();
	  Assert.assertTrue(lp.checkLoginButton());
	  TestUtility.embedScreenCapture();
  }
  
  @Test(priority=1,description="Login Test unsuccessful", enabled=true)
  public void loginUnsuccessful_002() throws IOException
  {
	  lp.loginToApp(TestBase.prop.getProperty("Username"), "Random");
	  boolean b=dp.isWelcomeMsgDisplayed();
	  TestUtility.embedScreenCapture();
	  Assert.assertFalse(b);
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  dr=TestBase.getInstance();
	  lp = new LoginPage(dr);
	  dp = new DashboardPage(dr);
  }

  @AfterMethod
  public void afterMethod() throws IOException {
	  dr.quit();
  }

}
