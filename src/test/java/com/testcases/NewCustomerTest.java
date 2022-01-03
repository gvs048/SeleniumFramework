package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pageObjects.LoginPage;
import com.pageObjects.NewCustomerPage;
import com.utilities.FramesHandling;
import com.utilities.ReadConfig;
import com.utilities.XLUtils;

public class NewCustomerTest extends BaseTest {

	@Test
	public void addNewCustomer() throws IOException, InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		lp.clickSubmit();

		//Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}

		ReadConfig config=new ReadConfig();
		NewCustomerPage addcust = new NewCustomerPage(driver);
		addcust.clickAddNewCustomer();
		FramesHandling hframe = new FramesHandling(driver);

		hframe.switchToFrameWebElement(addcust.googleAdsIframe());
		try {
			addcust.clickAdClose();
		} catch (Exception ex) {
			hframe.switchToFrameByID("ad_iframe");
			addcust.clickAdClose();
		}
		finally {
			hframe.switchBackToPage();
		}
/*		
		addcust.custName("usertest");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		//Thread.sleep(5000);
		addcust.custaddress("INDIA,AP,123");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");

		String email = randomestring() + "@gmail.com";
		addcust.custemailid(email);
		//addcust.custpassword("abcdef");
		addcust.custsubmit();
*/
		addcust.custName(XLUtils.getCellData(config.getTestDataFileName(), config.getTestDataSheetName(), 0, 1));
		addcust.custgender(XLUtils.getCellData(config.getTestDataFileName(), config.getTestDataSheetName(), 1, 1));
		String dob=XLUtils.getCellData(config.getTestDataFileName(), config.getTestDataSheetName(), 2, 1);
		String[] items=dob.split("/");
		addcust.custdob(items[0].toString(),items[1].toString(),items[2].toString());
		//addcust.custName(XLUtils.getCellData(config.getTestDataFileName(), config.getTestDataSheetName(), 2, 1));
		addcust.custaddress(XLUtils.getCellData(config.getTestDataFileName(), config.getTestDataSheetName(), 3, 1));
		addcust.custcity(XLUtils.getCellData(config.getTestDataFileName(), config.getTestDataSheetName(), 4, 1));
		addcust.custstate(XLUtils.getCellData(config.getTestDataFileName(), config.getTestDataSheetName(), 5, 1));
		addcust.custpinno(XLUtils.getCellData(config.getTestDataFileName(), config.getTestDataSheetName(), 6, 1));
		addcust.custtelephoneno(XLUtils.getCellData(config.getTestDataFileName(), config.getTestDataSheetName(), 7, 1));
		String email = randomestring() + XLUtils.getCellData(config.getTestDataFileName(), config.getTestDataSheetName(), 8, 1);
		addcust.custemailid(email);
		addcust.custsubmit();

		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);

		} else {
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}

	}

}
