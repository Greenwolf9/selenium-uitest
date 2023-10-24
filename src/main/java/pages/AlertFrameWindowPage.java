package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertFrameWindowPage extends HomePage {

    private final By browserWindows = By.xpath("(//*[@id='item-0'])[3]");
    private final By alerts = By.xpath("(//*[@id='item-1'])[2]");

    public AlertFrameWindowPage(WebDriver driver) {
        super(driver);
    }

    public BrowserWindowsPage openBrowserWindowsPage() {
        clickOnElement(browserWindows);
        return new BrowserWindowsPage(driver);
    }

    public AlertsPage openAlertsPage() {
        clickOnElement(alerts);
        return new AlertsPage(driver);
    }
}
