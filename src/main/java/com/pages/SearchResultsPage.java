package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.WaitUtils;

public class SearchResultsPage {

    WebDriver driver;

    // Locators using By class
    By searchResults = By.xpath("//div[@data-component-type='s-search-result']");
    By printer = By.xpath("//span[contains(text(),'Smart Tank 589')]/ancestor::a");

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isResultsDisplayed(){
        List<WebElement> results = driver.findElements(searchResults);
        return results.size() > 0;
    }

    public void selectPrinter(String printerName){
        WaitUtils.waitForElementClickable(driver, printer).click();
    }

}
