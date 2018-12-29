package testing.POM;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import jxl.read.biff.BiffException;

public class Register_Mastbit 
	
		   {	
		WebDriver driver;
	    Properties pr;
		public Register_Mastbit(WebDriver driver,Properties pr)
			{
				this.driver= driver;
				this.pr =pr;
			}
			
			public void register() throws InterruptedException, BiffException, IOException
			{
			List<WebElement> all =	driver.findElements( By.xpath(pr.getProperty("register")));
			all.get(0).click();
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			    	
		     driver.findElement(By.name(pr.getProperty("fullname"))).sendKeys(Excel_Read.output(0, 0));
		     Thread.sleep(3000);
		     List<WebElement> email = driver.findElements(By.xpath(pr.getProperty("email")));
		       email.get(1).sendKeys(Excel_Read.output(1, 1));
		     
		     driver.findElement(By.name(pr.getProperty("password"))).sendKeys(Excel_Read.output(1, 0));
		    driver.findElement(By.name(pr.getProperty("conpassword"))).sendKeys(Excel_Read.output(1, 0));
		     Thread.sleep(3000);
		     driver.findElement(By.xpath(pr.getProperty("chkbox"))).click();
		    
				
			}

	
	
	
	
	
	
	

}
