package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.base.BaseTest;
import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.ProductPage;
import com.pages.SearchResultsPage;
import com.utils.ConfigReader;
import com.utils.ExtentManager;

public class AmazonCartTest extends BaseTest {

    @Test
    public void verifyPrinterAddToCart() throws InterruptedException {

        // Test Data
        String baseUrl = ConfigReader.get("baseUrl");
        String productName = ConfigReader.get("product");
        String model = ConfigReader.get("model");
        String quantity = ConfigReader.get("quantity");

        // Page Objects
        HomePage home = new HomePage(driver);
        SearchResultsPage results = new SearchResultsPage(driver);
        ProductPage product = new ProductPage(driver);
        CartPage cart = new CartPage(driver);

//        ExtentTest test = ExtentManager
//                .getExtentReports()
//                .createTest("Verify Add Printer To Cart");
//
//        ExtentManager.setTest(test);
        
        ExtentTest test = ExtentManager.getTest();

        test.info("Navigating to base URL");
        driver.get(baseUrl);

        test.info("Searching product: " + productName);
        home.searchProduct(productName);

        test.info("Verifying search results are displayed");
        Assert.assertTrue(results.isResultsDisplayed(),
                "Search results are not displayed");

        test.info("Selecting printer model: " + model);
        results.selectPrinter(model);

        test.info("Verifying product page opened");
        Assert.assertTrue(product.isProductPageOpened(),
                "Product page did not open");

        test.info("Selecting quantity: " + quantity);
        product.selectQuantity(quantity);

        test.info("Adding product to cart");
        product.addToCart();

        test.info("Verifying subtotal is displayed");
        Assert.assertTrue(product.isSubtotalDisplayed(),
                "Subtotal is not displayed");

        test.info("Navigating to cart page");
        product.goToCart();

        test.info("Verifying cart page opened");
        Assert.assertTrue(cart.isCartPageOpened(),
                "Cart page did not open");

        test.info("Verifying product name in cart");
        Assert.assertTrue(cart.getProductName().contains("HP Smart Tank 589"));

        test.info("Verifying product quantity in cart");
        Assert.assertEquals(cart.getQuantity(), "2");
    }
}
