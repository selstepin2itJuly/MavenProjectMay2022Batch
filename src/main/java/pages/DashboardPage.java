package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	private WebDriver driver;
	/*constructor*/
	public DashboardPage(WebDriver dr)
	{
		this.driver=dr;
		/*important*/
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcomeMsg;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	@FindBy(xpath="//div[@class='quickLaunge']/descendant::span")
	private List<WebElement> quickLaunch;
	
	public boolean isWelcomeMsgDisplayed()
	{
		boolean b=false;
		try {
			b=welcomeMsg.isDisplayed();
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return b;
	}
	public String retunrWelcomeMsg()
	{
		String s = null;
		if(isWelcomeMsgDisplayed())
		{
			s=welcomeMsg.getText().trim();
		}
		return s;
	}
	
	public void logout()
	{
		if(isWelcomeMsgDisplayed())
		{
			welcomeMsg.click();
			logout.click();
		}else
		{
			System.out.print("Logout Option not displayed");
		}
	}
	
	public int getQuickItemCount()
	{
		return quickLaunch.size();
	}
	
	public List<String> getQuickLaunchItems()
	{
		List<String> temp = new ArrayList<String>();
		for(WebElement e:quickLaunch)
		{
			temp.add(e.getText().trim());
		}
		return temp;
	}
}
