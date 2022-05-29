package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	public static String browser;
	public static Properties prop;
	public static WebDriver getInstance() throws IOException
	{
		String path="./src/main/java/config/config.properties";
		FileInputStream instream = new FileInputStream(new File(path));
		prop = new Properties();
		prop.load(instream);
		browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriver"));
			driver = new ChromeDriver();
		} else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver",  prop.getProperty("edgeDriver"));
			driver = new EdgeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",  prop.getProperty("firefoxDriver"));
			driver = new FirefoxDriver();
		}else
		{
			Throwable thr = new Throwable();
			thr.initCause(null);
		}
		
		//Dimension d = new Dimension(400, 600);
		//driver.manage().window().setSize(d);
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
		//driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(prop.getProperty("url"));
		return driver;
		
	}
	
}
