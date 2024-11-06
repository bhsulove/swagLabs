package cricinfo;

import org.example.cricinfo.CricInfoPage;
import org.testng.annotations.Test;

public class CricInfoTest extends BaseTest{
    private CricInfoPage cricInfoPage;
    @Test
    public void testCricInfo(){
        log.info("---- Starting testCricInfo ----");
        cricInfoPage = new CricInfoPage(driver);
        log.info("---- Reading Scorecard ----");
        cricInfoPage.readDataFromTableBody();
        log.info("---- Finished testCricInfo ----");
    }
}
