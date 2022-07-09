package com.cucumber.framework.interfaces;

import com.cucumber.framework.configuration.browser.BrowserType;

public interface IconfigReader {
	public String getUserName();
	public String getPassword();
	public String getWebsite();
	public int getPageLoadTimeOut();
	public BrowserType getBrowser();
}
