package listener;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class MyTesting2 
{
@Test
public void P()
{
Reporter.log("TC P is running", true);
}
@Test
public void Q()
{
Assert.fail();
Reporter.log("TC Q is running", true);
}
@Test(dependsOnMethods = "Q")
public void R()
{
Reporter.log("TC R is running", true);
}
}
