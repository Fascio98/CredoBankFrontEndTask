import StepObjects.LanguageSteps;
import StepObjects.LoginSteps;
import Configurations.AllureConfig;
import Configurations.BrowserConfigurations;
import Utils.DataProviderImplementation;
import Utils.RandomStringGenerator;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.*;

@Listeners({AllureConfig.class})
@Epic("Credo Bank Front-End Task")
@Feature("Login Negative Test Cases")
public class CredoBankLoginNegativeUITests extends BrowserConfigurations {
    private LoginSteps loginSteps;
    private LanguageSteps languageSteps;
    private final RandomStringGenerator randomStringGenerator = new RandomStringGenerator();

    @BeforeClass
    public void setUp() {
        loginSteps = new LoginSteps(driver);
        languageSteps = new LanguageSteps(driver);
    }

    @BeforeMethod
    public void beforeEachTest(java.lang.reflect.Method method, Object[] parameters) {
//        Sometimes third test is failing because of some automation error and that's why I needed to refresh page
        driver.navigate().refresh();
        
        if (parameters != null && parameters.length > 0) {
            String language = (String) parameters[0];  // extracted from DataProvider
            loginSteps.clickLanguageSwitcherButton();
            languageSteps.clickCustomLanguage(language);
        }
    }

    @Story("Try to login when user forgets to write credentials")
    @Description("Negative scenario")
    @Test(dataProvider = "languages", dataProviderClass = DataProviderImplementation.class)
    @SuppressWarnings("unused") // language parameter is used by @BeforeMethod
    public void tryToLoginWithoutCredentials(String language) {
        loginSteps.assertLoginButtonIsDisabled();
        loginSteps.assertAll();
    }

    @Story("Try to login when user writes username but forgets password")
    @Description("Negative scenario")
    @Test(priority = 1, dataProvider = "languages", dataProviderClass = DataProviderImplementation.class)
    @SuppressWarnings("unused") // language parameter is used by @BeforeMethod
    public void tryToLoginWithOnlyUsername(String language) {
        String username = randomStringGenerator.generateUsername();
        loginSteps
                .fillUsernameField(username)
                .assertLoginButtonIsDisabled();
        loginSteps.assertAll();
    }

    @Story("Try to login when user writes password but forgets username")
    @Description("Negative scenario")
    @Test(priority = 2, dataProvider = "languages", dataProviderClass = DataProviderImplementation.class)
    @SuppressWarnings("unused") // language parameter is used by @BeforeMethod
    public void tryToLoginWithOnlyPassword(String language) {
        String password = randomStringGenerator.generatePassword();
        loginSteps
                .fillPasswordField(password)
                .assertLoginButtonIsDisabled();
        loginSteps.assertAll();
    }

    @Story("Try to login when user writes incorrect credentials")
    @Description("Negative scenario")
    @Test(priority = 3, dataProvider = "languages", dataProviderClass = DataProviderImplementation.class)
    public void tryToLoginWithIncorrectCredentials(String language) {
        String username = randomStringGenerator.generateUsername();
        String password = randomStringGenerator.generatePassword();
        
        loginSteps
                .fillUsernameField(username)
                .fillPasswordField(password)
                .clickLoginButton()
                .assertCredentialsAreWrong(language);

        loginSteps.assertAll();
        loginSteps.closeAnyNotificationIfItsOpened();
    }
}
