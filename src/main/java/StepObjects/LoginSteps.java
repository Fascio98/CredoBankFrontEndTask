package StepObjects;

import PageObjects.LoginPage;
import Utils.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class LoginSteps extends CommonStepObjects {
    private static final Logger logger = Logger.getLogger(LoginSteps.class.getName());
    LoginPage loginPage;
    
    public LoginSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.loginPage = new LoginPage(webDriver);
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @SuppressWarnings("UnusedReturnValue") // Method chaining pattern used in step objects
    @Step("Close any notification if it's opened")
    public LoginSteps closeAnyNotificationIfItsOpened() {
        try {
            WebElement notificationXButton = webDriver.findElement(loginPage.notificationXButton);
            if (notificationXButton.isDisplayed()) {
                notificationXButton.click();
            }
        } catch (NoSuchElementException e) {
            logger.info("Notification X button not present.");
        }

        return this;
    }

    @Step("Fill username field with: {userName}")
    public LoginSteps fillUsernameField(String userName) {
        WebElement userNameField = waitForVisible(loginPage.userNameField);
        userNameField.sendKeys(userName);
        softAssert.assertEquals(userNameField.getAttribute("value"), userName);

        return this;
    }

    @Step("Fill password field with: {password}")
    public LoginSteps fillPasswordField(String password) {
        WebElement passwordField = waitForVisible(loginPage.passwordField);
        passwordField.sendKeys(password);
        softAssert.assertEquals(passwordField.getAttribute("value"), password);

        return this;
    }

    @Step("Click on login button")
    public LoginSteps clickLoginButton() {
        WebElement loginButton = waitForVisible(loginPage.loginButton);
        loginButton.click();

        return this;
    }

    @Step("Click on language switcher button")
    @SuppressWarnings("UnusedReturnValue") // Method chaining pattern used in step objects
    public LoginSteps clickLanguageSwitcherButton() {
        WebElement languageSwitcherButton = waitForVisible(loginPage.languageSwitcherButton);
        languageSwitcherButton.click();

        return this;
    }

    @Step("Click on remember me checkbox")
    public LoginSteps clickRememberMeCheckbox() {
        WebElement rememberMeCheckbox = waitForVisible(loginPage.rememberMeCheckbox);
        rememberMeCheckbox.click();

        return this;
    }

    @Step("Assert that login button is disabled")
    @SuppressWarnings("UnusedReturnValue") // Method chaining pattern used in step objects
    public LoginSteps assertLoginButtonIsDisabled() {
        WebElement loginButton = waitForVisible(loginPage.loginButton);
        softAssert.assertFalse(loginButton.isEnabled(), "Login button should be disabled");

        return this;
    }

    @Step("Assert that credentials are wrong for language: {language}")
    @SuppressWarnings("UnusedReturnValue") // Method chaining pattern used in step objects
    public LoginSteps assertCredentialsAreWrong(String language) {
        WebElement wrongCredentialsNotification = waitForVisible(loginPage.wrongCredentialsNotification);
        
        if (language.equals(Constants.Language.GEORGIAN.getLanguage())) {
            softAssert.assertEquals(wrongCredentialsNotification.getText(), "მონაცემები არასწორია");
        } else if (language.equals(Constants.Language.SVAN.getLanguage())) {
            softAssert.assertEquals(wrongCredentialsNotification.getText(), "მონაცემოლ სწორ დემეგ ლი");
        } else {
            throw new IllegalArgumentException("Unsupported language: " + language);
        }
        
        return this;
    }
}
