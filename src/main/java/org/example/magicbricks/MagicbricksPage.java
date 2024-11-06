package org.example.magicbricks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MagicbricksPage extends BasePage{
    public MagicbricksPage(WebDriver driver) {
        super(driver);
    }
    private WebDriverWait wait;
    



    public void clickOnRent(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String mainWindow = driver.getWindowHandle();
        Actions action = new Actions(driver);
        WebElement rent = driver.findElement(By.xpath("//a[@id='rentheading']"));
        wait.until(ExpectedConditions.visibilityOf(rent));
        action.moveToElement(rent).perform();

    }
    public void clickOnFurnishedHomes(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions action = new Actions(driver);
        WebElement furnishedHomes = driver.findElement(By.xpath("//a[normalize-space()='Furnished Homes']"));

        clickOnRent();
        wait.until(ExpectedConditions.visibilityOf(furnishedHomes));
        action.moveToElement(furnishedHomes).click().perform();

    }
    public void printHeaderAndSwitchBackToMainWindow(){
        clickOnRent();
        clickOnFurnishedHomes();
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String originalWindow = iterator.next();
        String newWindow = iterator.next();
        driver.switchTo().window(newWindow);
        WebElement results = driver.findElement(By.xpath("//div[@class='mb-srp__title--text1']"));
        WebElement header = driver.findElement(By.xpath("//h1"));
        System.out.println(results.getText()+header.getText());
        

    }

}
