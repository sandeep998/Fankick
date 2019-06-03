package pom_fankick;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Base_Class_fankick;

public class Sports_Content extends Base_Class_fankick{
	
	static WebDriver driver;
	public Sports_Content(WebDriver driver) {

		Sports_Content.driver = driver;
		PageFactory.initElements(driver, this);
		// wait=new WebDriverWait(driver, 30);

	}

	@FindBy(xpath = "//button[@type='button'][@class='ant-btn ant-btn-primary']")
	@CacheLookup
	WebElement Fcreatecontest;

	public void createContest() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, Fcreatecontest);
		Fcreatecontest.click();
	}

	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[1]/div[1]/div/div[2]/div/div[1]")
	@CacheLookup
	WebElement fcontesttype;

	public void ClickContest() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, fcontesttype);
		fcontesttype.click();
	}
	
	@FindBy(xpath = "//li[text()='Sports Contest']")
	@CacheLookup
	WebElement sports;

	public void ClickSports() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, sports);
		sports.click();
	}

	
	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[1]/div[2]/div/div/div[2]/div/div/div/div/div[1]")
	@CacheLookup
	WebElement ccategory;

	public void ContestCategory() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, ccategory);
		ccategory.click();
	}
	
	@FindBy(xpath = "//li[text()='Cricket']")
	@CacheLookup
	WebElement dropccategory;

	public void DropContestCategory() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, dropccategory);
		dropccategory.click();
	}

	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/div/div/div/div[1]")
	@CacheLookup
	WebElement series;

	public void SeriesW() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, series);
		series.click();
	}
	@FindBy(xpath = "//li[text()='World Cup']")
	@CacheLookup
	WebElement dropseries;

	public void DropSeriesW() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, dropseries);
		dropseries.click();
	}
	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[1]/div[3]/div/div/div[2]/div/div/div/div/div[1]")
	@CacheLookup
	WebElement subcontest;

	public void SubContest1() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, subcontest);
		subcontest.click();
	}
	
	@FindBy(xpath = "//li[text()='Innings 1']")
	@CacheLookup
	WebElement dropsubcontest;

	public void DropSubContest() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, dropsubcontest);
		dropsubcontest.click();
	}
	
	@FindBy(xpath = "//input[@placeholder='Match No']")
	@CacheLookup
	WebElement matchnumber;

	public WebElement MatchNumber(String num) {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, matchnumber);
	matchnumber.sendKeys(num);
	return matchnumber;
	}
}

