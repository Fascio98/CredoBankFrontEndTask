package StepObjects;

import PageObjects.LoginPage;
import Utils.Constants;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps extends CommonStepObjects {
    LoginPage loginPage;
    public LoginSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
        loginPage = new LoginPage(webDriver);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public LoginSteps closeAnyNotificationIfItsOpened() {
        try {
            WebElement notificationXButton = webDriver.findElement(loginPage.notificationXButton);
            if (notificationXButton.isDisplayed()) {
                notificationXButton.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Notification X button not present.");
        }

        return this;
    }

    public LoginSteps clearUsernameField() {
        WebElement userNameField = waitForVisible(loginPage.userNameField);
        userNameField.clear();

        return this;
    }

    public LoginSteps fillUsernameField(String userName) {
        WebElement userNameField = waitForVisible(loginPage.userNameField);
        userNameField.sendKeys(userName);
        softAssert.assertEquals(userNameField.getAttribute("value"), userName);

        return this;
    }

    public LoginSteps clearPasswordField() {
        WebElement passwordField = waitForVisible(loginPage.passwordField);
        passwordField.clear();

        return this;
    }

    public LoginSteps fillPasswordField(String password) {
        WebElement passwordField = waitForVisible(loginPage.passwordField);
        passwordField.sendKeys(password);
        softAssert.assertEquals(passwordField.getAttribute("value"), password);

        return this;
    }

    public LoginSteps clickLoginButton() {
        WebElement loginButton = waitForVisible(loginPage.loginButton);
        loginButton.click();

        return this;
    }

    public LoginSteps clickLanguageSwitcherButton() {
        WebElement languageSwitcherButton = waitForVisible(loginPage.languageSwitcherButton);
        languageSwitcherButton.click();

        return this;
    }

    public LoginSteps assertLoginButtonIsDisabled() {
        WebElement loginButton = waitForVisible(loginPage.loginButton);
        softAssert.assertTrue(!loginButton.isEnabled());

        return this;
    }

    public LoginSteps assertCredentialsAreWrong(String language) {
        WebElement wrongCredentialsNotification = waitForVisible(loginPage.wrongCredentialsNotification);
        if (language.equals(Constants.Language.GEORGIAN.getLanguage())) {
            softAssert.assertEquals(wrongCredentialsNotification.getText(), "მონაცემები არასწორია");
        } else {
            softAssert.assertEquals(wrongCredentialsNotification.getText(), "მონაცემოლ სწორ დემეგ ლი");
        }
        return this;
    }
}
