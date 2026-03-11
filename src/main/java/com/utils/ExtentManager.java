package com.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class ExtentManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private static String reportPath;
    private static String getReportFilePath() {
    	String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

        File reportDir = new File("reports");
        if (!reportDir.exists()) reportDir.mkdirs();

        reportPath = System.getProperty("user.dir") + "/reports/extentReport_" + timestamp + ".html";

        return reportPath;
    }

    public static String getReportPath() {
        return reportPath;
    }
    
    public static ExtentReports getExtentReports() {
        if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter(getReportFilePath());
            spark.config().setReportName("Automation Test Report");
            spark.config().setDocumentTitle("Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Framework", "Selenium TestNG");
            extent.setSystemInfo("Tester", "Automation");
        }
        return extent;
    }

   
    public static void setTest(ExtentTest extentTest) {
        test.set(extentTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = screenshotName.replaceAll("\\s+", "_") + "_" + timestamp + ".png";

        // Screenshot folder
        String screenshotDir = System.getProperty("user.dir") + "/reports/screenshots/";
        File dir = new File(screenshotDir);
        if (!dir.exists()) dir.mkdirs();

        // Full path
        String absolutePath = screenshotDir + fileName;

        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(absolutePath));
            System.out.println("Screenshot saved at: " + absolutePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return absolutePath;
    }

    
    public static void attachScreenshot(WebDriver driver, ExtentTest test, String stepDescription) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = stepDescription.replaceAll("\\s+", "_") + "_" + timestamp + ".png";

        String screenshotDir = System.getProperty("user.dir") + "/reports/screenshots/";
        File dir = new File(screenshotDir);
        if (!dir.exists()) dir.mkdirs();

        String absolutePath = screenshotDir + fileName;
        String relativePath = "screenshots/" + fileName; // path used in HTML

        try {
        
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src, new File(absolutePath));

            test.fail(stepDescription, MediaEntityBuilder.createScreenCaptureFromPath(relativePath).build());
            System.out.println("Screenshot attached to report: " + relativePath);

        } catch (IOException e) {
            e.printStackTrace();
            test.fail("Failed to attach screenshot: " + e.getMessage());
        }
    }
    
    public static void cleanReportsAndScreenshots() {

        File reportsFolder = new File(System.getProperty("user.dir") + "/reports");

        if (!reportsFolder.exists()) {
            return;
        }

        File[] files = reportsFolder.listFiles();

        if (files == null) {
            return;
        }

        for (File file : files) {

            if (file.isDirectory()) {
                deleteDirectory(file);
            } else {
                file.delete();
            }
        }

        System.out.println("Old reports and screenshots cleaned successfully.");
    }

    private static void deleteDirectory(File directory) {

        File[] files = directory.listFiles();

        if (files != null) {

            for (File file : files) {

                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }

        directory.delete();
    }

    
}
