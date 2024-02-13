package testCase;

import org.testng.annotations.Test;

import io.reactivex.rxjava3.subjects.UnicastSubject;
import pageObject.UsedCars;
import testBase.BaseClass;

public class TC002_usedCars extends TC001_upcomingBikes {
	
	@Test(priority = 4)
    public void gethomepage() {
    	UsedCars uc =new UsedCars(driver);
    	uc.homepage();
    	logger.info("reached the home page");
    	
    }
	
	@Test(priority = 5)
	public void getusedcars() throws InterruptedException {
		Thread.sleep(3000);
		UsedCars uc =new UsedCars(driver);
		uc.usedcars();
		logger.info("mouse hovered on used Cars and selected chenai location ");
}
	
	@Test(priority = 6)
	public void getpopularmodules() {
		UsedCars uc = new UsedCars(driver);
		uc.popularmodels();
		logger.info("got all the popular models and navigated back to homepage");
	}
}