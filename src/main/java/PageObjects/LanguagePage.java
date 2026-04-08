package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LanguagePage {
    protected WebDriver webDriver;
    public By georgianLanguage = By.xpath("//div[@class='sub-language'][1]");
    public By megrelianLanguage = By.xpath("//div[@class='sub-language'][2]");
    public By svanLanguage = By.xpath("//div[@class='sub-language'][3]");

    public LanguagePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
