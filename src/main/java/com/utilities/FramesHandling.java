package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FramesHandling {
	private WebDriver driver;
	
	public FramesHandling(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchToFrameByID(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	public void switchToFrameIndex(int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrameWebElement(WebElement ele) {
		driver.switchTo().frame(ele);
	}
	public void switchBackToPage() {
		driver.switchTo().defaultContent();
	}
	
}
