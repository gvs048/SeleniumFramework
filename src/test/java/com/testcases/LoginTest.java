package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;


public class LoginTest extends BaseTest{
	
	@Test
	public void loginTest() throws IOException 
	{		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		
		lp.setPassword(password);
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
		}
		
	}

}
