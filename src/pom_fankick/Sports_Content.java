package pom_fankick;

import java.util.List;

import org.openqa.selenium.By;
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

	@FindBy(xpath = "//button[@class='ant-btn ant-btn-primary']")
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
	
	//not used in test class
	@FindBy(xpath = "//input[@placeholder='Match No']")
	@CacheLookup
	WebElement matchnumber;

	public WebElement MatchNumber(String num) {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, matchnumber);
	matchnumber.sendKeys(num);
	return matchnumber;
	}
	
	@FindBy(xpath = "//li[text()='Pakistan']")
	@CacheLookup
	WebElement Team1;

	public void TeamOne() {
		driver.findElement(By.xpath(
				"//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[3]/div/div[1]/div/div[2]/div/div/div/div/div[1]"))
				.click();
		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, Team1);
		Team1.click();
	
	}
	
	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div/div/ul/li[2]")
	@CacheLookup
	WebElement Team2;
	public void TeamTwo() {
		driver.findElement(By.xpath("//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[3]/div/div[3]/div/div[2]/div/div/div/div/div[1]"))
				.click();
		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, Team2);
		Team2.click();
	
	}

	
	
	
	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[4]/div[1]/div/div/div[2]/div/input")
	@CacheLookup
	WebElement contestTitle;

	public void contest(String titl) {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, contestTitle);
		contestTitle.sendKeys(titl);
	
	}
	
	
	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[4]/div[2]/div/div[1]/div/div/div[2]/div/div[1]/div/div")
	@CacheLookup
	WebElement contestDes;

	public void ContentDescription() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, contestDes);
		contestDes.click();
	
	}
	
	@FindBy(xpath = "//input[@placeholder='Description']")
	@CacheLookup
	WebElement contestDesdrop;

	public void ContentDescriptionDrop(String Desx) {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, contestDesdrop);
		contestDesdrop.sendKeys(Desx);
	
	}
	
	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[6]/div/div/div[2]/div/span/div/span/i")
	@CacheLookup
	WebElement image;

	public void SelectImage() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, image);
		image.click();
	
	}
	
	
	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[7]/div[1]/div/div[2]/div/div[1]/div/div")
	@CacheLookup
	WebElement adstype;

	public void AddsType() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, adstype);
		adstype.click();
	
	}
	
	
	@FindBy(xpath = "//li[text()='Canon']")
	@CacheLookup
	WebElement adstypedrop;

	public void AddsTypeDrop() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, adstypedrop);
		adstypedrop.click();
	
	}
	
	@FindBy(xpath = "//input[@placeholder='Rotation Time']")
	@CacheLookup
	WebElement rotationtime;

	public void rotationTimeadd(String adss) {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, rotationtime);
		rotationtime.sendKeys(adss);
	
	}
	@FindBy(xpath = "//div[text()='Country']")
	@CacheLookup
	WebElement country;

	public void CountryIn() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, country);
		country.click();
	
	}
	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[8]/div/div/div[2]/div/div[2]/div/div/div/ul/li[1]")
	@CacheLookup
	WebElement countrydrop;

	public void CountryInDrop() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, countrydrop);
		countrydrop.click();
	
	}
	
	@FindBy(xpath = "//div[text()='Select Location']")
	@CacheLookup
	WebElement location;

	public void SelectLoctaion() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, location);
		location.click();
	
	}
	
	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[9]/div/div/div[2]/div/div[2]/div/div/div/ul/li[1]")
	@CacheLookup
	WebElement locationdrop;

	public void SelectLoctaionDrop() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, locationdrop);
		locationdrop.click();
	
	}
	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[2]/div[1]/div/div[2]/div/span/div[1]/input")

	@CacheLookup
	WebElement Sclcikdate;

	public void DateClick() {
		visibilityOfElement(driver, Sclcikdate);
		Sclcikdate.click();

	}

	public  void PickStartDate1() throws Exception {

		List<WebElement> allDates = driver.findElements(By.xpath(
				"//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/form/div/div[4]/ul/li[1]/div/div[2]/div/span[1]/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr/td"));

		for (WebElement ele : allDates) {

			String date = ele.getText();
			 System.out.println("all dates " + date);

			if (date.equalsIgnoreCase("12")) {
				Thread.sleep(4000);
				ele.click();
				break;
			}
		}
	}
}













