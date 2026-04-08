package StepObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

/**
 * Base class for all Step Objects containing common functionality
 */
public class CommonStepObjects {
    protected WebDriver webDriver;
    protected SoftAssert softAssert;  // Do not initialize here - must be fresh per test
    protected WebDriverWait wait;

    /**
     * Waits for an element to be visible on the page
     * @param locator The By locator for the element
     * @return The visible WebElement
     */
    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    /**
     * Initialize a fresh SoftAssert instance for the current test.
     * MUST be called before each test to avoid assertion accumulation.
     */
    public void initializeSoftAssert() {
        softAssert = new SoftAssert();
    }
    
    /**
     * Verifies all soft assertions collected during the test
     */
    public void assertAll() {
        if (softAssert != null) {
            softAssert.assertAll();
        }
    }
}
