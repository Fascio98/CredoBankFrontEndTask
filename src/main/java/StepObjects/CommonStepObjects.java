package StepObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class CommonStepObjects {
    WebDriver webDriver;
    SoftAssert softAssert = new SoftAssert();
    WebDriverWait wait;

    WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void assertAll() {
        softAssert.assertAll();
    }
}
