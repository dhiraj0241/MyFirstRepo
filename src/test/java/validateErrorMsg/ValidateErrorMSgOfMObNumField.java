package validateErrorMsg;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import errorMessageValidationOfMobileNumberField.*;
import neoStoxBase1.Base1;
import neoStoxPOMClassForBaseNutility.NeoStoxDashBoardPage;
import neoStoxPOMClassForBaseNutility.NeoStoxHomePage;
import neoStoxPOMClassForBaseNutility.NeoStoxPasswordPage;
import neoStoxPOMClassForBaseNutility.NeoStoxSignInPage;
import neoStoxPOMClassForBaseNutility.Utility1;

public class ValidateErrorMSgOfMObNumField extends Base1 {
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
		      
		      signIn.validateErrorMsg();
		      
		     
		}
		
		@AfterClass
		public void closeBrowse() throws InterruptedException
		{
			Thread.sleep(3000);
		     driver.close();
		}
	}

}
