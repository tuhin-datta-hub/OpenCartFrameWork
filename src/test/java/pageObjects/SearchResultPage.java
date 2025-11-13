package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends BasePage{

	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	public SearchResultPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.act = new Actions(driver); 
		
	}
	
	@FindBy(xpath="//button[text()='Add to cart']")
	WebElement addToCart_btn;
	
	@FindBy(xpath="//button[contains(text(),'Buy Now')]")
	WebElement buyNow_btn;
	
	
	public void AddToCart() {
		addToCart_btn.click();
		}
	public void BuyNow() {
		try {
			  wait.until(ExpectedConditions.visibilityOf(buyNow_btn));
			wait.until(ExpectedConditions.elementToBeClickable(buyNow_btn));
			act.scrollToElement(buyNow_btn).perform();;
			buyNow_btn.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
