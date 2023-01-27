 package neoStoxPOMClassForBaseNutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxHomePage 
{

	//1 Data member should be declared globally with access level private using @findBy Annotation
	
	@FindBy(xpath="(//a[text()='Sign In'])[1]") private WebElement signInButton;
	
	//2 INitialize within a constructor with access level public using pagefactory
	
	public NeoStoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//3 Utilize within a method with acess level public
	
	public void clickOnSignButtton()
	{
		signInButton.click();
		Reporter.log("clicking on signin button", true);
	}
}
