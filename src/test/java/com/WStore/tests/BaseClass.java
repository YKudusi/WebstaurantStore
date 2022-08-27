package com.WStore.tests;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.WStore.utilities.ReadConfig;
import com.WStore.utilities.TestBase;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	
	TestBase testBase=new TestBase();
	
	@BeforeMethod
	public void setup() {
		testBase.launchBrowser();
	}
	
	@AfterMethod
	public void tearDown() {
		testBase.driver.quit();
	}

}
