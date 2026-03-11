package com.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.utils.DriverFactory;
import com.utils.ExtentManager;
import com.utils.ScreenshotUtil;

public class TestListener implements ITestListener{

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest test = ExtentManager
                .getExtentReports()
                .createTest(result.getMethod().getMethodName());

        ExtentManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = ExtentManager.getTest();
        test.fail(result.getThrowable());

        // Capture screenshot
        WebDriver driver = DriverFactory.getDriver();
        if(driver != null) {
            String screenshotPath = ScreenshotUtil.capture(driver, result.getMethod().getMethodName());
            test.fail("Screenshot of failure",
			        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        }
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
    	 ExtentManager.getExtentReports().flush();

    	    try {
    	        Desktop.getDesktop().browse(new File(ExtentManager.getReportPath()).toURI());
    	    } 
    	    catch (IOException e) {
    	        e.printStackTrace();
    	    }
    }
}
