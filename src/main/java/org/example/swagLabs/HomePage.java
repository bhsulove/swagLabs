package org.example.swagLabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    private WebDriverWait wait;
    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String getProductPageTitle() {
        return driver.getTitle();
    }
    public boolean getSortingDropdown(){
        return driver.findElement(By.xpath("//select[@class='product_sort_container']")).isDisplayed();
    }
    public boolean sortDropdownByIndex(int value) {
        Select select = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
        select.selectByIndex(value);
        return true;
    }
    // Method to add a product to the cart
    public void addProductToCart(String productName) {
        // Locate the product element by its name or other attributes
        String productSelector = String.format("//div[contains(text(), '%s')]//following::button[1]", productName);

        try {
            // Wait until the product button is clickable
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(productSelector)));

            // Click the button to add the product to the cart
            driver.findElement(By.xpath(productSelector)).click();
            System.out.println(productName + " has been added to the cart.");
        } catch (Exception e) {
            System.out.println("Error adding product to cart: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public int getCartItemCount() {
        try {
            // Locate the shopping cart badge element
            String cartBadgeSelector = "span.fa-layers-counter.shopping_cart_badge"; // CSS selector for the badge
            String badgeText = driver.findElement(By.cssSelector(cartBadgeSelector)).getText();
            return Integer.parseInt(badgeText); // Convert the text to an integer
        } catch (Exception e) {
            System.out.println("Error retrieving cart item count: " + e.getMessage());
            return 0; // Return 0 if there's an error
        }
    }
    public void navigateToYourCartPage(){
        driver.findElement(By.cssSelector(".fa-layers-counter.shopping_cart_badge")).click();
        System.out.println("Inside Your Cart Page");
    }
}