package jobserveTest;

import org.example.jobserve.JobServePage;
import org.testng.annotations.Test;

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
