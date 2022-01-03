package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

Properties prop;
	
	public ReadConfig()
	{
		File src = new File("./configs/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	public String getApplicationURL()
	{
		String url=prop.getProperty("url");
		return url;
	}
	public String getUsername()
	{
	String username=prop.getProperty("username");
	return username;
	}
	
	public String getPassword()
	{
	String password=prop.getProperty("password");
	return password;
	}

	public String getBrowser() {
		String browser=prop.getProperty("browser");
		return browser;
	}
	
	public String getChromeDriverPath() {
		String chromepath=prop.getProperty("chromedriverpath");
		return chromepath;
	}
	
	public String getIEDriverPath() {
		String chromepath=prop.getProperty("iedriverpath");
		return chromepath;
	}
	public String getFFDriverPath() {
		String chromepath=prop.getProperty("ffdriverpath");
		return chromepath;
	}
	public String getTestDataFileName() {
		String testdatafile=prop.getProperty("datafilename");
		return testdatafile;
	}
	public String getTestDataSheetName() {
		String testdatasheet=prop.getProperty("datasheet");
		return testdatasheet;
	}
	
}
