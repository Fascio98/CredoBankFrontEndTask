package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    protected WebDriver webDriver;
    public final By userNameField = By.id("userName");
    public final By passwordField = By.id("newPass");
    public final By loginButton = By.id("submitAuth");
    public final By languageSwitcherButton = By.id("languageSwitcherBtn");
    public final By wrongCredentialsNotification = By.xpath("//p[@id='growlText']");
    public final By notificationXButton = By.xpath("//div[contains(@class, 'icon white-010 close pointer')]");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
