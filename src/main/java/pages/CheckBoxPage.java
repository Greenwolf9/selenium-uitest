package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBoxPage extends HomePage{

    private final By toggle = By.xpath("//*[contains(@aria-label, 'Expand all')]");
    private final By desktop = By.id("tree-node-desktop");
    private final By result = By.id("result");
    public CheckBoxPage(WebDriver driver) {
        super(driver);
    }

    public void expandAll() {
        clickOnElement(toggle);
    }

    public void checkDesktopBox() {
        clickOnElement(desktop);
    }

    public String getResultAfterCheckDesktopBox() {
        return driver.findElement(result).getText();
    }

}
