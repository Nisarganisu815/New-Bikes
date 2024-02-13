package testCase;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import freemarker.log.Logger;
import pageObject.UpcommingBikes;
import pageObject.UsedCars;
import testBase.BaseClass;

public class TC001_upcomingBikes extends BaseClass {

	@Test(priority = 1)
	public void getnewbikesaction() throws InterruptedException {
		Thread.sleep(3000);
		UpcommingBikes ub = new UpcommingBikes(driver);
		ub.getnewbikes();
		logger.info("mouse hovered on New Bikes");
		ub.getupcomingbikes();
		logger.info("clicked on upcoming Bikes");
	}

	@Test(priority = 2)
	public void getmanufacture() throws InterruptedException {
		UpcommingBikes ub = new UpcommingBikes(driver);
		ub.getmanufacturers();
		logger.info("clicked on dropdown button of manufacturers and select honda ");
	}

	@Test(priority = 3)
	public void getpriceamount() throws InterruptedException, IOException {
		UpcommingBikes ub = new UpcommingBikes(driver);
		ub.moreBikes();
		logger.info("clicked on view more to see all bikes available");
		ub.getprice();
		logger.info("got all the bikes which is less than 4lac with the name, price and launch date");

	}
}
