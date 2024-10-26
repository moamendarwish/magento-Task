package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import pages.HomePage;

import java.time.Duration;

public class BaseTest {

    // WebDriver instance that will be shared across tests
    protected WebDriver driver;
    // Instance of the page object that will be used in the tests
    protected HomePage homePage;

    /**
     * This method sets up the WebDriver and initializes the PracticeForm page object before any tests are run.
     * It is annotated with @BeforeClass, so it runs once before the first test method in each test class.
     */
    @BeforeClass
    public void setup() {
        // Initialize the ChromeDriver
        driver = new ChromeDriver();

        // Set the implicit wait time to 5 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Maximize the browser window to ensure all elements are visible
        driver.manage().window().maximize();

        // Navigate to the specified URL
        driver.navigate().to("https://magento.softwaretestingboard.com/");

        //Initialize the PracticeForm page object to interact with form elements
        homePage = new HomePage(driver);
    }

    /**
     * This method tears down the WebDriver after all test methods have run.
     * It is annotated with @AfterClass, so it runs once after all the tests in the current class have completed.
     */
    @AfterClass
    public void tearDownBrowser() {
        // Close the browser and quit the WebDriver session to free up resources
        if (driver != null) {
            driver.quit();
        }
    }
}
