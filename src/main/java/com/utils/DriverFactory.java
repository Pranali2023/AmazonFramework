package com.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {
	

		    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

		    public static void initDriver(){

		        driver.set(new ChromeDriver());
		        driver.get().manage().window().maximize();
		    }

		    public static WebDriver getDriver(){

		        return driver.get();
		    }
		 
	 

}
