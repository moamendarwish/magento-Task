package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountPage {

    // WebDriver instance for interacting with the browser
    private WebDriver driver;
    // WebDriverWait instance for managing explicit waits
    private WebDriverWait wait;

    // Locator for the welcome message displayed after account creation
    private final By welcomeMessage = By.xpath("//div[@data-ui-id = 'message-success']/div");

    /**
     * Constructor to initialize WebDriver and WebDriverWait
     *
     * @param driver - WebDriver instance passed from the test or previous page
     */
    public AccountPage(WebDriver driver) {
        this.driver = driver;  // Initializes the WebDriver
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));  // Sets up WebDriverWait with a 5-second timeout
    }

    /**
     * Verifies if the welcome message is displayed after account creation.
     *
     * @return boolean - True if the welcome message is visible, false otherwise
     */
    public boolean isWelcomeMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));  // Waits until the welcome message is visible
        return driver.findElement(welcomeMessage).isDisplayed();  // Returns true if the welcome message is displayed
    }

    /**
     * Retrieves the text of the welcome message.
     *
     * @return String - The text content of the welcome message
     */
    public String getWelcomeMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage));  // Waits until the welcome message is visible
        return driver.findElement(welcomeMessage).getText();  // Returns the welcome message text
    }

}