package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {

	public WebDriver driver;
	Logger log;
	@BeforeMethod
	public void openApplication() throws Exception {

		log = LogManager.getLogger(LoginTest.class.getName());

		driver = initializeBroswer();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

	@Test(dataProvider="getLogin")
	public void login(String email,String password, String expectedResult) throws Exception  {

		LandingPage landingpage = new LandingPage(driver);
		landingpage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingpage.loginOptions().click();
		log.debug("Clicked on login option");

		Thread.sleep(4000);

		LoginPage loginpage = new LoginPage(driver);
		loginpage.emailAddress().sendKeys(prop.getProperty("email"));
		log.debug("Email addressed got entered");
		loginpage.passwordField().sendKeys(prop.getProperty("password"));
		log.debug("Password got entered");
		loginpage.loginButton().click();
		log.debug("Clicked on Login button");

		AccountPage accountpage = new AccountPage(driver);
		String acctualResult= null;

		try {

			if(accountpage.editAccount().isDisplayed()) {
				log.debug("User got logged in");
				acctualResult = "Success";
			}
		} catch (Exception e) {
			log.debug("User didnot log in");
			acctualResult = "Failure";
		}
		if(acctualResult.equals(expectedResult)){
			log.debug("Login Test got passed");
		}
		else {
			log.error("Login Test got failed");
		}
	}
	@AfterMethod
	public void close() {
		driver.close();
	}

	@DataProvider
	public Object[][] getLogin() {
		Object[][] data = {{"deependrara@gmail.com","12345deep","Success"},{"deep123@gmail.com","12345","Failure"}};
		return data;

	}


}
