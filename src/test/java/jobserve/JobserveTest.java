package jobserve;

import org.example.jobserve.JobServePage;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class JobserveTest extends BaseTest{
    private JobServePage jobServePage;

    @Test
    public void testJobserve(){
        log.info("Starting testJobserve");
        jobServePage = new JobServePage(driver);
        log.info("Clicking on 'Industries' dropdown");
        jobServePage.clickIndustriesDropdown();
        log.info("Uncheking 'Select All' checkbox");
        jobServePage.uncheckSelectAll();
        log.info("Checking 'Education' checkbox");
        jobServePage.selectIndustries();
        log.info("Closing testJobserve");
    }
}
