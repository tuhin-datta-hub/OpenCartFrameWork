package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBases.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "datadriven")
	public void loginDDT(String email, String pwd, String exp_res) {
		logger.info("***Starting of TC003_***");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***clicked on myaccount**");

			hp.clickLogin();
			logger.info("***clicked on login**");

			LoginPage login = new LoginPage(driver);
			login.setEmail(email);
			login.setPwd(pwd);
			login.clickLogin();
			logger.info("***loggedIN successfully**");

			MyAccountPage myacc = new MyAccountPage(driver);
			boolean target_msg = myacc.isMsgDisplayed();

			/*
			 * Data is valid - login success - test pass -logout login failed -
			 * test fail
			 */

			if (exp_res.equalsIgnoreCase("valid")) {
				if (target_msg == true) {
					myacc.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

			}
			/*
			 * Data is invalid - login success - test fail -logout 
			 * 					login failed - test pass
			 */
			if (exp_res.equalsIgnoreCase("invalid")) {
				if (target_msg == true) {
					myacc.clickLogout();
					Assert.assertTrue(false);

				} 
				else {
					
					Assert.assertTrue(true);
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}		
	
		logger.info("***Starting of TC003_***");
	}

}
