package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {

    // Variables
    private WebDriver driver;  // WebDriver instance for browser interactions
    private WebDriverWait wait;  // WebDriverWait instance for explicit waits

    // Locators
    private final By createAccountLink = By.xpath("(//a[text()='Create an Account'])[1]");
    private final By productsLocator = By.xpath("//li[@class='product-item']");
    private final By compareProductsLink = By.xpath("//a[@title='Compare Products']");
    private final By numberOfItemsAddedToCompareProducts = By.xpath("//a[@title='Compare Products']/span");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;  // Initializes the WebDriver
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));  // Initializes the WebDriverWait with a 5-second timeout
    }

    /**
     * Method to navigate to the Registration page by clicking the "Create an Account" link
     *
     * @return RegistrationPage - A new instance of the RegistrationPage
     */
    public RegistrationPage clickCreateAccountLink() {
        driver.findElement(createAccountLink).click();  // Clicks on the "Create an Account" link
        return new RegistrationPage(driver);  // Returns a new RegistrationPage object
    }

    /**
     * Method to add a specified number of products to the comparison list
     *
     * @param numberOfProducts - The number of products to add to the comparison list
     */
    public void addProductsToCompareList(int numberOfProducts) {
        Actions action = new Actions(driver);  // Creates an Actions instance for complex interactions

        for (int i = 0; i < numberOfProducts; i++) {
            // Re-locate the product list in each iteration to avoid stale element exceptions
            List<WebElement> productsList = driver.findElements(productsLocator);
            WebElement product = productsList.get(i);  // Selects the current product in the iteration

            // Scrolls to the product element to bring it into view
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);

            // Finds the "Add to Compare" button for the current product using dynamic XPath
            WebElement addToCompare = driver.findElement(By.xpath(String.format("(//a[@class='action tocompare'])[%s]", i + 1)));

            // Waits for the "Add to Compare" button to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(addToCompare));

            // Moves to the product and clicks the "Add to Compare" button
            action.moveToElement(product).click(addToCompare).perform();
        }
    }

    /**
     * Method to navigate to the Compare Products page by clicking the "Compare Products" link
     *
     * @return CompareProductsPage - A new instance of the CompareProductsPage
     */
    public CompareProductsPage clickCompareProductsLink() {
        driver.findElement(compareProductsLink).click();  // Clicks on the "Compare Products" link in the header
        return new CompareProductsPage(driver);  // Returns a new CompareProductsPage object
    }

    /**
     * Method to retrieve the number of items added to the comparison list from the header
     *
     * @return String - The number of items as a text from the header
     */
    public String getNumberOfItemsAddedInHeader() {
        return driver.findElement(numberOfItemsAddedToCompareProducts).getText();  // Fetches and returns the text showing the number of compared items
    }

}