package pageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage{

	public Login(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub	
	}

	
      //locators
	@FindBy(xpath = "//*[@id=\"forum_login_title_lg\"]")
	WebElement loginElement;
	@FindBy(xpath = "//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[3]/div[6]/div")
	WebElement googleElement;
	@FindBy(xpath = "//*[@id=\"identifierId\"]")
	WebElement emailidElement;
	@FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/div[3]")
	WebElement nextbtnElement;
	@FindBy(xpath="//div[@class=\"o6cuMc Jj6Lae\"]")
	WebElement errorMsgElement;
	
	//actions
	public void loginOrSignup() {
		loginElement.click();
		googleElement.click();
		
	}
	
	public String emailid() throws InterruptedException, IOException {
		
		Set<String> winIdSet = driver.getWindowHandles();
		List<String> winIdList =new ArrayList<>(winIdSet);
		driver.switchTo().window(winIdList.get(1));

		emailidElement.sendKeys("dcgvduy@gmail.com");
		 JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", nextbtnElement);
		screenShot("error message", errorMsgElement);

		return errorMsgElement.getText();
		
	}
	
}
