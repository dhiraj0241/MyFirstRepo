
package errorMessageValidationOfMobileNumberField;

import org.testng.annotations.Test;

import neoStoxBase1.Base1;
import neoStoxPOMClassForBaseNutility.NeoStoxDashBoardPage;
import neoStoxPOMClassForBaseNutility.NeoStoxHomePage;
import neoStoxPOMClassForBaseNutility.NeoStoxPasswordPage;
import neoStoxPOMClassForBaseNutility.NeoStoxSignInPage;
import neoStoxPOMClassForBaseNutility.Utility1;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeClass;
import java.io.IOException;
import org.testng.annotations.AfterClass;


@Listeners(listener.Listener.class)
public class ValidateErrorMessageOfMobNumField extends Base1 
{
	
	NeoStoxDashBoardPage dash;
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;
	NeoStoxPasswordPage pass;
	
	
	@BeforeClass
	public void browserLaunch() throws IOException 
	{
		launchBrowser();
		
		home= new NeoStoxHomePage(driver);
	    signIn= new NeoStoxSignInPage(driver);
	    pass= new NeoStoxPasswordPage(driver);
		dash= new NeoStoxDashBoardPage(driver);
		
	}
	
	@Test
	public void loginToNeostox() throws InterruptedException, IOException
	{
		 home.clickOnSignButtton();
	      Utility1.implicitWait(1000, driver);
	
	      signIn.enterMobileNumber(Utility1.readDataFromPropertyFile("mobile"));
	      Thread.sleep(1000);
	      signIn.clickOnSignInButton();
	      
	      Utility1.implicitWait(1000, driver);
	      pass.enterPassword(Utility1.readDataFromPropertyFile("password"));
	      pass.clickOnSubmitButton();
	     
	      Utility1.implicitWait(1000, driver);
	      dash.handlePopUp(driver);
	}
	
	@AfterClass
	public void closeBrowse() throws InterruptedException
	{
		Thread.sleep(3000);
	     driver.close();
	}
}
