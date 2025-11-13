package pageObjects;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	WebDriver driver;
	 WebDriverWait wait;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		  this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//input[@placeholder='Search for Products, Brands and More']")
	WebElement search_Box;
	
	@FindBy(xpath="//img[@class='-dOa_b L_FVxe']")
	WebElement login_btn;
	
	@FindBy(xpath="//a[text()='Cart']")
	WebElement cart_btn;
	
	@FindBy(xpath="//div[contains(text(),'Price -- Low to High')]")
	WebElement lowToHigh;

	
	@FindBy(xpath="//a[@title='Digital Dial Waterproof Smart Design LED Display Kids Watch for Boys & Girls Digital Watch  - For Boys & Girls DWWK-01']")
	WebElement selectedItem;
	
	public void clickLogin()
	{
		login_btn.click();
	}
	
	public void searchItem(String item) {
		
		search_Box.sendKeys(item,Keys.ENTER);
		
		
	}
	
	public void selectITEM() {
		wait.until(ExpectedConditions.elementToBeClickable(selectedItem));
		selectedItem.click();
		
	}
	public void priceLowToHigh() {
		
		wait.until(ExpectedConditions.elementToBeClickable(lowToHigh));
		lowToHigh.click();
	}
	
	public void clickCart()
	{
		cart_btn.click();
	}

}
