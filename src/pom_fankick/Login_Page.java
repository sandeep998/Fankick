package pom_fankick;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Base_Class_fankick;

public class Login_Page extends Base_Class_fankick {

	static WebDriver driver;

	// WebDriverWait wait;

	public Login_Page(WebDriver driver) {

		Login_Page.driver = driver;
		PageFactory.initElements(driver, this);
		// wait=new WebDriverWait(driver, 30);

	}

	@FindBy(xpath = "//input[@name='email']")
	WebElement Fuser;

	public void FuserName(WebDriver driver, String senduser) {
		Fuser.sendKeys(senduser);
	}

	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement Fpassword;

	public void passWord(String sendPassword) {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, Fpassword);
		Fpassword.sendKeys(sendPassword);
	}

	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement Fsubmit;

	public void Submit() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, Fsubmit);
		Fsubmit.click();
	}

}
