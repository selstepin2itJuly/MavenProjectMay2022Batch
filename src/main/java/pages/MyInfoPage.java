package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtility;

public class MyInfoPage {

	private WebDriver dr;
	public MyInfoPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(id="menu_pim_viewMyDetails")
	private WebElement myInfo;
	
	@FindBy(css="[id='employee-details'] li a")
	private List<WebElement> sideMenu;
	
	public void clickOnMyInfoTab()
	{
		myInfo.click();
	}
	
	public int getSideMenuItemCount()
	{
		//TestUtility.waitForElementVisbile(sideMenu.get(0));
		return sideMenu.size();
	}
	
	public List<String> getSideMenuItems()
	{
		//TestUtility.waitForElementVisbile(sideMenu.get(0));
		List<String> temp = new ArrayList<String>();
		for(WebElement e:sideMenu)
		{
			temp.add(e.getText().trim());
		}
		return temp;
	}
}
