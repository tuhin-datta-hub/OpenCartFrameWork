package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuyProductPage extends BasePage {

	WebDriver driver;
	public BuyProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//button[text()='CONTINUE']")
	WebElement continue_btn;
	
	public void continueOrder() {
		continue_btn.click();
	}

}
