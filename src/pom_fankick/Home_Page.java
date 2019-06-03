package pom_fankick;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Base_Class_fankick;

public class Home_Page extends Base_Class_fankick {

	static WebDriver driver;

	// WebDriverWait wait;

	public Home_Page(WebDriver driver) {

		Home_Page.driver = driver;
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

	@FindBy(xpath = "//div[text()='Select Category']")
	@CacheLookup
	WebElement fcontesttype;

	public void ClickContest() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, fcontesttype);
		fcontesttype.click();
	}

	@FindBy(xpath = "//li[text()='Movie Contest']")
	@CacheLookup
	WebElement fmoviecontest;

	public void ClickMovie() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, fmoviecontest);
		fmoviecontest.click();
	}

	@FindBy(xpath = "//input[@placeholder='Enter Title']")
	@CacheLookup
	WebElement fcontestTitl;

	public void ContestTitle(String name) {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, fcontestTitl);
		fcontestTitl.sendKeys(name);
	}

	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/form/div/div[2]/ul/li[1]/div/div[2]/div/div/span/div/span/i")
	@CacheLookup
	WebElement imageone;

	public void ImageFirst() throws Exception {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, imageone);
		
		Thread.sleep(2000);
		imageone.click();
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/form/div/div[2]/ul/li[2]/div/div[2]/div/div/span/div/span/i")
	@CacheLookup
	WebElement imagetwo;

	public void ImageSecond(String name1) {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, imageone);
		imageone.sendKeys(name1);
	}

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/form/div/div[2]/ul/li[3]/div/div[2]/div/div/span/div/span/i")
	@CacheLookup
	WebElement imagethree;

	public void ImageThird(String name2) {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, imageone);
		imageone.sendKeys(name2);
	}

	// not use in testng
	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/form/div/div[3]/div/div[2]/div/div/div/div/div[1]")
	@CacheLookup
	WebElement contestselectype;

	public void CSelectType() {

		// wait.until(ExpectedConditions.presenceOfElementLocated((By) Tuser));
		visibilityOfElement(driver, contestselectype);
		contestselectype.click();
	}

	@FindBy(xpath = "//li[text()='Daily']")

	@CacheLookup
	WebElement contestdaily;

	public void ClickDaily() {
		visibilityOfElement(driver, contestdaily);
		contestdaily.click();

	}

	@FindBy(xpath = "//input[@placeholder='Select Start Date']")

	@CacheLookup
	WebElement Sclcikdate;

	public void DateClick() {
		visibilityOfElement(driver, Sclcikdate);
		Sclcikdate.click();

	}

	public static void PickStartDate() throws Exception {

		List<WebElement> allDates = driver.findElements(By.xpath(
				"//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/form/div/div[4]/ul/li[1]/div/div[2]/div/span[1]/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr/td"));

		for (WebElement ele : allDates) {

			String date = ele.getText();
			// System.out.println("all dates " + date);

			if (date.equalsIgnoreCase("31")) {
				Thread.sleep(4000);
				ele.click();
				break;
			}
		}
	}

	public void GetDate() {

		WebElement dateee = driver.findElement(By.xpath("//input[@placeholder='Select Start Date']"));

		String get = dateee.getAttribute("value");

		System.out.println("date value    " + get);
	}

	@FindBy(xpath = "//input[@placeholder='Select End Date']")

	@CacheLookup
	WebElement Eclcikdate;

	public void EselectDate() {
		visibilityOfElement(driver, Eclcikdate);
		Eclcikdate.click();

	}

	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/form/div/div[4]/ul/li[2]/div/div[2]/div/span[1]/div[2]/div/div/div/div/div[2]/div[2]/table/tbody/tr[6]/td[4]/div")

	@CacheLookup
	WebElement clickenddate;

	public void SelectEndDate() {
		visibilityOfElement(driver, clickenddate);
		clickenddate.click();

	}

	public void GetEndDate() {

		WebElement dateeeEnd = driver.findElement(By.xpath("//input[@placeholder='Select End Date']"));

		String getend = dateeeEnd.getAttribute("value");

		System.out.println("date value    " + getend);
	}

	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/form/div/div[5]/ul/li[1]/div/div[2]/div/div[1]/div/div/div")

	@CacheLookup
	WebElement cat;

	public void Category() {
		visibilityOfElement(driver, cat);
		cat.click();

	}

	@FindBy(xpath = "//li[text()='Movies']")

	@CacheLookup
	WebElement dcat;

	public void DropDownCategory() {
		visibilityOfElement(driver, dcat);
		dcat.click();

	}

	@FindBy(xpath = "//div[text()='Select SubCategory']")

	@CacheLookup
	WebElement subcat;

	public void SubCategory() {
		visibilityOfElement(driver, subcat);
		subcat.click();

	}

	@FindBy(xpath = "//li[text()='Tollywood']")

	@CacheLookup
	WebElement dropsubcat;

	public void DropSubCategory() {
		visibilityOfElement(driver, dropsubcat);
		dropsubcat.click();

	}

	@FindBy(xpath = "//div[text()='Select Celebrity']")

	@CacheLookup
	WebElement celabre;

	public void Celebrity() {
		visibilityOfElement(driver, celabre);
		celabre.click();

	}

	@FindBy(xpath = "//li[text()='Mahesh Babu']")

	@CacheLookup
	WebElement dropcelabre;

	public void DropDownCelebrity() {
		visibilityOfElement(driver, dropcelabre);
		dropcelabre.click();

	}

	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/form/div/div[5]/ul/li[4]/div/div[2]/div/div/div/div/div[1]")

	@CacheLookup
	WebElement fanc;

	public void FanClub() {
		visibilityOfElement(driver, fanc);
		fanc.click();

	}

	@FindBy(xpath = "//li[text()='Mahesh Babu Fans Club']")

	@CacheLookup
	WebElement fandropdown;

	public void DropDownFanClub() {
		visibilityOfElement(driver, fandropdown);
		fandropdown.click();

	}

	@FindBy(xpath = "//div[text()='Country']")

	@CacheLookup
	WebElement countr;

	public void Country() {
		visibilityOfElement(driver, countr);
		countr.click();

	}

	@FindBy(xpath = "//li[text()='India']")

	@CacheLookup
	WebElement dropcountr;

	public void DropDownCountry() {
		visibilityOfElement(driver, dropcountr);
		dropcountr.click();

	}

	@FindBy(xpath = "//div[text()='Select Location']")

	@CacheLookup
	WebElement location;

	public void SelectLocation() {
		visibilityOfElement(driver, location);
		location.click();

	}

	@FindBy(xpath = "//li[text()='Telangana']")

	@CacheLookup
	WebElement sendlocation;

	public void DropSelectLocation() {
		visibilityOfElement(driver, sendlocation);
		sendlocation.click();

	}

	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/form/div/div[8]/div/div/div[2]/div/div[1]/div")

	@CacheLookup
	WebElement tag;

	public void TagValue(String data) {
		visibilityOfElement(driver, tag);
		tag.sendKeys(data);

	}

	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/form/div/div[8]/div/div/div[2]/div/div[1]/button")

	@CacheLookup
	WebElement add;

	public void ClickAdd() {
		visibilityOfElement(driver, add);
		add.click();

	}

	@FindBy(xpath = "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/form/div/div[9]/div/button")
	@CacheLookup
	WebElement create;

	public void CreateFPLButton() {
		visibilityOfElement(driver, create);
		create.click();

	}
}
