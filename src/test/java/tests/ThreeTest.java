package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base {
	public WebDriver driver;
	@Test
	public void threeTest() throws Exception {
		System.out.println("=====execute three test=========");
	driver = initializeBroswer();
		driver.get("http://tutorialsninja.com/demo/");
		
		Thread.sleep(3000);
		driver.close();
	}

}
