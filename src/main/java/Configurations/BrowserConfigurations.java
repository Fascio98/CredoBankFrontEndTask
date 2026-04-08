package Configurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BrowserConfigurations {
    public static WebDriver driver;
    public static String baseUrl = "https://mycredo.ge/landing/main/auth";
    public static long timeout = 20; // in seconds

    public BrowserConfigurations() {
        initializeBrowser();
    }

    /**
     * Initialize or reinitialize the browser
     */
    private static void initializeBrowser() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("--disable-notifications");

            // Initialize driver
            driver = new ChromeDriver(options);

            // Set timeouts
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeout));
            driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(timeout));

            // Open base URL
            driver.get(baseUrl);
        }
    }

    /**
     * Recreate browser before each test method
     */
    @BeforeMethod
    public void setUpBeforeMethod() {
        closeBrowser();
        initializeBrowser();
    }

    /**
     * Close browser after each test method
     */
    @AfterMethod
    public void tearDownAfterMethod() {
        closeBrowser();
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    /**
     * Close and cleanup the browser
     */
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null; // Reset driver to null after quitting
        }
    }
}
