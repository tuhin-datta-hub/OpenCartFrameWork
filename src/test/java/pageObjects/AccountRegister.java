package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegister extends BasePage{

	WebDriver driver;
	
	public AccountRegister(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txt_FirstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txt_LastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_Email;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txt_Telephone;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Pwd;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txt_cnf_Pwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chk_policy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue;
	
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement cnfMessage;
	
	public void setFirstName(String fname) 
	{
		txt_FirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) 
	{
		txt_LastName.sendKeys(lname);
	}
	
	public void setEmail(String email) 
	{
		txt_Email.sendKeys(email);
	}
	
	public void setPhoneNumber(String ph_num)
	{
		txt_Telephone.sendKeys(ph_num);
	}
	
	public void setPassword(String pwd)
	{
	   txt_Pwd.sendKeys(pwd);	
	}
	
	public void setConfirmPassword(String pwd)
	{
		txt_cnf_Pwd.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		chk_policy.click();
	}
	
	public void setclickContinue()
	{
		btn_continue.click();
	}
	
	
	public String getcnfMessage()
	{
		try {
			return(cnfMessage.getText());
		} 
		catch (Exception e) {
			return(e.getMessage());
		}
	}
	
}

