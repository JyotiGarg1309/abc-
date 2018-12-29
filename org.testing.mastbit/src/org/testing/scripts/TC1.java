package org.testing.scripts;

import java.io.IOException;

import org.testing.base.Base_Mastbit;

import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import testing.POM.MailVerify;
import testing.POM.Register_Mastbit;

public class TC1 extends Base_Mastbit {
	
	@Test()
	public void test1() throws InterruptedException, IOException, BiffException
	{
		Thread.sleep(5000);
		Register_Mastbit reg =new Register_Mastbit(driver ,pr);
		
	     reg.register();
	     Thread.sleep(5000);
	     
	     MailVerify mailvfy =new MailVerify(driver,pr);
	     mailvfy.mail_verify();
	   
	}
		
	
	

}
