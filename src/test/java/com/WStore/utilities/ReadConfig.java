package com.WStore.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getEnvironment() {
		return pro.getProperty("environment");
	}

	public String getApplicationURL() {
		return pro.getProperty("QAUrl");
	}

	public String getChromePath() {
		return pro.getProperty("chromepath");
	}

	public String getBrowserType() {
		return pro.getProperty("browserType");
	}


}
