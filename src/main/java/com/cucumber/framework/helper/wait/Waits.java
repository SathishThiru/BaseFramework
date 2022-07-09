package com.cucumber.framework.helper.wait;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.utilities.Helper;

public class Waits  {
	
	private Logger oLog = LoggerHelper.getLogger(Waits.class);
	
	public Wait<WebDriver> getWait() {
		oLog.debug("");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(Helper.driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(1, TimeUnit.SECONDS) 			
				.ignoring(Exception.class);
		return wait;
	}
	
	public void waitForElementVisible(WebElement ele) {
		Wait<WebDriver> wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void hardWait(int timeOutInMilliSec) throws InterruptedException {
		Thread.sleep(timeOutInMilliSec);
	}	
}
