package org.example.cricinfo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.logging.Logger;

public class BasePage {
    WebDriver driver;

    protected static Logger log = Logger.getLogger(BasePage.class.getName());
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
