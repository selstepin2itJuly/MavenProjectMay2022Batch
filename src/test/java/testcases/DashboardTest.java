package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class DashboardTest {
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
  @Test(priority=0,description="Dashboard Count", enabled=true)
  public void getDashboardQuickLaunchItemsCount() throws IOException {
	  Assert.assertTrue(dp.isWelcomeMsgDisplayed());
	  Reporter.log("Actual:"+dp.getQuickItemCount()+"---->"+"Expected:"+6);
	  TestUtility.embedScreenCapture();
	  Assert.assertEquals(dp.getQuickItemCount(),6);
	  
  }
  @Test(priority=1,description="Dashboard Item", enabled=true)
  public void getDashboardQuickLaunchItems() throws IOException
  {
	  Assert.assertTrue(dp.isWelcomeMsgDisplayed());
	  List<String> exp = new ArrayList<String>();
	  exp.add("Assign Leave");
	  exp.add("Leave List");
	  exp.add("Timesheets");
	  exp.add("Apply Leave");
	  exp.add("My Leave");
	  exp.add("My Timesheet");
	  List<String> actual = dp.getQuickLaunchItems();
	  Reporter.log("Actual:"+actual+"---->"+"Expected:"+exp);
	  TestUtility.embedScreenCapture();
	  Assert.assertEquals(actual, exp);
  }
  @BeforeClass
  public void beforeClass() throws IOException {
	  dr=TestBase.getInstance();
	  lp = new LoginPage(dr);
	  dp = new DashboardPage(dr);
	  lp.loginToApp(TestBase.prop.getProperty("Username"), TestBase.prop.getProperty("Password"));
  }

  @AfterClass
  public void afterClass() {
	  dr.quit();
  }

}
