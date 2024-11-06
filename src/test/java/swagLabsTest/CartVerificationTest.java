package swagLabsTest;

import org.example.swagLabs.HomePage;
import org.example.swagLabs.LoginPage;
import org.example.swagLabs.YourCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CartVerificationTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private YourCartPage yourCartPage;


    @Test(groups = {"Sanity"})
    public void testCartVerification() {
        assert driver!=null:"Webdriver is not initialized";
        log.info("---------- Running testCartVerification -----------");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        yourCartPage = new YourCartPage(driver);

        log.info("Performing login ...");
        //Login with valid credentials
        loginPage.performLogin("standard_user", "secret_sauce");
        log.info("Login successful");

        log.info("Adding products to cart");
        //Adding products to cart by product name
        homePage.addProductToCart("Sauce Labs Backpack");
        homePage.addProductToCart("Sauce Labs Bike Light");
        homePage.addProductToCart("Sauce Labs Bolt T-Shirt");
        homePage.addProductToCart("Sauce Labs Fleece Jacket");
        homePage.addProductToCart("Sauce Labs Onesie");
        homePage.addProductToCart("Test.allTheThings() T-Shirt (Red)");

        log.info("Navigating to Your cart page");
        //Navigating to Your Cart Page
        homePage.navigateToYourCartPage();

        log.info("Displaying all the products in the cart");
        //Displaying all the products in the cart by product name
        List<String> actualProducts = yourCartPage.displayProductsInCart();
        List<String> expectedProducts = Arrays.asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light",
                "Sauce Labs Bolt T-Shirt",
                "Sauce Labs Fleece Jacket",
                "Sauce Labs Onesie",
                "Test.allTheThings() T-Shirt (Red)"
        );

        log.info("Assert check for actual products count and expected.");
        //  Verify the actual count matches expected
        Assert.assertEquals(actualProducts.size(), expectedProducts.size(), "The number of products in the cart does not match the expected count.");
        log.info("The actual count matches the expected count.");
        log.info("Assert check for expected products added in the cart.");
        //Assert that all expected products are added in the cart
        Assert.assertTrue(actualProducts.containsAll(expectedProducts),"This cart does not contain all the expected products");
        log.info("---- All expected products are added in the cart ----");
        log.info("--------- Closing testCartVerification ---------");
    }
}
