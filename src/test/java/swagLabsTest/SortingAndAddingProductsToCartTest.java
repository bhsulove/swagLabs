package swagLabsTest;

import org.example.swagLabs.HomePage;
import org.example.swagLabs.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortingAndAddingProductsToCartTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @Test(groups = {"Regression"})
    public void testSortingAndAddingProductsToCart() {
        assert driver!=null:"Webdriver is not initialized";
        log.info("----- Starting testSortingAndAddingProductsToCart -----");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        log.info("Performing Login");
        //Login with valid credentials
        loginPage.performLogin("standard_user", "secret_sauce");
        log.info("Login successful");

        log.info("Select ZtoA from Dropdown ");
        //Sorting Dropdown -> Z to A --- (0-Name(A-Z), 1-Name(Z-A), 2-Price(low to high), 3-Price(high to low)) ---
        homePage.sortDropdownByIndex(1);

        log.info("Adding products to cart");
        //Adding products By Products name
        homePage.addProductToCart("Sauce Labs Backpack");
        homePage.addProductToCart("Sauce Labs Bike Light");
        homePage.addProductToCart("Sauce Labs Bolt T-Shirt");
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Onesie");
        homePage.addProductToCart("Test.allTheThings() T-Shirt (Red)");

        int cartItemCount = homePage.getCartItemCount();

        log.info("Validating all products are added to cart");
        //Asserting 6 products are displayed in the cart
        Assert.assertEquals(cartItemCount, 6, "The cart should contain 6 items");
        log.info("Validation Successful");
        log.info("----- Closing testSortingAndAddingProductsToCart -----");
    }
}
