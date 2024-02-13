package testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import bsh.This;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	public Logger log;
	public int choice;

   @Parameters({ "os", "browser" })
	@BeforeClass
	public void setup(String os, String br) throws InterruptedException, IOException {
		FileReader file = new FileReader("C:\\Users\\2303575\\eclipse-workspace\\seleniumproject\\hackathon\\src\\test\\resources\\configure.properties");
		p = new Properties();
		p.load(file);
		logger = LogManager.getLogger(this.getClass());

	if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			// os
			if (os.equalsIgnoreCase("Windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else {
				System.out.println("No matching os..");
				return;
			}

			// browser
			switch (br.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No matching browser..");
				return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);	
		}
	else if (p.getProperty("execution_env").equalsIgnoreCase("local")) {
			// launching browser based on condition - locally
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("No matching browser..");
				return;
			}
			//driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.zigwheels.com/");
			driver.manage().window().maximize();
			Thread.sleep(3000);

		}
   }

	/*@AfterClass
	public void tearDown() {
		driver.quit();
	}*/

}
