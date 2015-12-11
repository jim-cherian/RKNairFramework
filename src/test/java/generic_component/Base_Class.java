package generic_component;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.asserts.SoftAssert;


public class Base_Class {
	
	public WebDriver driver= null;
	public SoftAssert assert1 = new SoftAssert();
	 
	
	
	public void Intialize_browser() throws Exception
	{
		String browser_type = get_properties_file("Browser");
		if(browser_type.equalsIgnoreCase("Firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browser_type.equalsIgnoreCase("Internet Explorer"))
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\src\\test\\resource\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser_type.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resource\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(get_properties_file("URL"));
	}
	
	public void tear_down()
	{
		driver.quit();
	}
	
	public void get_screenshot(String TC_ID,String Order) throws Exception
	{
		Date date = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		TakesScreenshot snapshot = (TakesScreenshot)driver;
		File screenshotAs = snapshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("D:\\snapshot\\"+TC_ID+"-"+Order+"-"+dateformat.format(date)+".png"));
		
	}
	
	
	public  String get_properties_file(String key) throws Exception
	{	
		
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Configuration_file.properties");
		
		FileInputStream fis = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(key);		
	}
	

}
