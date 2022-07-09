package com.cucumber.framework.helper.Logger;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import com.cucumber.framework.utilities.Helper;
import com.cucumber.framework.utilities.Paths;

@SuppressWarnings("rawtypes")
public class LoggerHelper extends Helper {
	
	private static boolean root = false;
	
	public static Logger getLogger(Class clas) {
		if(root)
			return Logger.getLogger(clas);
		PropertyConfigurator.configure(Paths.mainResourcesPath+separator+"properties"+separator+"log4j.properties");
		root = true;
		return Logger.getLogger(clas);
	}

}
