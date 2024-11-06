package jobserve;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected static final Logger log = LogManager.getLogger(BaseTest.class);


    @BeforeClass
    public void setUp() {
        log.info("Initializing Webdriver...");

        System.setProperty("webdriver.chrome.driver",
                "C://Users/sahaj/ChromeForTest/chromedriver-win64/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:/Users/sahaj/ChromeForTest/chrome-win64/chrome.exe");

        try{
            driver = new ChromeDriver(options);
            log.info("Webdriver initialized successfully..");
        }catch (WebDriverException e){
            log.error("Failed to initialize Webdriver: "+e.getMessage());
            throw e;
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://jobserve.com/us/en/Job-Search/");

    }

    @AfterClass
    public void tearDown() {
        log.info("Tearing down WebDriver...");
        if (driver != null) {
            driver.quit();
            driver = null; // Clean reference
        }
    }
}
