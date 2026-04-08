package StepObjects;

import PageObjects.LanguagePage;
import Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguageSteps extends CommonStepObjects {
    LanguagePage languagePage;
    public LanguageSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.languagePage = new LanguagePage(webDriver);
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public LanguageSteps clickCustomLanguage(String language) {
        WebElement georgianLanguage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(languagePage.georgianLanguage)
        );
        WebElement svanLanguage = webDriver.findElement(languagePage.svanLanguage);
        if (language.equals(Constants.Language.GEORGIAN.getLanguage())) {
            georgianLanguage.click();
        } else {
            svanLanguage.click();
        }

        return this;
    }
}
