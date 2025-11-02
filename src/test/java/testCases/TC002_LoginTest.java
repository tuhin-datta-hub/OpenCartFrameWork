package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBases.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups = {"sanity","master"})
	public void login() {
		logger.info("***Starting of TC001_AccountRegistration***");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***clicked on myaccount**");

			hp.clickLogin();
			logger.info("***clicked on login**");

			LoginPage login = new LoginPage(driver);
			login.setEmail(pf.getProperty("Email"));
			login.setPwd(pf.getProperty("Password"));
			login.clickLogin();
			logger.info("***loggedIN successfully**");

			MyAccountPage myacc = new MyAccountPage(driver);
			boolean target_msg = myacc.isMsgDisplayed();

			Assert.assertEquals(target_msg, true, "login fail");
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail();
		}

	}
}