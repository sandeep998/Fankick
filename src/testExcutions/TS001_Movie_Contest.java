package testExcutions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import freemarker.log.Logger;
import pom_fankick.Home_Page;
import pom_fankick.Login_Page;
import utility.Base_Class_fankick;
import utility.Config_file;

public class TS001_Movie_Contest extends Base_Class_fankick {

	static WebDriver driver;

	static Config_file cong;

	static Login_Page login;
	static Home_Page home;

	public static ExtentReports reports;
	static ExtentTest logger;

	@BeforeClass

	public void launchBrowser() throws Exception {

		reports = new ExtentReports(
				"C:\\Users\\smandhala\\eclipse-workspace\\FanKick\\src\\reports_screenshots\\Report_Genarate.html",
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

	public static void movieContest() throws Exception {

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

		home = new Home_Page(driver);

		try {
			home.createContest();

			home.ClickContest();
			logger.log(LogStatus.INFO, "Clicked Contest");

			home.ClickMovie();

			logger.log(LogStatus.INFO, "Selected Contest Type");

			home.ContestTitle("sandeep");

			logger.log(LogStatus.INFO, "Entered Contest title");

			Thread.sleep(3000);

			try {
				home.ImageFirst();

				Runtime.getRuntime().exec("C:\\Users\\smandhala\\Videos\\tryit12.exe");

				System.out.println("Image got selected");

				Thread.sleep(5000);

				logger.log(LogStatus.PASS, "Selected Image using AutoIt");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.log(LogStatus.ERROR, "Getting error while selecting the image");
			}

			Thread.sleep(3000);

			home.CSelectType();

			home.ClickDaily();

			logger.log(LogStatus.INFO, "Entered Contest Type Daily");

			home.DateClick();

			home.PickStartDate();

			logger.log(LogStatus.INFO, "Entered Start Date");

			home.GetDate();

			home.EselectDate();

			home.SelectEndDate();

			logger.log(LogStatus.INFO, "Selected End Date");

			home.GetEndDate();

			home.Category();

			home.DropDownCategory();

			logger.log(LogStatus.INFO, "Selected Category");

			home.SubCategory();

			home.DropSubCategory();

			logger.log(LogStatus.INFO, "Selected SubCategory");

			home.Celebrity();

			home.DropDownCelebrity();
			logger.log(LogStatus.INFO, "Selected Celebrity");

			home.FanClub();

			home.DropDownFanClub();

			logger.log(LogStatus.INFO, "Selected FanClub");

			Actions know = new Actions(driver);

			know.sendKeys(Keys.PAGE_DOWN);

			home.Country();

			home.DropDownCountry();

			logger.log(LogStatus.INFO, "Selected Country");

			Thread.sleep(4000);
			// driver.findElement(By.xpath("//html")).click();
			home.SelectLocation();
			home.DropSelectLocation();
			logger.log(LogStatus.INFO, "Selected Location");

			logger.log(LogStatus.PASS, "Entered All the FPL details");

		} catch (Exception e) {
			// TODO Auto-generated catch block

			logger.log(LogStatus.ERROR, "FPL details not working check all ");
			captureScreenshot(driver, "Error Screenshot");
		}

		Thread.sleep(8000);

		// new

		WebElement tagg = driver.findElement(By.cssSelector(".CreatesocialpostsTagWords12"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", tagg);
		tagg.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.cssSelector(".ant-input-sm")).sendKeys("something");
		
	//	driver.findElement(By.xpath("//*[@id='tags']/div")).sendKeys("test by sandeep");

		logger.log(LogStatus.INFO, "Clicked tagvalue");
		Thread.sleep(10000);

		/*
		 * List<WebElement> addd = driver.findElements(By.xpath(
		 * "//*[@id='root']/div/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div/div/div[2]/div/div/div[2]/div[1]/form/div/div[8]/div/div/div[2]/div/div[1]/div"
		 * )); addd.get(0).sendKeys("Test1");
		 */

		/*
		 * JavascriptExecutor js1 = (JavascriptExecutor) driver;
		 * js1.executeScript("arguments[0].value='Testdata'", tagvalue);
		 */

		// home.TagValue("anything");

		/*
		 * List<WebElement> list= driver.findElements(By.id("tags"));
		 * 
		 * list.get(0).sendKeys("Test Again");
		 */

		home.ClickAdd();

		home.CreateFPLButton();

		System.out.println("Entered all the elements ");
	}

	@AfterTest
	public static void tearDown() {
		reports.flush();
		reports.endTest(logger);

		logger.log(LogStatus.INFO, "App Ready to Close ");
		//driver.quit();

	}

}
