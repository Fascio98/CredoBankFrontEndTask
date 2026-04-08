package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    protected WebDriver webDriver;
    public By userNameField = By.id("userName");
    public By passwordField = By.id("newPass");
    public By loginButton = By.id("submitAuth");
    public By languageSwitcherButton = By.id("languageSwitcherBtn");
    public By wrongCredentialsNotification = By.xpath("//p[@id='growlText']");
    public By notificationXButton = By.xpath("//div[contains(@class, 'icon white-010 close pointer')]");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
