package neoStoxBase1;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxPOMClassForBaseNutility.Utility1;



public class Base1 
{
	 protected static WebDriver driver;
	
	public void launchBrowser() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\F-1\\Desktop\\Testing\\Automation\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get(Utility1.readDataFromPropertyFile("url"));
		
		Utility1.implicitWait(1000, driver);
		
		Reporter.log("Launching Browser", true);
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
}
