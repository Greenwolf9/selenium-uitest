package utils;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowManager {

    private WebDriver driver;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
    }

    public void goForward() {
        driver.navigate().forward();
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void goTo(String url) {
        driver.navigate().to(url);
    }

    public String switchToTab(String title) {
        var windows = driver.getWindowHandles();

        for (String window : windows) {
            driver.switchTo().window(window);

            if (title.equals(driver.getTitle())) {
                break;
            }
        }
        return "Current window title: " + driver.getTitle();
    }

    public void goToSpecifiedTab(int number) {
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(number));
    }

    public int numberOfTabs() {
        return driver.getWindowHandles().size();
    }
}
