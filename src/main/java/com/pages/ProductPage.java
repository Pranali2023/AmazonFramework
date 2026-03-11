package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.utils.WaitUtils;

public class ProductPage {

    WebDriver driver;

    // Locators
    By productTitle = By.id("productTitle");

    By quantityDropdown = By.id("quantity");

    By addToCartBtn = By.xpath("//input[@title=\"Add to Shopping Cart\"]");

  //  By cartSidePanel = By.className("attach-close-button");
    
    By subtotalText = By.xpath("//span[@class=\"a-price sw-subtotal-amount\"]");

    By goToCartBtn = By.xpath("(//a[contains(text(),\"Go to Cart\")])[2]");

    // Constructor
    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    // Verify product page
    public boolean isProductPageOpened(){

        return WaitUtils
                .waitForElementVisible(driver, productTitle)
                .isDisplayed();
    }

    // Select quantity
    public void selectQuantity(String qty){

        Select select = new Select(
                WaitUtils.waitForElementVisible(driver, quantityDropdown)
        );

        select.selectByValue(qty);

        // click outside to close dropdown
        driver.findElement(By.id("productTitle")).click();
    }

    // Add product to cart
    public void addToCart() throws InterruptedException{

        WaitUtils
                .waitForElementClickable(driver, addToCartBtn)
                .click();
        
//        Thread.sleep(20);
//        WaitUtils
//        .waitForElementClickable(driver, cartSidePanel)
//        .click();
    }

    // Verify subtotal
    public boolean isSubtotalDisplayed(){

    	 try{

    	        return WaitUtils
    	                .waitForElementVisible(driver, subtotalText)
    	                .isDisplayed();

    	    }catch(Exception e){

    	        return false;
    	    }
    }

    // Go to cart
    public void goToCart(){

        WaitUtils
                .waitForElementClickable(driver, goToCartBtn)
                .click();
    }
}
