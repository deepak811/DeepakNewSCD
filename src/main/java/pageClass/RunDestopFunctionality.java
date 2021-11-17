package pageClass;

import baseClass.BaseClass;
import io.appium.java_client.windows.WindowsElement;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;

import org.jsoup.nodes.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RunDestopFunctionality extends BaseClass
{

	
public void ProcessWorkflow(String path) throws InterruptedException, MalformedURLException {
        //Thread.sleep(40000);
	
 	//WinAppDriverMethod(path);
	Thread.sleep(40000);
	Windriver.findElement(By.xpath("/Pane[@Name='Desktop 1'][@ClassName='#32769']/window[@AutomationId='frmlogoscreen'][@Name='1040SCAN : Review Wizard']/button[starts-with(@AutomationId,'Button2')][@Name='Next &gt;']")).click();

/*Set<String> 	dezskwindowinstance=Windriver.getWindowHandles();
	System.out.println("window id is" + dezskwindowinstance);
	Iterator<String> idz=dezskwindowinstance.iterator();
	String firstwin=idz.next();
	System.out.println("win id is" + firstwin);
	driver.switchTo().window(firstwin);*/
	

        //Thread.sleep(40000);
       // WebDriverWait wait = new WebDriverWait(Windriver,120);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//Window[@AutomationId='frmlogoscreen'][@Name='1040SCAN : Review Wizard']/Button[starts-with(@AutomationId,'Button2')]"))).click();
	//Thread.sleep(50000);
	//Windriver.findElement(By.xpath("//window[@RuntimeId='2A.210FE2'][@Name='1040SCAN : Review Wizard']/button[starts-with(@RuntimeId,'2A.2004AA')]")).click();
//Windriver.findElementByXPath("//window[contains(@AutomationId,'frmlogoscreen')]/*[contains(@AutomationId,'Button2')]").click();
// Windriver.findElement(By.xpath("//button[@AutomationId='Button2']")).click();
	///Window[@AutomationId=\"frmlogoscreen\"][@Name=\"1040SCAN : Review Wizard\"]"

	//Windriver.findElement(By.xpath("//*[@AutomationId='frmlogoscreen' and @Name='1040SCAN : Review Wizard']/*[contains(@AutomationId,'Button2')]")).click();
	//Windriver.findElement(By.xpath("xpath:/Window[@AutomationId='frmlogoscreen' and @Name='1040SCAN : Review Wizard']/Button[contains(@AutomationId,'Button2')]")).click();
	boolean flag=CheckAndProcessReviewWizard();
        
        flag=CheckAndProcessVarificationWizard();
        
        
        
        
        
    }
    public boolean CheckAndProcessReviewWizard() {
        boolean flag=false;
        WebDriverWait wait=new WebDriverWait(Windriver, 30);
        try {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/*[contains(@AutomationId,'Verification')]/*[contains(@AutomationId,'MainChkBox')]"))).click();
        //windriver.findElementByXPath("/*[contains(@AutomationId,'Verification')]/*[contains(@AutomationId,'MainChkBox')]").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/*[contains(@AutomationId,'Verification')]/*[contains(@AutomationId,'Button1')]"))).click();
        flag=true;
        }catch(Exception e) {
            return flag;
        }
        return flag;
    }
    public boolean CheckAndProcessVarificationWizard() {
    boolean flag=false;

 

    WebDriverWait wait=new WebDriverWait(Windriver, 180);
    //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/*[contains(@AutomationId,'SPVContainer')]")));
    try {
            wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("/*[@AutomationId='SPVContainer']"))));
            //String h=a.getAttribute("Name");
        if(Windriver.findElement((By.xpath("/*[@AutomationId='SPVContainer']"))).isEnabled()) {
            String b=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@ClassName='WindowsForms10.STATIC.app.0.6255dd_r30_ad1' and starts-with(@Name,' of ')]"))).getAttribute("Name");
            //RemoteWebElement a=(RemoteWebElement)windriver.findElement(By.xpath("//*[contains(ControlType'ControlType.Pane' and AutomationId='UCSPVToolbar']"));
            //a=(RemoteWebElement)a.findElement(By.xpath("/*[AutomationId='UCSPVToolbar']"));
            //RemoteWebElement a=(RemoteWebElement)windriver.findElement(By.xpath("/*[starts-with(@Name,' of ')]"));
            //String b =a.getAttribute("Name");
                    b=b.replace("of", " ");
            b=b.trim();
            int pageCount=Integer.parseInt(b);
            
        
            if(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/*[contains(@ControlType,'ControlType.Hyperlink')]/[contains(@Name,'Reviewed')]"))).isEnabled()) {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/*[contains(@ControlType,'ControlType.Hyperlink')]/[contains(@Name,'Reviewed')]"))).click();////*[contains(@ControlType, ) and contains(@AutomationId,'lblReviewed')]"))).click();
                //String winHandle=windriver.getWindowHandle();
                //winHandle.length();
                //windriver.switchTo().window(winHandle);
                Windriver.findElement(By.xpath("//*[contains(@AutomationId,'RbtnMoveNext')]")).click();
                Windriver.findElement(By.xpath("//*[contains(@AutomationId,'btnOk')]")).click();
                Windriver.switchTo().defaultContent();
            }
            /*    do {
            
            }while(pageCount>0);*/
    
        }
    flag=true;
    }catch(Exception e) {
        return flag;
    }
    return flag;
  }
}
