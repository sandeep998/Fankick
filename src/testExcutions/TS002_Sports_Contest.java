
package testExcutions;

import java.awt.Desktop.Action;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pom_fankick.Login_Page;
import pom_fankick.Sports_Content;
import utility.Base_Class_fankick;
import utility.Config_file;

public class TS002_Sports_Contest extends Base_Class_fankick {

	static WebDriver driver;

	static Config_file cong;

	static Login_Page login;
	static Sports_Content worldcup;

	public static ExtentReports reports;
	static ExtentTest logger;

	@BeforeClass

	public void launchBrowser() throws Exception {

		reports = new ExtentReports(
				"C:\\Users\\smandhala\\eclipse-workspace\\FanKick\\src\\reports_screenshots\\Report_Sports.html", true);
		logger = reports.startTest("verify test");

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\smandhala\\Documents\\new_all_jars\\chromedriver.exe");

		driver = new ChromeDriver();

		try {
			driver.get("http://qaweb.fankick.io/");
			driver.manage().window().maximize();

			logger.log(LogStatus.INFO, "Opened Browser Successfully");

			Thread.sleep(3000);
		} catch (Exception e) {

			captureScreenshot(driver, "Getting Error in Login Page");

			logger.log(LogStatus.ERROR, e.getLocalizedMessage() + "Not able to open Browser");

		}
	}

	// Login Test Case
	public static void testcaseLogin() throws Exception {

		try {
			login = new Login_Page(driver);

			cong = new Config_file();

			cong.loard();

			Thread.sleep(5000);

			login.FuserName(driver, cong.getUser("username"));

			// login.FuserName(driver, "admin@fankick.io");

			login.passWord(cong.getPassword("password"));

			login.Submit();

			logger.log(LogStatus.PASS, "login successfull ");

		} catch (Exception e) {
			// TODO Auto-generated catch block

			captureScreenshot(driver, "Getting error in home page");

			logger.log(LogStatus.FAIL, "Not able to login");

		}

		try {

			String titleCheck = driver.getTitle();

			System.out.println("title" + titleCheck);

			Assert.assertEquals("FanKick", titleCheck);

			System.out.println("login success");

			logger.log(LogStatus.INFO, "Home page title is matching with expected title");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, "Actual And Expected Titles are not Matching");

			captureScreenshot(driver, "Getting error in home page");
		}

	}

	@Test
	public static void sportsContest() throws Exception {

		testcaseLogin();

		// scrrol FPL Contest

		try {
			Actions action = new Actions(driver);

			Thread.sleep(3000);

			WebElement movetochallenge = driver
					.findElement(By.xpath("//*[@id='leftMenuView']/div/div/div[2]/div[1]/div/ul/li[1]/i"));

			action.moveToElement(movetochallenge).build().perform();
			Thread.sleep(3000);
			System.out.println("moved to challenge elemnet");

			Thread.sleep(3000);

			WebElement Availability = driver
					.findElement(By.xpath("//*[@id='leftMenuView']/div/div/div[2]/div[1]/div/ul/li[10]/i"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", Availability);

			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@id='leftMenuView']/div/div/div[2]/div[1]/div/ul/li[10]")).click();

			Thread.sleep(3000);
			logger.log(LogStatus.INFO, "Scrooled to FPL contest and clicked FPL");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.log(LogStatus.FAIL, "Scrool not working");

			captureScreenshot(driver, "Error");
		}

		worldcup = new Sports_Content(driver);

		worldcup.createContest();

		worldcup.ClickContest();

		logger.log(LogStatus.INFO, "Clicked Contest");

		worldcup.ClickSports();

		worldcup.ContestCategory();
		worldcup.DropContestCategory();

		worldcup.SeriesW();

		worldcup.DropSeriesW();

		worldcup.SubContest1();
		worldcup.DropSubContest();

///Match Number Random

		Random randomGenerator = new Random();

		int randomInt = randomGenerator.nextInt(1000);

		WebElement matchnumber = driver.findElement(By.xpath("//input[@placeholder='Match No']"));

		matchnumber.sendKeys(" " + randomInt);

		String matchnumber1 = matchnumber.getAttribute("value");

		System.out.println("match number  " + matchnumber1);

		driver.findElement(By.xpath(
				"//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[2]/div[1]/div/div[2]/div/span/div[1]/input"))
				.click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(
				"//*[@id=\"root\"]/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[2]/div[1]/div/div[2]/div/span/div[2]/div/div/div/div/div[2]/div[3]/span/a[1]"))
				.click();

		driver.findElement(By.xpath(
				"//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[2]/div[2]/div/div[2]/div/span/div/input"))
				.click();

		driver.findElement(By.xpath(
				"//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[2]/div[2]/div/div[2]/div/span/div[2]/div/div/div/div/div[1]/div/input"))
				.sendKeys("2019-06-13 22:30:15");

		driver.findElement(By.xpath(
				"//a[text()='Ok']"))
				.click();

		// datesHandle();
		// finaDates();

		/*
		 * worldcup.DateClick();
		 * 
		 * worldcup.PickStartDate1();
		 */

		worldcup.TeamOne();

		worldcup.TeamTwo();

		WebElement titlec = driver.findElement(By.xpath(
				"//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div[2]/div[1]/form/div/div[4]/div[1]/div/div/div[2]/div/input"));
		JavascriptExecutor jsweek = (JavascriptExecutor) driver;
		jsweek.executeScript("arguments[0].scrollIntoView(true);", titlec);

		titlec.sendKeys("No title");

		// worldcup.contest("sandeep");

		// worldcup.ContentDescription();

		worldcup.ContentDescriptionDrop("new content");

		Thread.sleep(5000);

		worldcup.SelectImage();

		Runtime.getRuntime().exec("C:\\Users\\smandhala\\Videos\\tryit12.exe");

		worldcup.AddsType();

		worldcup.AddsTypeDrop();
		worldcup.rotationTimeadd("77");

		worldcup.CountryIn();

		worldcup.CountryInDrop();

		worldcup.SelectLoctaion();

		worldcup.SelectLoctaionDrop();

		/*
		 * WebElement tagg1 =
		 * driver.findElement(By.xpath("//div[text()='Select Location']"));
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].scrollIntoView(true);", tagg1);
		 */

		AddTagValues();

	}

	@AfterTest
	public static void tearDown() {
		reports.flush();
		reports.endTest(logger);

		logger.log(LogStatus.INFO, "App Ready to Close ");
		// driver.quit();

	}

	public static void AddTagValues() throws Exception {

		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".ant-col-20 .ant-tag")).click();
		driver.findElement(By.cssSelector(".ant-input-sm")).sendKeys("jhkvfshjcdhjvchjvx");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".ant-col-24:nth-child(11) .ant-tag")).click();
		driver.findElement(By.cssSelector(".ant-input-sm")).sendKeys("bdfgdfjgjdfjkgdjkf");

		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".ant-col-24 > .ant-row .CreatesocialpostsTypeTagWords > .ant-tag")).click();
		driver.findElement(By.cssSelector(".ant-col-24:nth-child(12) .ant-input")).sendKeys("hjkfdghjdfhjgjhdf");

		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".ant-col-24:nth-child(12)")).click();
		Thread.sleep(4000);
	}

	
	// dates 
	

}
