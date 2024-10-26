package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {
    // WebDriver instance for interacting with the browser
    private WebDriver driver;
    // WebDriverWait instance for managing explicit waits
    private WebDriverWait wait;

    // Locators for the registration form fields
    private final By firstNameField = By.id("firstname");
    private final By lastNameField = By.id("lastname");
    private final By emailAddressField = By.id("email_address");
    private final By passwordField = By.id("password");
    private final By confirmPasswordField = By.name("password_confirmation");
    private final By submitButton = By.xpath("//button[@title='Create an Account']");

    // Constructor to initialize the WebDriver and WebDriverWait
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;  // Initializes the WebDriver instance
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));  // Sets up WebDriverWait with a 5-second timeout
    }

    /**
     * Sets the first name in the registration form.
     *
     * @param firstname - The first name to be entered
     */
    public void setFirstName(String firstname) {
        enterText(firstNameField, firstname);  // Calls enterText helper to set the first name field
    }

    /**
     * Sets the last name in the registration form.
     *
     * @param lastName - The last name to be entered
     */
    public void setLastName(String lastName) {
        enterText(lastNameField, lastName);  // Calls enterText helper to set the last name field
    }

    /**
     * Sets the email in the registration form.
     *
     * @param email - The email address to be entered
     */
    public void setEmail(String email) {
        enterText(emailAddressField, email);  // Calls enterText helper to set the email field
    }

    /**
     * Sets the password in the registration form.
     *
     * @param password - The password to be entered
     */
    public void setPassword(String password) {
        enterText(passwordField, password);  // Calls enterText helper to set the password field
    }

    /**
     * Sets the confirm password in the registration form.
     *
     * @param confirmPassword - The confirmation password to be entered
     */
    public void setConfirmPassword(String confirmPassword) {
        enterText(confirmPasswordField, confirmPassword);  // Calls enterText helper to set the confirm password field
    }

    /**
     * Submits the registration form and navigates to the AccountPage.
     *
     * @return AccountPage - Returns a new instance of AccountPage after form submission
     */
    public AccountPage submitRegistrationForm() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));  // Waits until the submit button is clickable
        driver.findElement(submitButton).click();  // Clicks the submit button to create an account
        return new AccountPage(driver);  // Returns a new AccountPage instance after submission
    }

    /**
     * Helper method to wait for an input field, clear it, and enter specified text.
     *
     * @param locator - The locator of the input field
     * @param text    - The text to be entered into the input field
     */
    private void enterText(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));  // Waits until the element is visible
        driver.findElement(locator).clear();  // Clears any existing text in the field
        driver.findElement(locator).sendKeys(text);  // Enters the provided text into the field
    }

}