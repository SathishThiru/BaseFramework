package com.cucumber.framework.stepdefinition;

import com.cucumber.framework.helper.pageobjects.HomePage;
import com.cucumber.framework.repo.ObjectRepo;
import com.cucumber.framework.utilities.Helper;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class FbStepDef extends Helper{
	
	//private WebDriver driver;
	Helper helper=new Helper();
	HomePage homePage = new HomePage(driver);
	
	@Given("^I am at the home page$")
	public void _i_am_at_the_home_page() throws Throwable {
		ObjectRepo.driver.get(ObjectRepo.reader.getWebsite());
		homePage.login("sathish");
		takeScreenShotWithTimestamp("fb");		
	}

}
