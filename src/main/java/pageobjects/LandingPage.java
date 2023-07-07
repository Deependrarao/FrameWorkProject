package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    WebDriver driver;
    
    public LandingPage(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    @FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
   private WebElement myAccountDropdown;
    
    @FindBy(linkText="Login")
   private WebElement loginOptions;
    
    public WebElement myAccountDropdown() {
    	return myAccountDropdown;
    }
    
    public WebElement loginOptions() {
    	return loginOptions;
    }
}
