package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import io.cucumber.java.Scenario;
import utilities.TestUtil;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static WiniumDriver Windriver;
	 
	
	public BaseClass()
	{
		try
		{
			prop=new Properties();
			//FileInputStream fis=new FileInputStream("C:/Users/Deepak.Badgotya/eclipse-workspace/NewSCD/src/main/java/configuration/Config.properties");
FileInputStream fis=new FileInputStream( System.getProperty("user.dir")+"/src/main/java/configuration/Config.properties");
			//below is for remote machine and above one is for ur own VDI
			//FileInputStream fis=new FileInputStream("C:/Users/automatedtesting4/.jenkins/workspace/NewSCD WebApplication Functionality/src/main/java/configuration/Config.properties");
			prop.load(fis);
	}
		catch(IOException e)
		
		{
			e.getMessage();
			
		}
	}
	 public static String printCurrentWorkingDirectory1() {
		 File currDir = new File(".");
		 String path = currDir.getAbsolutePath();
		 path = path.substring(0, path.length()-1);
		 System.out.println(path);
		return path;
		 }

	//public void WiniumMethod(String path) throws MalformedURLException
	 //String appPath = path;
	 public static void main(String[] args) throws MalformedURLException
	{
		
        String appPath = "C:/Program Files (x86)/SurePrepLLC/PBFX/SurePrep.PortableBinderFormat(PBF).exe";
        //"C:/Program Files (x86)/SurePrepLLC/PBFX/SurePrep.PortableBinderFormat(PBF).exe";
  DesktopOptions option = new DesktopOptions();
 option.setApplicationPath(appPath);
  option.setDebugConnectToRunningApp(false);
  option.setLaunchDelay(5);
  WiniumDriver   Windriver = new WiniumDriver(new URL("http://localhost:9999"),option);
 WebElement element=Windriver.findElement(By.id("SPVContainer"));
 Windriver.findElement(By.xpath("//*[@id='Submit']")).click();
 Windriver.findElement(By.xpath("//button[text()='Submit Engagement']")).click();
 Windriver.findElement(By.xpath("//button[text()='Submit']")).click();
 Windriver.findElement(By.xpath("//button[contains(@AutomationId,'Submit')]")).click();
 Windriver.findElement(By.xpath("//button[@AutomationId='Submit']")).click();
  Windriver.findElement(By.xpath("//button[@id='Submit']")).click();
  
//button[@id='btnCreateUser']
		/*
		 * this is for winappdriver
		 * /String AppPath=path;
	//DesiredCapabilities Dc=new DesiredCapabilities();
	//Dc.setCapability("app", AppPath);
	//Dc.setCapability("platformName", "Windows");
	//Dc.setCapability("deviceName", "WindowsPC");
//	Windriver=new WindowsDriver(new URL("http://127.0.0.1:4723/"),Dc); 
		 */
		
	
	}
	
	
	public static void initialization()
	{
		
	String browsername=prop.getProperty("Browser");
	if(browsername.equals("chrome"))
			{
	System.setProperty("webdriver.chrome.driver","C:/chromedriver2/chrdriver/chromedriver.exe");
		//below is for remote machine and above one is for ur own VDI
		//System.setProperty("webdriver.chrome.driver","C:/chromedriver/chromedriver.exe");
		
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
