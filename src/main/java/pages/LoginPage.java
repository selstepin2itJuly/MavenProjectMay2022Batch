package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	/*constructor*/
	public LoginPage(WebDriver dr)
	{
		this.driver=dr;
		/*important*/
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name="txtUsername")
	private WebElement user;
	
	@FindBy(css="[name='txtPassword']")
	private WebElement pass;
	
	@FindBy(xpath="//input[@value='LOGIN']")
	private WebElement login;
	
	public void loginToApp(String username, String password)
	{
		user.clear();
		user.sendKeys(username);
		pass.clear();
		pass.sendKeys(password);
		login.click();
	}
	
	public boolean checkLoginButton()
	{
		boolean b=false;
		try {
			b=login.isDisplayed();
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return b;
	}
}
