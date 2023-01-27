package listener;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxBase1.Base1;
import neoStoxPOMClassForBaseNutility.Utility1;


public class Listener extends Base1 implements ITestListener
{

	
	public void onTestFailure(ITestResult result)
	{
	
		try
	{
	    Reporter.log("TC " +result.getName()+" failed ", true);
	    Utility1.takeScreenshot(driver, result.getName());
	}
	
		catch (IOException e) 
	{  
		e.printStackTrace();
	}	
	}
	
	
	public void onTestSuccess(ITestResult result)
	{
	
		Reporter.log("TC "+result.getName()+ " is passed successfully", true);
	}
	
	
	public void onTestSkipped(ITestResult result) 
	{
	
		Reporter.log("TC "+result.getName()+" is skipped, please have a look", true);
	}

}
