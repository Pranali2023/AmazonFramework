package com.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.utils.ConfigReader;
import com.utils.DriverFactory;
import com.utils.ExtentManager;
import com.listeners.TestListener;  // import your listener

@Listeners(TestListener.class)  // Attach your TestListener
public class BaseTest {
	
	protected WebDriver driver;

	 @BeforeSuite
	    public void cleanOldReports() {
	        ExtentManager.cleanReportsAndScreenshots();
	    }
    @BeforeMethod
    public void setup(){

        DriverFactory.initDriver();
        driver = DriverFactory.getDriver();

        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
