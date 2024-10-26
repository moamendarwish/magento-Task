package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompareProductsPage {

    // WebDriver instance for interacting with the browser
    private WebDriver driver;

    // Locator for the products in the comparison list
    private final By productLocator = By.xpath("//td[@data-th=\"Product\"]");

    /**
     * Constructor to initialize the WebDriver
     *
     * @param driver - WebDriver instance passed from the test or parent page
     */
    public CompareProductsPage(WebDriver driver) {
        this.driver = driver;  // Initializes the WebDriver
    }

    /**
     * Method to retrieve the count of products added to the comparison list.
     *
     * @return int - The number of products in the comparison list
     */
    public int getNumberOfProductsAdded(){
        return driver.findElements(productLocator).size();  // Counts elements matching the product locator and returns the count
    }

}