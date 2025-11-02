package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement login_email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement login_pwd;
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	WebElement lnk_forgotpassoerd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement login_btn;
	
	public void setEmail(String email) {
		login_email.sendKeys(email);
	}
	
	public void setPwd(String pwd) {
		login_pwd.sendKeys(pwd);
	}
	
	public void clickLogin() {
		login_btn.click();
	}
}
