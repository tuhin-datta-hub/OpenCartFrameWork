package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@class='r4vIwl BV+Dqf']")
	WebElement mob_txt;
	
	@FindBy(xpath="//button[text()='Request OTP']")
	WebElement requestOtp_btn;
	
	@FindBy(xpath="//div[@class='XDRRi5']")
	WebElement otp_value;
	
	@FindBy(xpath="//button[text()='Verify']")
	WebElement otp_verify;
	
	public void setMob(String mob) {
		mob_txt.sendKeys(mob);
	}
	
	
	public void clickRequestOTP() {
		requestOtp_btn.click();
	}
	
	public void setOTP() throws InterruptedException {
		otp_value.click();
		Thread.sleep(5000);
		
	}
	
	public void verifyOTP() {
		otp_verify.click();
	}
}
