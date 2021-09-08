package pageClass;




import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.apache.commons.io.FilenameUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;
//import junit.framework.Assert;

public class VerifierOpenBinder extends BaseClass{
	@FindBy(xpath="//button[@id='btnActivity']")
	WebElement activityBtn;
	
	@FindBy(xpath="//a[@id='2014']")
	WebElement verifierQueue;
	
	@FindBy(xpath="//a[@id='searchIcon']")
	WebElement binderSearchBtn;
	
	@FindBy(xpath="//input[@id='txtgdSearch']")
	WebElement searchTextBoxBinder;
	
	@FindBy(xpath="//a[@id='clearFilter']")
	WebElement BindrSrchClearBtn;
	
	@FindBy(xpath="//div[@id='divBinderOpen']")
	WebElement openBinderBtn;
	
	@FindBy(xpath="//table/tbody/tr[1]/td[1]")
	WebElement ThreeDots;
	
	
	public VerifierOpenBinder()
	{
		
		PageFactory.initElements(driver,this);
	}
	

	public String OpenBinderForVerifierFeature() throws Exception
	{
		String filePath=null;
		Thread.sleep(5000);
		
		JSONParser jparser= new JSONParser();
		FileReader fr=new FileReader(System.getProperty("user.dir")+"/src/main/java/testData/VerifierLogin.json");
		JSONObject jobject=(JSONObject) jparser.parse(fr);
		JSONArray jarray=(JSONArray) jobject.get("Credentials");
		for(int i=0;i<jarray.size();i++)
		{
			JSONObject cred=(JSONObject) jarray.get(i);
		String	binderId=(String)cred.get("BinderId");
		//String	pass=(String)cred.get("Password");
		//driver.wait(20000);
		Thread.sleep(3000);
		activityBtn.click();
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		verifierQueue.click();
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		binderSearchBtn.click();
		Thread.sleep(3000);
		searchTextBoxBinder.sendKeys(binderId);
		Thread.sleep(3000);
		if(openBinderBtn.isEnabled()==true)
		openBinderBtn.click();
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		Thread.sleep(7000);
        //driver.findElement(By.name("Downloads bar")).click();
        File path= new File("C:/Users/Deepak.Badgotya/Downloads");
        File url=waitForDownloadToComplete(path, binderId);
         filePath=url.getPath();
        //Runtime.getRuntime().exec(filePath);
        //desktopInitialization(filePath);
        //return filePath;
        }
        return filePath;
    }

		
	
	
	public void BindrIDFromTestData() throws IOException, ParseException, InterruptedException
	{
		Thread.sleep(5000);
		JSONParser jparser= new JSONParser();
		FileReader fr=new FileReader( System.getProperty("user.dir")+"/src/main/java/testData/VerifierLogin.json");
		JSONObject jobject=(JSONObject) jparser.parse(fr);
		JSONArray jarray=(JSONArray) jobject.get("Credentials");
		for(int i=0;i<jarray.size();i++)
		{
			JSONObject cred=(JSONObject) jarray.get(i);
		String	binderId=(String)cred.get("BinderId");
		}
		
	}
	public static File waitForDownloadToComplete(File downloadPath, String fileName) throws Exception {
        boolean isFileFound = false;
        int waitCounter = 0;
        while (!isFileFound) {
           // logger.info("Waiting For Download To Complete....");
            for (File tempFile : downloadPath.listFiles()) {
                if (tempFile.getName().contains(fileName)) {
                    String tempEx = FilenameUtils.getExtension(tempFile.getName());
                    // crdownload - For Chrome, part - For Firefox
                    if (tempEx.equalsIgnoreCase("crdownload") || tempEx.equalsIgnoreCase("part")) {
                        Thread.sleep(1000);
                    } else {
                        isFileFound = true;
                      //  Logger.info("Download To Completed....");
                        return tempFile;
                    }
                }
            }
            Thread.sleep(1000);
            waitCounter++;
            if (waitCounter > 25) {
                isFileFound = true;
            }
        }
        throw new Exception("File Not Downloaded");
        
    }
	
}



