package org.example.jobserve;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobServePage extends BasePage {


    public JobServePage(WebDriver driver) {
        super(driver);
    }

    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public void clickIndustriesDropdown() {
        WebElement industries_dropdown = driver.findElement(By.xpath("//span[@id='ddcl-selInd']//span[@class='ui-dropdownchecklist-selector ui-state-default']"));
        industries_dropdown.click();
    }

    public void uncheckSelectAll() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='ddcl-selInd-i0']"))).click();
    }

    public void selectIndustries() {
        String myString = "Education";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='" + myString + "']"))).click();
    }
}
