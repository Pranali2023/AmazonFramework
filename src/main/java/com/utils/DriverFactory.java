package com.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	

		    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

		    public static void initDriver(){

		    	ChromeOptions options = new ChromeOptions();
		    	options.addArguments("--disable-gpu");
		    	options.addArguments("--window-size=1920,1080");
		    	options.addArguments("--remote-allow-origins=*");
		        driver.set(new ChromeDriver(options));
		        driver.get().manage().window().maximize();
		    }

		    public static WebDriver getDriver(){

		        return driver.get();
		    }
		 
	 

}
