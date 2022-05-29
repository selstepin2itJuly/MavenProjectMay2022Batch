package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;
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

public class MyInfoTest {
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	private MyInfoPage mip;
  @Test(priority=0,description="Info Count", enabled=true)
  public void getMyInfoItemsCount() throws IOException {
	  Assert.assertTrue(dp.isWelcomeMsgDisplayed());
	  mip.clickOnMyInfoTab();
	  int act = mip.getSideMenuItemCount();
	  Reporter.log("Actual:"+act+"---->"+"Expected:"+11);
	  TestUtility.embedScreenCapture();
	  Assert.assertEquals(act,11);
	  
  }
  @Test(priority=0,description="Info item", enabled=true, dependsOnMethods="getMyInfoItemsCount")
  public void getMyInfoItems() throws IOException
  {
	  Assert.assertTrue(dp.isWelcomeMsgDisplayed());
	  mip.clickOnMyInfoTab();
	  List<String> exp = new ArrayList<String>();
	  exp.add("Personal Details");
	  exp.add("Contact Details");
	  exp.add("Emergency Contacts");
	  exp.add("Dependents");
	  exp.add("Immigration");
	  exp.add("Job");
	  exp.add("Salary");
	  exp.add("Tax Exemptions");
	  exp.add("Report-to");
	  exp.add("Qualifications");
	  exp.add("Memberships");
	  List<String> actual = mip.getSideMenuItems();
	  Reporter.log("Actual:"+actual+"---->"+"Expected:"+exp);
	  TestUtility.embedScreenCapture();
	  Assert.assertEquals(actual, exp);
  }
  @BeforeClass
  public void beforeClass() throws IOException {
	  dr=TestBase.getInstance();
	  lp = new LoginPage(dr);
	  dp = new DashboardPage(dr);
	  mip = new MyInfoPage(dr);
	  lp.loginToApp(TestBase.prop.getProperty("Username"), TestBase.prop.getProperty("Password"));
  }

  @AfterClass
  public void afterClass() {
	  dr.quit();
  }

}
