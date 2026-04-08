import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BrowserConfigurations {
    public static WebDriver driver;
    public static String baseUrl = "https://mycredo.ge/landing/main/auth";
    public static String reportsFolder = "src/main/resources/FailedTests";
    public static long timeout = 20; // in seconds

    public BrowserConfigurations() {
        // Setup ChromeOptions
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

    // Method to take screenshot on failure (similar to AllureSelenide listener)
    public static void takeScreenshot(String testName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            File destFile = new File(reportsFolder + "/" + testName + ".png");
            FileUtils.copyFile(srcFile, destFile);
            System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver GetWebDriver() {
        return driver;
    }

    @AfterTest
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
