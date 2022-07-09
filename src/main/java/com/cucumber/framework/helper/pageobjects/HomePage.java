package com.cucumber.framework.helper.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cucumber.framework.helper.Logger.LoggerHelper;
import com.cucumber.framework.utilities.Helper;

public class HomePage extends Helper {
	
	private final Logger log = LoggerHelper.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="email")
	public WebElement txtUsername;
	
	public void login(String userName)
	{
		fillText(txtUsername, userName);
	}
	
}
