package neoStoxPOMClassForBaseNutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class NeoStoxSignInPage 
{
	@FindBy(id="MainContent_signinsignup_txt_mobilenumber") private WebElement mobileNumField;
	@FindBy(id="lnk_signup1") private WebElement signInButton;
	@FindBy(id="MainContent_signinsignup_reqfld1") private WebElement errorMsg;
	
	
	public NeoStoxSignInPage (WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}

	public void enterMobileNumber(String mobNum)
	{
		mobileNumField.sendKeys(mobNum);
		Reporter.log("Entering mobile number", true);
	}
	
	public void clickOnSignInButton()
	{
		signInButton.click();
		Reporter.log("Clicking on sign in button", true);
	}
	
	public void validateErrorMsg()
	{
		String msg = errorMsg.getText();
		
		
		Reporter.log("Actual Eror MSg is "+msg, true);
		
		Assert.assertEquals(msg, "TC is Failed As Act ANd Exp Didn't Matched");
	}
	
}
