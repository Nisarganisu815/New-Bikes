package pageObject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;
	WebElement srcElement;
	String ss;
    
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void screenShot(String ss, WebElement srcElement ) throws IOException
	{
		
		File src = srcElement.getScreenshotAs(OutputType.FILE);
		File trg = new File(System.getProperty("user.dir")+"\\screenshots\\"+ss+".png");
		FileUtils.copyFile(src, trg);
	}
	

}
