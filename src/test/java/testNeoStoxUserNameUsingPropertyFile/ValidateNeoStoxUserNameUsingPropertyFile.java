package testNeoStoxUserNameUsingPropertyFile;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import neoStoxBase1.Base1;
import neoStoxPOMClassForBaseNutility.NeoStoxDashBoardPage;
import neoStoxPOMClassForBaseNutility.NeoStoxHomePage;
import neoStoxPOMClassForBaseNutility.NeoStoxPasswordPage;
import neoStoxPOMClassForBaseNutility.NeoStoxSignInPage;
import neoStoxPOMClassForBaseNutility.Utility1;



//@Listeners(listener.Listener.class)
public class ValidateNeoStoxUserNameUsingPropertyFile extends Base1 
{
	NeoStoxDashBoardPage dash;
	NeoStoxHomePage home;
	NeoStoxSignInPage signIn;
	NeoStoxPasswordPage pass;
	
  @BeforeClass
  public void launchNeoStoxApp() throws IOException 
  {
	  launchBrowser();
	  home= new NeoStoxHomePage(driver);
	  signIn= new NeoStoxSignInPage(driver);
	  pass= new NeoStoxPasswordPage(driver);
	  dash= new NeoStoxDashBoardPage(driver);
  }
  
  @BeforeMethod
  public void loginToNeoStox() throws EncryptedDocumentException, IOException, InterruptedException
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
  
  @Test
  public void validateUserName() throws EncryptedDocumentException, IOException
  {
	  //Assert.fail();
     Assert.assertEquals(dash.getActualUserName(), Utility1.readDataFromPropertyFile("userName"),"Actual and Expected user Names are not matching TC is failed");
     
  }
  
  @Test
  public void validateACBalance() throws IOException
  {
     Assert.assertNotNull(dash.getAcBalance(),"AC Balance is null TC failed");
    
  }
  
  @AfterMethod
  public void logOutFromNeoStox() throws InterruptedException
  {  
	  Thread.sleep(3000);
	  dash.logOutFromNeoStox();
  }
  
  @AfterClass
  public void closeNeoStoxApp() throws InterruptedException
  {
	  Thread.sleep(3000);
     driver.close();
     Reporter.log("Closing application", true);
     Thread.sleep(1000);
  }
  }

