package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base {
	public WebDriver driver;

	@Test
	public void fourTest() throws Exception {
		System.out.println("======execute four test=======");
		driver = initializeBroswer();
		driver.get("http://tutorialsninja.com/demo/");

		Assert.assertTrue(true);	
	}

	@AfterMethod
	public void closingBrowser() {
		driver.close();
	}
}
