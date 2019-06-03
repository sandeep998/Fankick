package testExcutions;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom_fankick.Login_Page;
import utility.Base_Class_fankick;
import utility.Config_file;

public class Check_Main extends Base_Class_fankick {
	
	static WebDriver driver;
	
	static Config_file cong;
	
	static Login_Page login;

	public static void main(String[] args) throws Exception {
		
		
		// TODO Auto-generated method stub
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\\\smandhala\\Documents\\new_all_jars\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get("http://qaweb.fankick.io/");
		driver.manage().window().maximize();
		
	login = new Login_Page(driver);
		
		cong=new Config_file();
		
		cong.loard();
		
		Thread.sleep(2000);
		
		login.FuserName(driver,cong.getUser("username"));
		
		//driver.findElement(By.xpath("//input[@name='email']")).sendKeys("admin@fankick.io");
		
		//login.FuserName(driver, "admin@fankick.io");
		
		login.passWord(cong.getPassword("password"));
		
		login.Submit();
		
	}

}
