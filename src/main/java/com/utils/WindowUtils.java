package com.utils;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowUtils {
	public static void switchToNewTab(WebDriver driver){

        Set<String> windows = driver.getWindowHandles();

        for(String window : windows){

            driver.switchTo().window(window);
        }
    }

}
