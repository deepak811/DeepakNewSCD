package baseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;



import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.java.Scenario;
import utilities.TestUtil;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static WindowsDriver Windriver=null;
	 
	
	public BaseClass()
	{
		try
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream("C:/Users/Deepak.Badgotya/eclipse-workspace/NewSCD/src/main/java/configuration/Config.properties");
			prop.load(fis);
	}
		catch(IOException e)
		
		{
			e.getMessage();
			
		}
	}

	public void WinAppDriverMethod(String path) throws MalformedURLException, InterruptedException
	{
		String AppPath=path;
	DesiredCapabilities Dc=new DesiredCapabilities();
	Dc.setCapability("app", AppPath);
	//Dc.setCapability("platformName", "Windows");
	//Dc.setCapability("deviceName", "WindowsPC");
	Windriver=new WindowsDriver<WebElement>(new URL("http://127.0.0.1:4723/"),Dc); 
	
	}
	
	
	public static void initialization()
	{
		
	String browsername=prop.getProperty("Browser");
	if(browsername.equals("chrome"))
			{
		System.setProperty("webdriver.chrome.driver","C:/chromedriver2/chromedriver.exe");
		driver =new ChromeDriver();
		
			}
	else if(browsername.equals("firefox"))
	{
System.setProperty("webdriver.chrome.driver","C:/chromedriver1/chromedriver.exe");
driver =new FirefoxDriver();

	}
	
	driver.manage().window().maximize();;
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("Url"));
	
	}
	
	
	
}
