package StepObjects;

import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginSteps {
    WebDriver webDriver;
    LoginPage loginPage;
    WebDriverWait wait;
    public LoginSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
        loginPage = new LoginPage(webDriver);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }
    SoftAssert softAssert = new SoftAssert();

    public LoginSteps fillUsernameField(String userName) {
        WebElement userNameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginPage.userNameField)
        );
        userNameField.sendKeys(userName);

        return this;
    }

    public LoginSteps fillPasswordField(String password) {
        WebElement passwordField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginPage.passwordField)
        );
        passwordField.sendKeys(password);

        return this;
    }

    public LoginSteps clickLoginButton() {
        WebElement loginButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginPage.loginButton)
        );
        loginButton.click();

        return this;
    }

    public LoginSteps clickLanguageSwitcherButton() {
        WebElement languageSwitcherButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginPage.languageSwitcherButton)
        );
        languageSwitcherButton.click();

        return this;
    }

    public LoginSteps assertLoginButtonIsDisabled() {
        WebElement loginButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginPage.loginButton)
        );
        softAssert.assertTrue(!loginButton.isEnabled());

        return this;
    }

    public LoginSteps assertCredentialsAreWrong(String language) {
        WebElement wrongCredentialsNotification = wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginPage.wrongCredentialsNotification)
        );
        if (language == "Georgian") {
            softAssert.assertEquals(wrongCredentialsNotification.getText(), "მონაცემები არასწორია");
        } else if (language == "Megrelian") {
            softAssert.assertEquals(wrongCredentialsNotification.getText(), "");
        } else {
            softAssert.assertEquals(wrongCredentialsNotification.getText(), "მონაცემოლ სწორ დემეგ ლი");
        }
        return this;
    }
}
