package utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Config_file {
	WebDriver driver;
	File file;
	FileInputStream input;
	Properties prm;
	
	public  void loard() throws Exception   {
		
	file = new File("C:\\Users\\smandhala\\eclipse-workspace\\FanKick\\src\\utility\\properties");
	
	input = new FileInputStream(file);
	
	prm = new Properties();
	
	prm.load(input);
	
	}	
	
	public String getUrl() {
		
		String url = prm.getProperty("URL");
		return url;
	
		
	}
	public String getUser(String prop) {
		
		String cusername = prm.getProperty(prop);
		
		return cusername;
		
		
	}
public String getPassword(String pass) {
	
	String password = prm.getProperty(pass);
	return password;
}

}
