package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BrowserWindowsPage extends HomePage {

    private final By tabButton = By.id("tabButton");

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnNewTabButton() {
        clickOnElement(tabButton);
    }

    public String getTabTitle() {
        return driver.getTitle();
    }
}
