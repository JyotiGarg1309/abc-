package org.testing.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Base_Mastbit {
	public WebDriver driver;
	public Properties pr;
	
	@BeforeMethod
	@Parameters({"browser"})
   public void setup(String browser) throws IOException 
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tamanna Sharma\\Desktop\\chromedriver.exe");
		
		//driver =new ChromeDriver();
		
	if(browser.equalsIgnoreCase("firefox"))
	{
		driver =new FirefoxDriver();
	}
		
	else if(browser.equalsIgnoreCase("chrome"))
		{
		
		
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tamanna Sharma\\Desktop\\chromedriver.exe");
			
	driver =new ChromeDriver();
		}
	else if(browser.equalsIgnoreCase("ie"))
	
	{
    System.setProperty("webdriver.ie.driver", "C:\\Users\\Tamanna Sharma\\Desktop\\IEDriverServer.exe");
		
    driver =new InternetExplorerDriver();
	}

	
	else
		System.out.println("Browser is not correct");
	
	
	File f =new File("C:\\Users\\Tamanna Sharma\\Desktop\\Jyoti QA\\org.testing.mastbit\\OR.properties");
	FileInputStream fis =new FileInputStream(f);
    pr =new Properties();
	pr.load(fis);
	
	driver.get(pr.getProperty("url"));
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
	
}
@AfterMethod
public void teatdown()
{
	driver.close();
}

	
	
	
	
	
	

}
