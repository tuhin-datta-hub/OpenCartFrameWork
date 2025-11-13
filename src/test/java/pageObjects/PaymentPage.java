package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {

	WebDriver driver;
	public PaymentPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath="//input[@placeholder='Enter your UPI ID']")
	WebElement enterUPI_txt;
	
	@FindBy(xpath="//button[text()='Verify']")
	WebElement verify_upi;
	
	@FindBy(xpath="//button[contains(text(),'Pay')]")
	WebElement pay_amount;
	
	public void enterUPI(String upi) {
		enterUPI_txt.sendKeys(upi);
	}
	
	public void clickVerify() {
		verify_upi.click();

	}
	
	public void Payment() {
		pay_amount.click();
	}

}
