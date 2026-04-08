package StepObjects;

import PageObjects.LanguagePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguageSteps {
    WebDriver webDriver;
    public LanguageSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    LanguagePage languagePage = new LanguagePage(webDriver);
    WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));

    public LanguageSteps clickGeorgianLanguage() {
        WebElement georgianLanguage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(languagePage.georgianLanguage)
        );
        georgianLanguage.click();

        return this;
    }

    public LanguageSteps clickMegrelianLanguage() {
        WebElement megrelianLanguage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(languagePage.megrelianLanguage)
        );
        megrelianLanguage.click();

        return this;
    }

    public LanguageSteps clickSvanLanguage() {
        WebElement svanLanguage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(languagePage.svanLanguage)
        );
        svanLanguage.click();

        return this;
    }
}
