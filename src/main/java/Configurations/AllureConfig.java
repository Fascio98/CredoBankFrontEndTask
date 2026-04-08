package Configurations;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureConfig extends BrowserConfigurations implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(BrowserConfigurations.getWebDriver());
        saveLogs(result.getMethod().getConstructorOrMethod().getName());
    }

    @Attachment(value = "Screenshot", type = "image/png")
    @SuppressWarnings("unused") // Return value is used by @Attachment annotation
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Stacktrace", type = "text/plain")
    @SuppressWarnings("unused") // Return value is used by @Attachment annotation
    public static String saveLogs(String message) {
        return message;
    }
}
