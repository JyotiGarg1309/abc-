package testing.POM;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import jxl.read.biff.BiffException;

public class MailVerify
{
	WebDriver driver;
    Properties pr;
	public MailVerify(WebDriver driver,Properties pr)
		{
			this.driver= driver;
			this.pr =pr;
		}
		
		public void mail_verify() throws InterruptedException, BiffException, IOException
		{
			driver.get(pr.getProperty("url2"));
			   
		    driver.findElement(By.id(pr.getProperty("gemail"))).sendKeys(Excel_Read.output(1, 0));
		    Thread.sleep(3000);
		    Actions act =new Actions(driver);
		    act.sendKeys(Keys.ENTER).perform();
		    
		    Thread.sleep(3000);
		   driver.findElement(By.name(pr.getProperty("gpassword"))).sendKeys(Excel_Read.output(2, 0));
		    act.sendKeys(Keys.ENTER).perform();
			   
		    Thread.sleep(5000);
		List<WebElement> unreademail = driver.findElements(By.xpath(pr.getProperty("mail")));
	    System.out.println(unreademail.size()); 
	    
		String MyMailer = "MastBit";

			for(int i=0;i<unreademail.size();i++){
		    if(unreademail.get(i).isDisplayed()==true){
		        if(unreademail.get(i).getText().equals(MyMailer))
		        {
		            System.out.println("Yes we have got mail form " + MyMailer);
		            unreademail.get(i).click();
		            break;
		        }
		        else
		        {
		            System.out.println("No mail form " + MyMailer);
		            break;
		        }
		    }
		}
		}


		}

	
	
	
	
	
	
	

