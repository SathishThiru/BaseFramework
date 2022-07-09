package com.cucumber.framework.initializer;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.cucumber.framework.configuration.browser.BrowserHandler;
import com.cucumber.framework.configuration.browser.BrowserType;
import com.cucumber.framework.exception.AutomationException;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.readers.ConfigReader;
import com.cucumber.framework.repo.ObjectRepo;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Initializer {

	private Logger oLog = LoggerHelper.getLogger(Initializer.class);

	public Initializer(ConfigReader reader) {
		ObjectRepo.reader = reader;
	}

	public static WebDriver standAloneStepUp(BrowserType bType) throws Exception {
		try {
			switch (bType) {

			case Chrome:
				BrowserHandler chrome = BrowserHandler.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeCapabilities());

			case Firefox:
				BrowserHandler firefox = BrowserHandler.class.newInstance();

				return firefox.getFirefoxDriver(firefox
						.getFirefoxCapabilities());

			case Iexplorer:
				BrowserHandler internetExplorer = BrowserHandler.class.newInstance();
				return internetExplorer.getIExplorerDriver(internetExplorer
						.getIExplorerCapabilities());
			case HeadlessChrome:
				BrowserHandler headlessChrome = BrowserHandler.class.newInstance();
				return headlessChrome.getHeadlessChromeDriver(headlessChrome
						.getHeadlessChromeCapabilities());
			default:
				throw new AutomationException(" Driver Not Found : "
						+ ObjectRepo.reader.getBrowser());
			}
		} catch (Exception e) {
			throw e;
		}
	}


	@Before()
	public void before(Scenario scenario) throws Exception 
	{
		oLog.info("Scenario '"+scenario.getName()+"' execution started...");
			setUpDriver(ObjectRepo.reader.getBrowser());
	}

	@After({"~@firefox","~@chrome","~@phantomjs","~@iexplorer"})
	public void after(Scenario scenario) throws Exception {
		tearDownDriver(scenario);
		oLog.info("");
	}


	public static void setUpDriver(BrowserType bType) throws Exception {
		ObjectRepo.driver = standAloneStepUp(bType);
		ObjectRepo.driver
		.manage()
		.timeouts()
		.pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(),
				TimeUnit.SECONDS);
		ObjectRepo.driver
		.manage()
		.timeouts()
		.implicitlyWait(30,
				TimeUnit.SECONDS);
		ObjectRepo.driver.manage().window().maximize();

	}

	public void tearDownDriver(Scenario scenario) throws Exception {

		try {
			if (ObjectRepo.driver != null) {
				ObjectRepo.driver.quit();
				ObjectRepo.reader = null;
				ObjectRepo.driver = null;
				oLog.info("Shutting Down the driver");
			}
		} catch (Exception e) {
			oLog.error(e);
			throw e;
		}
	}

}
