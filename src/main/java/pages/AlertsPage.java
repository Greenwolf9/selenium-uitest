package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage extends HomePage {

    private final By confirmButton = By.id("confirmButton");
    private final By promptButton = By.id("promtButton");
    private final By confirmResult = By.id("confirmResult");
    private final By promptResult = By.id("promptResult");

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    public void triggerConfirmButton() {
        clickOnElement(confirmButton);
    }

    public void triggerPromptButton() {
        clickOnElement(promptButton);
    }

    public void alertClickToAccept() {
        driver.switchTo().alert().accept();
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public String getConfirmResult() {
        return driver.findElement(confirmResult).getText();
    }

    public void clickToSendPrompt(String prompt) {
        driver.switchTo().alert().sendKeys(prompt);
    }

    public String getPromptResult() {
        return driver.findElement(promptResult).getText();
    }
}
