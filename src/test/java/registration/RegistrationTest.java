package registration;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.RegistrationPage;

import static org.testng.Assert.assertTrue;

public class RegistrationTest extends BaseTest {

    /**
     * Test user registration with various data inputs.
     *
     * @param firstName - User's first name
     * @param lastName - User's last name
     * @param email - User's email address
     * @param password - User's password
     */
    @Test(dataProvider = "registrationData")
    public void testRegistration(String firstName, String lastName, String email, String password,String confirmPassword) {
        // Navigate to Registration Page
        RegistrationPage registrationPage = homePage.clickCreateAccountLink();

        // Fill in registration form
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.setPassword(password);
        registrationPage.setConfirmPassword(password);
        registrationPage.setConfirmPassword(confirmPassword);

        // Submit form and verify account creation
        AccountPage accountPage = registrationPage.submitRegistrationForm();
        // Assert if the welcome message is displayed on the account page
        assertTrue(accountPage.isWelcomeMessageDisplayed(), "The welcome message is not displayed");
        // Verify the content of the welcome message
        assertTrue(accountPage.getWelcomeMessage().contains("Thank you for registering with Main Website Store."));    }

    // DataProvider for registration data
    @DataProvider(name = "registrationData")
    public Object[][] registrationData() {
        return new Object[][] {
                {"momen", "darwish", "moamen.darwish3@gmail.com", "Moamen@123","Moamen@123"}
        };
    }
}