package pageObject;

import java.io.IOException;
import java.util.List;

import javax.swing.JScrollBar;
import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import testBase.BaseClass;
import utilities.ExcelUtils;

public class UpcommingBikes extends BasePage {

	public UpcommingBikes(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// @locators
	@FindBy(xpath = "//*[@id='headerNewNavWrap']/nav/div/ul/li[3]/a")
	WebElement newbikesElement;
	@FindBy(xpath = "//*[@id='headerNewNavWrap']/nav/div/ul/li[3]/ul/li[5]/span")
	WebElement upcomingbikesElement;
	@FindBy(xpath = "//*[@id=\"makeId\"]")
	WebElement manufacturersElement;
	@FindBy(xpath = "//*[@id=\"makeId\"]/option[4]")
	WebElement hondaElement;
	@FindBy(xpath = "//*[@id='modelList']/li['+i+']")
	WebElement pricElement;
	@FindBy(xpath="//li[16]/span")
	WebElement viewMoreBikes;
	@FindBy(xpath="//div[@class='p-15 pt-10 mke-ryt rel']/a/strong")
	public List<WebElement> Bike_Names;
	@FindBy(xpath="//li[contains(@class,'modelItem')]")
	public List<WebElement> priceOfBike;
	@FindBy(xpath="//div[@class='p-15 pt-10 mke-ryt rel']/div[1]")
	public List<WebElement>Bike_Prices;
	@FindBy(xpath="//div[@class='p-15 pt-10 mke-ryt rel']/div[2]")
	public List<WebElement>Bike_Launchdate;

	

	// @actions
	public void getnewbikes() throws InterruptedException {
		
		Actions ac = new Actions(driver);
		ac.moveToElement(newbikesElement).perform();
		System.out.println("Hovered");
		//ac.moveToElement(upcomingbikesElement).click().perform();


	}

	public void getupcomingbikes() {
		upcomingbikesElement.click();
	}

	public void getmanufacturers() throws InterruptedException {
		// driver.switchTo().frame("/html/body/main/div/div/div[1]");
		Thread.sleep(8000);
		manufacturersElement.click();
		hondaElement.click();
	}
	
	public void moreBikes() {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", viewMoreBikes);
		js.executeScript("arguments[0].click();", viewMoreBikes);
	}
	  public void getprice() throws InterruptedException, IOException {
		  
		
				int j=1;
				//String xlFile = System.getProperty("user.dir")+"\\testData\\zigWheels.xlsx";
				System.out.println("-----------------------------");
				for(int i=0;i<Bike_Names.size();i++) {
					int price = Integer.parseInt(priceOfBike.get(i).getAttribute("data-price"));
					if(price<400000) {
						System.out.println(Bike_Names.get(i).getText());
						//ExcelUtils.setCellData(xlFile, "upcomingBikes", j, 0,Bike_Names.get(i).getText());
						System.out.println(Bike_Prices.get(i).getText());
						//ExcelUtils.setCellData1(xlFile, "upcomingBikes", j, 1,Bike_Prices.get(i).getText());
						System.out.println(Bike_Launchdate.get(i).getText());
						System.out.println("-----------------------------------");
						//ExcelUtils.setCellData1(xlFile, "upcomingBikes", j, 2,Bike_Launchdate.get(i).getText());
						j++;
					}
					else {
						continue;
					}
						
					}
				}
}
