package com.cucumber.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.cucumber.framework.exception.AutomationException;
import com.cucumber.framework.helper.Logger.LoggerHelper;

public class Helper{

	public static WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(Helper.class);
	public static String separator=System.getProperty("file.separator");

	public void switchTab(int nthTab) throws AutomationException {

		LinkedList<String> allWindowIds = new LinkedList<String>(driver.getWindowHandles());
		int toalUniqueWindowsOpen=allWindowIds.size();
		if (nthTab < 0 )
			throw new AutomationException("You are trying to switch to invalid window. The window nthTab can't be  0 ");
		else if (nthTab >toalUniqueWindowsOpen )
			throw new AutomationException("You are trying to switch to "+nthTab+" tab. But there are only "+toalUniqueWindowsOpen+" unique tabs open");

		driver.switchTo().window(allWindowIds.get(nthTab-1));
	}

	public void switchToParentWindow() {
		LinkedList<String> allWindowIds = new LinkedList<String>(driver.getWindowHandles());
		driver.switchTo().window(allWindowIds.get(0));
	}

	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void switchToFrame(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void selectUsingVisibleValue(WebElement ddnEle, String visibleValue) 
	{
		Select select = new Select(ddnEle);
		select.selectByVisibleText(visibleValue);
	}


	public void selectUsingIndex(WebElement ddnEle,int index) 
	{
		Select select = new Select(ddnEle);
		select.selectByIndex(index);
	}


	public List<String> getAllDropDownValues(WebElement ddnEle) 
	{
		Select select = new Select(ddnEle);
		List<WebElement> allDropdownElements = select.getOptions();
		List<String> allDdnValueList = new LinkedList<String>();

		for (WebElement eachEle : allDropdownElements) {
			allDdnValueList.add(eachEle.getText());
		}
		return allDdnValueList;
	}
	public Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		return exe.executeScript(script);
	}

	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		oLog.info(script);
		return exe.executeScript(script, args);
	}

	public void scrollToElement(WebElement element)
	{
		executeScript("arguments[0].scrollIntoView(true);", element);
	}	

	public void clickUsingJS(WebElement element)
	{
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		exe.executeScript("arguments[0].click();", element);
	}

	public void higlightElement(WebElement element)
	{
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		System.out.println(driver);
		exe.executeScript("arguments[0].setAttribute('style', 'background: white; border: 2px solid red;');", element);
	}

	public void fillText(WebElement element,String value) {
		element.sendKeys(value);
	}

	public void clearAndFillText(WebElement element,String value) {
		element.clear();
		element.sendKeys(value);
	}

	public static String takeScreenShot(String name) throws IOException {
		File destDir = new File(Paths.screenshotDirPath+separator+"LastRun");
		if (!destDir.exists())
			destDir.mkdir();

		File destPath = new File(destDir.getAbsolutePath()
				+ separator+ name + ".jpg");
		if(destPath.exists())
		{
			new Helper().oLog.warn("The screenshot folder already contains a file named '"+name+"'. Replacing the existing file with new file...");
		}
		try {
			FileUtils
			.copyFile(((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE), destPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destPath.getAbsolutePath();
	}

	public static String takeScreenShotWithTimestamp(String name) throws IOException {
		File destDir = new File(Paths.screenshotDirPath+separator+"LastRun");
		if (!destDir.exists())
			destDir.mkdir();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
		File destPath = new File(destDir.getAbsolutePath()
				+ separator+ name +"_"+ sdf.format(d)+".jpg");
		if(destPath.exists())
		{
			new Helper().oLog.warn("The screenshot folder already contains a file named '"+name+"'. Replacing the existing file with new file...");
		}
		try {
			FileUtils
			.copyFile(((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE), destPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destPath.getAbsolutePath();
	}
}
