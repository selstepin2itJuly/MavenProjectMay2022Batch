package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import testbase.TestBase;

public class TestUtility extends TestBase{

	public static void scrollToElement(WebElement e)
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].scrollIntoView(false)", e); //default is true
		j.executeScript("window.scrollBy(0,400)", "");
	}
	
	public static void clickOnElementJS(WebElement e)
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", e);
		
	}
	
	public static void captureScreenshot() throws IOException
	{
		File nfile = new File("./screenshot");
		if(!nfile.isDirectory())
		{
			nfile.mkdir();
		}
		TakesScreenshot tk = (TakesScreenshot) driver;
		File file = tk.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(file, new File("./"+"screenshot/"+getDate()+"_image.jpg"));
	}
	
	public static void embedScreenCapture() throws IOException
	{
		
		TakesScreenshot tc=(TakesScreenshot) driver;
		String src = tc.getScreenshotAs(OutputType.BASE64);
		String image="<img src=\"data:image/png;base64," + src + "\" height=\"600\" width=\"800\" />";
		Reporter.log(image);  
		
	}
	private static String getDate()
	{
		
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY_MMM_dd_HH_mm_ss_SSS");
		String temp = sdf.format(dt);
		System.out.println(temp);
		return temp;
	}
	
	public static void waitForElementclickable(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void waitForElementVisbile(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void waitForElementInvisible(WebElement ele)
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);

		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
