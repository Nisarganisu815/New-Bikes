package testCase;

import java.io.IOException;

import org.testng.annotations.Test;

import pageObject.Login;

public class TC003_login extends TC002_usedCars {
	
	
	@Test(priority = 7)
	public void getloginOrSignup() {
		Login li= new Login(driver);
		li.loginOrSignup();
		logger.info("clicked on login button");
	}
	@Test(priority = 8)
	public void getemailid() throws InterruptedException, IOException {
		Login li= new Login(driver);
		li.emailid();
		logger.info("login through google and the error message is captured");
	}

}
