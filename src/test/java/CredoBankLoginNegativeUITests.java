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

@Listeners(AllureConfig.class)
@Epic("Credo Bank Front-End Task")
@Feature("Login Negative Test Cases")
public class CredoBankLoginNegativeUITests extends BrowserConfigurations {
    LoginSteps loginSteps;
    LanguageSteps languageSteps;
    RandomStringGenerator randomStringGenerator;

    @BeforeClass
    public void setUp() {
        loginSteps = new LoginSteps(driver);
        languageSteps = new LanguageSteps(driver);
        randomStringGenerator = new RandomStringGenerator();
    }

    @BeforeMethod
    public void beforeEachTest(Object[] testData) {
        String language = (String) testData[0];  // extracted from DataProvider
        loginSteps.clickLanguageSwitcherButton();
        languageSteps.clickCustomLanguage(language);
    }

    @Story("Try to login when user forgets to write credentials")
    @Description("Negative scenario")
    @Test(dataProvider = "languages", dataProviderClass = DataProviderImplementation.class)
    public void tryToLoginWithoutCredentials(String language) {
        loginSteps.assertLoginButtonIsDisabled();
    }

    @Story("Try to login when user writes username but forgets password")
    @Description("Negative scenario")
    @Test(priority = 1, dataProvider = "languages", dataProviderClass = DataProviderImplementation.class)
    public void tryToLoginWithOnlyUsername(String language) {
        loginSteps
                .fillUsernameField(randomStringGenerator.generateUsername())
                .assertLoginButtonIsDisabled();
    }

    @Story("Try to login when user writes password but forgets username")
    @Description("Negative scenario")
    @Test(priority = 2, dataProvider = "languages", dataProviderClass = DataProviderImplementation.class)
    public void tryToLoginWithOnlyPassword(String language) {
        loginSteps
                .fillPasswordField(randomStringGenerator.generatePassword())
                .assertLoginButtonIsDisabled();
    }

    @Story("Try to login when user writes incorrect credentials")
    @Description("Negative scenario")
    @Test(priority = 3, dataProvider = "languages", dataProviderClass = DataProviderImplementation.class)
    public void tryToLoginWithIncorrectCredentials(String language) {
        loginSteps
                .fillUsernameField(randomStringGenerator.generateUsername())
                .fillPasswordField(randomStringGenerator.generatePassword())
                .clickLoginButton()
                .assertCredentialsAreWrong(language);

        // After Assertion

        loginSteps
                .closeAnyNotificationIfItsOpened();
    }

    @AfterMethod
    public void cleanUp() {
        loginSteps
                .clearUsernameField()
                .clearPasswordField();
    }
}
