package testExcutions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
				"C:\\Users\\smandhala\\eclipse-workspace\\FanKick\\src\\reports_screenshots\\Report_Sports.html",
				true);
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
					.findElement(By.xpath("//*[@id='leftMenuView']/div/div/div[2]/div[1]/div/ul/li[11]"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", Availability);
			Availability.click();

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
		
	WebElement str=	worldcup.MatchNumber("12134");
	
	String matchnumber1=str.getAttribute("value");
	
	System.out.println("match number  "+matchnumber1);
	
	
	WebElement tagg1 = driver.findElement(By.xpath("//div[text()='Select Location']"));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", tagg1);
	
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
	
	@AfterTest
	public static void tearDown() {
		reports.flush();
		reports.endTest(logger);

		logger.log(LogStatus.INFO, "App Ready to Close ");
		//driver.quit();

	}
}