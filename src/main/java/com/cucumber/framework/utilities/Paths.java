package com.cucumber.framework.utilities;

public class Paths extends Helper{
	
	public static String baseDirPath=System.getProperty("user.dir");
	public static String testResourcesPath=baseDirPath+separator+"src"+separator+"test"+separator+"resources";
	public static String mainResourcesPath=baseDirPath+separator+"src"+separator+"main"+separator+"resources";
	public static String screenshotDirPath=testResourcesPath+separator+"Screenshots";
	public static String logFilePath=baseDirPath+separator+"target"+separator+"Execution.log";

}
