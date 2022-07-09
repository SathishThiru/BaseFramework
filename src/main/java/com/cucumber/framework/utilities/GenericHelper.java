package com.cucumber.framework.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.cucumber.framework.helper.Logger.LoggerHelper;

public class GenericHelper   {

//	private WebDriver driver;
//	private Logger oLog = LoggerHelper.getLogger(GenericHelper.class);
//
//	public GenericHelper(WebDriver driver) {
//		this.driver = driver;
//		oLog.debug("GenericHelper : " + this.driver.hashCode());
//	}
//
//	public WebElement getElement(By locator) {
//		oLog.info(locator);
//		if (IsElementPresentQuick(locator))
//			return driver.findElement(locator);
//		
//		try {
//			throw new NoSuchElementException("Element Not Found : " + locator);
//		} catch (RuntimeException re) {
//			oLog.error(re);
//			throw re;
//		}
//	}
//	
//	public WebElement getElementWithNull(By locator) {
//		oLog.info(locator);
//		try {
//			return driver.findElement(locator);
//		} catch (NoSuchElementException e) {
//			// Ignore
//		}
//		return null;
//	}
//
//	public boolean IsElementPresentQuick(By locator) {
//		boolean flag = driver.findElements(locator).size() >= 1;
//		oLog.info(flag);
//		return flag;
//	}
//
//	
//
//	public String takeScreenShot() {
//		oLog.info("");
//		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
//	}

}
