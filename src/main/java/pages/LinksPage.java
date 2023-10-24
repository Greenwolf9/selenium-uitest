package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LinksPage extends HomePage {

    private final By dynamicLink = By.id("dynamicLink");

    public LinksPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLink() {
        clickOnElement(dynamicLink);
    }
}
