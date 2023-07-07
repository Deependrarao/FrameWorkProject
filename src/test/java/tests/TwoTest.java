package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class TwoTest extends Base {
	public WebDriver driver;
	@Test
	public void testTwo() throws Exception {
		System.out.println("======execute two test========");
		WebDriver driver = initializeBroswer();
		driver.get("http://tutorialsninja.com/demo/");
		
		Thread.sleep(3000);
		driver.close();
	}
}
