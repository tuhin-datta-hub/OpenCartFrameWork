package testCases;

import org.testng.annotations.Test;

import pageObjects.BuyProductPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.PaymentPage;
import pageObjects.SearchResultPage;
import testBases.BaseClass;

public class EndToEndTest extends BaseClass {
	@Test
	public void userLogin() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		 hp.clickLogin();
			
			LoginPage lp=new LoginPage(driver);
			lp.setMob(pf.getProperty("mob"));
			lp.clickRequestOTP();
			lp.setOTP();
			lp.verifyOTP();
		
		
		hp.searchItem("watchs");
		hp.priceLowToHigh();
		hp.selectITEM();
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		

		SearchResultPage srp= new SearchResultPage(driver);
		
		srp.BuyNow();
		
		BuyProductPage bp=new BuyProductPage(driver);
		
		bp.continueOrder();
		
		PaymentPage pp=new PaymentPage(driver);
		
		pp.enterUPI(pf.getProperty("upi"));
		pp.clickVerify();
		pp.Payment();

		
		
	}
	

}
