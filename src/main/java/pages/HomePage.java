package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class HomePage {

    protected WebDriver driver;
    private final By elements = By.xpath("(//*[@class='card mt-4 top-card'])[1]");
    private final By alertFrameWindow = By.xpath("(//*[@class='card mt-4 top-card'])[3]");
    private final By widgets = By.xpath("(//*[@class='card mt-4 top-card'])[4]");
    private final By interactions = By.xpath("(//*[@class='card mt-4 top-card'])[5]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ElementsPage clickElements() {
        clickOnElement(elements);
        return new ElementsPage(driver);
    }

    public AlertFrameWindowPage clickAlertFrameWindow() {
        clickOnElement(alertFrameWindow);
        return new AlertFrameWindowPage(driver);
    }

    public WidgetsPage clickWidgets() {
        clickOnElement(widgets);
        return new WidgetsPage(driver);
    }

    public InteractionsPage clickInteractions() {
        clickOnElement(interactions);
        return new InteractionsPage(driver);
    }

    public void clickOnElement(By element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(element));
    }

    public void waitUntilVisible(By element) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(
                driver.findElement(element)));
    }
}
