package org.example.cricinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CricInfoPage extends BasePage{
    public CricInfoPage(WebDriver driver) {
        super(driver);
    }   
    public void readDataFromTableBody(){
        WebElement scoreTable = driver.findElement(By.xpath("(//table[@class='ds-w-full ds-table ds-table-md ds-table-auto  ci-scorecard-table'])[1]"));
        WebElement tbody = scoreTable.findElement(By.tagName("tbody"));
        List<WebElement> rows = tbody.findElements(By.tagName("tr"));

        rows.stream()
                .limit(15)
                .map(row -> row.findElements(By.tagName("td")))
                .filter(cells -> cells.size() >= 3)
                .map(cells -> new String[] {
                        cells.get(0).getText(),
                        cells.get(2).getText()
                })
                .forEach(columns -> {
                    // Print the specific columns (1st and 3rd)
                    System.out.println("Batting: " + columns[0] + ", Runs: " + columns[1]);
                });

    }



}
