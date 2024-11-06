package org.example.swagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class YourCartPage extends BasePage {
    private WebDriverWait wait;

    public YourCartPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public List<String> displayProductsInCart() {
        List<String> productNames = new ArrayList<>();
        try {
            // Locate all product elements in the cart
            String productSelector = ".inventory_item_name"; // Update with your actual selector
            List<WebElement> productElements = driver.findElements(By.cssSelector(productSelector));

            if (productElements.isEmpty()) {
                System.out.println("No products found in the cart.");
            } else {
                System.out.println("Products in the cart:");
                for (WebElement product : productElements) {
                    productNames.add(product.getText());
                    System.out.println("- " + product.getText());
                }
            }
        } catch (Exception e) {
            System.out.println("Error retrieving products from the cart: " + e.getMessage());
        }
        return productNames;
    }

}
