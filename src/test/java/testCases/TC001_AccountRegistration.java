package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegister;
import pageObjects.HomePage;
import testBases.BaseClass;

public class TC001_AccountRegistration extends BaseClass {

	@Test(groups = {"regression","master"})
	public void verify_Account_Registration() {
		logger.info("***Starting of TC001_AccountRegistration***");

		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("***clicked on myaccount**");

		hp.clickRegister();
		logger.info("***clicked on myaccount**");

		AccountRegister ar = new AccountRegister(driver);

		logger.info("***Providing customer details**");
		ar.setFirstName(randomString().toUpperCase());
		ar.setLastName(randomString().toUpperCase());
		ar.setEmail(randomString() + "@gmail.com");
		ar.setPhoneNumber(randomNumber());

		String pwd = randomAlphaNumeric();

		logger.info("***Providing password**");
		ar.setPassword(pwd);
		ar.setConfirmPassword(pwd);

		ar.setPrivacyPolicy();
		logger.info("***clicked on privacy policy**");
		ar.setclickContinue();
		logger.info("***clicked on continue**");

		String confirmMsg = ar.getcnfMessage();

		Assert.assertEquals(confirmMsg, "Your Account Has Been Created!");
	}
}
