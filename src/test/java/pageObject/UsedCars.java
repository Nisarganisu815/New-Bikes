package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UsedCars extends BasePage{
	public UsedCars(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//locators
	@FindBy(xpath="//*[@id=\"Header\"]/div/div[1]/div[1]/a/img")
	WebElement homElement;
	@FindBy(xpath = "//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/a")
	WebElement usedcarsElement;
	@FindBy(xpath = "//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[7]/ul/li/div[2]/ul/li[4]/span")
	WebElement chennaiElement;
	@FindBy(xpath = "/html/body/div[7]/div/div[1]/div[1]/div[1]/div[2]/ul/li[2]/div[2]/div[5]/ul/li/label")
	List<WebElement> popularmodelsElements;
	
	
	//actions
	public void homepage() {
		homElement.click();
		
	}
 public void usedcars() {
	
		Actions ac = new Actions(driver);
		ac.moveToElement(usedcarsElement).perform();
		ac.moveToElement(chennaiElement).click().perform();
	 }
  public void popularmodels() {
		  
		  for(WebElement popularmodelsname:popularmodelsElements)
		  {
			  System.out.println(popularmodelsname.getText());
			  
		  }
		 driver.navigate().back(); 
	  }
	  

}
