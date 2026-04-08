import StepObjects.LanguageSteps;
import StepObjects.LoginSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureConfig.class)
@Epic("Credo Bank Front-End Task")
@Feature("Login Negative Test Cases")
public class CredoBankLoginNegativeUITests extends BrowserConfigurations {
    LoginSteps loginSteps = new LoginSteps(driver);
    LanguageSteps languageSteps = new LanguageSteps(driver);
    @Story("Try to login when user forgets to write credentials")
    @Description("Negative scenario")
    @Test()
    public void tryToLoginWithoutCredentials() {
        loginSteps.assertLoginButtonIsDisabled();
    }
}
