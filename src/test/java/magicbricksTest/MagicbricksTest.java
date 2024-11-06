package magicbricksTest;

import org.example.magicbricks.MagicbricksPage;
import org.testng.annotations.Test;

public class MagicbricksTest extends BaseTest{
    private MagicbricksPage magicbricksPage;
    @Test
    public void magicbricksTest() throws InterruptedException {
        log.info("--- Starting magicbrickstest ---");
        magicbricksPage = new MagicbricksPage(driver);
        log.info("Clicking on Rent");
        magicbricksPage.clickOnRent();
        log.info("Clicking on Furnished Homes");
        magicbricksPage.clickOnFurnishedHomes();
        log.info("Printing header and navigating back to main window");
        magicbricksPage.printHeaderAndSwitchBackToMainWindow();
        log.info("--- Ending magicbrickstest ---");

    }
}
