package com.cucumber.framework.runner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.framework.utilities.Helper;
import com.cucumber.framework.utilities.Paths;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\Sathish\\Desktop\\baseframework\\SeleniumCucumber-master\\src\\test\\resources\\featurefile\\Search.feature" , glue = {"com.cucumber.framework.stepdefinition","com.cucumber.framework.initializer"}, monochrome=true
,tags="@test123"
)

public class TestRunner  
{
	@BeforeClass
	public static void setUp() throws IOException
	{
		 new PrintWriter(Paths.logFilePath).close();
		 FileUtils.deleteDirectory(new File(Paths.screenshotDirPath));
	}
	
	@AfterClass
	public static void tearDown() throws IOException
	{
		Date d= new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
		File logFileInitialName=new File(Paths.testResourcesPath+Helper.separator+"logs"+Helper.separator+"Execution.log");
		File logFileFinalName= new File(Paths.testResourcesPath+Helper.separator+"logs"+Helper.separator+"Execution_"+sdf.format(d)+".log");
		FileUtils.copyFileToDirectory(new File(Paths.logFilePath), new File(Paths.testResourcesPath+Helper.separator+"logs"+Helper.separator));
		logFileInitialName.renameTo(logFileFinalName);
		
		File screenshotLastRunFolder=new File(Paths.screenshotDirPath+Helper.separator+"LastRun");
		
		if(screenshotLastRunFolder.exists())
		{
			FileUtils.copyDirectory(screenshotLastRunFolder, new File(Paths.screenshotDirPath+Helper.separator+"Screenshots_"+sdf.format(d)));
		}
		
		
	
	}

}
