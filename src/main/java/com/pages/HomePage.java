package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.WaitUtils;

public class HomePage {

    WebDriver driver;

    By searchBox = By.id("twotabsearchtextbox");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void searchProduct(String product){

        WaitUtils
        .waitForElementVisible(driver, searchBox)
        .sendKeys(product);

        WaitUtils
        .waitForElementVisible(driver, searchBox)
        .submit();
    }
}
