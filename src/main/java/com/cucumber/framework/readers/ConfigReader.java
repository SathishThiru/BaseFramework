package com.cucumber.framework.readers;

import java.io.FileInputStream;
import java.util.Properties;
import org.apache.log4j.Level;
import com.cucumber.framework.configuration.browser.BrowserType;
import com.cucumber.framework.interfaces.IconfigReader;
import com.cucumber.framework.utilities.Helper;
import com.cucumber.framework.utilities.Paths;

public class ConfigReader implements IconfigReader {
	
	private Properties prop = null;

	public ConfigReader() {
		prop = new Properties();
		try {
			prop.load(new FileInputStream(Paths.mainResourcesPath+Helper.separator+"properties"+Helper.separator
							+ "config.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUserName() {
		return prop.getProperty("Username");
	}

	public String getPassword() {
		return prop.getProperty("Password");
	}

	public String getWebsite() {
		return prop.getProperty("Website");
	}

	public int getPageLoadTimeOut() {
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}
	
	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}
	
	public Level getLoggerLevel() {
		
		switch (prop.getProperty("Logger.Level")) {
		
		case "DEBUG":
			return Level.DEBUG;
		case "INFO":
			return Level.INFO;
		case "WARN":
			return Level.WARN;
		case "ERROR":
			return Level.ERROR;
		case "FATAL":
			return Level.FATAL;
		}
		return Level.ALL;
	}

}
