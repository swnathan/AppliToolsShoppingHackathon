package com.test.helper;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class GlobalVariables {

	static EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
	
	public static String applicationURL = variables.getProperty("applicationURL");
	
	public static String apikey = variables.getProperty("apikey");
		
}