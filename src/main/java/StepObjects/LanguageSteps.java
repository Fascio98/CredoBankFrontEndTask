package StepObjects;

import PageObjects.LanguagePage;
import Utils.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LanguageSteps extends CommonStepObjects {
    LanguagePage languagePage;
    
    public LanguageSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.languagePage = new LanguagePage(webDriver);
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @SuppressWarnings("UnusedReturnValue") // Method chaining pattern used in step objects
    public LanguageSteps clickCustomLanguage(String language) {
        if (language.equals(Constants.Language.GEORGIAN.getLanguage())) {
            WebElement georgianLanguage = waitForVisible(languagePage.georgianLanguage);
            georgianLanguage.click();
        } else if (language.equals(Constants.Language.SVAN.getLanguage())) {
            WebElement svanLanguage = waitForVisible(languagePage.svanLanguage);
            svanLanguage.click();
        } else {
            throw new IllegalArgumentException("Unsupported language: " + language);
        }

        return this;
    }
}
