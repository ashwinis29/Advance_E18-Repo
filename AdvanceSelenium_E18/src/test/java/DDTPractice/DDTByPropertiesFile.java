package DDTPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DDTByPropertiesFile {
	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\hp\\eclipse-workspace\\AdvanceSelenium_E18\\src\\test\\resources\\CommonData_E18.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("url");
		String un = prop.getProperty("uname");
		String pwd = prop.getProperty("pwd");
		System.out.println(browser);
		System.out.println(url);
		System.out.println(un);
		System.out.println(pwd);
	}
}
