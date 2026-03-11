package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.WaitUtils;

public class CartPage {

    WebDriver driver;

    // Locators
    By cartTitle = By.xpath("//h2[contains(text(),'Shopping Cart')]");

    By productName = By.xpath("//span[@class='a-truncate-cut' and contains(text(),'HP Smart Tank 589')]");

    By quantity = By.xpath("//div[@class='a-declarative']");

    // Constructor
    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    // Methods

    public boolean isCartPageOpened(){

        return WaitUtils
                .waitForElementVisible(driver, cartTitle)
                .isDisplayed();
    }

    public String getProductName(){

        return WaitUtils
                .waitForElementVisible(driver, productName)
                .getText();
    }

    public String getQuantity(){

        return WaitUtils
                .waitForElementVisible(driver, quantity)
                .getText();
    }
}
