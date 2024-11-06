package swagLabsTest;

import org.example.swagLabs.HomePage;
import org.example.swagLabs.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAndBasicValidationsTest extends BaseTest {

    @Test(groups = {"Smoke"})
    public void testLogin() {
        log.info("------------ Starting testLogin -----------");
        assert driver!=null:"Webdriver is not initialized..";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        log.info("---- Performing Login ----");
        //Login in with valid credentials
        loginPage.performLogin("standard_user", "secret_sauce");

        log.info("----Validating Login ------");
        //Validate "Swag Labs" is displayed
        Assert.assertEquals(homePage.getProductPageTitle(), "Swag Labs","Product page title mismatch!");
        log.info("---- Login Successful ----");
        log.info("---- Validating sorting dropdown is visible ------");
        //Validate sorting dropdown is visible
        Assert.assertTrue(homePage.getSortingDropdown());
        log.info("---- Sorting dropdown is visible ------");
        log.info("------------ Ending testLogin ------------");
    }
}
