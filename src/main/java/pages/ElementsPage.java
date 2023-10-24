package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends HomePage{
    private final By textBox = By.id("item-0");
    private final By checkBox = By.id("item-1");
    private final By links = By.id("item-5");

    private final By upDownLoad = By.id("item-7");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public TextBoxPage openTextBoxPage() {
        clickOnElement(textBox);
        return new TextBoxPage(driver);
    }

    public CheckBoxPage openCheckBoxPage() {
        clickOnElement(checkBox);
        return new CheckBoxPage(driver);
    }

    public UploadDownloadPage openUploadDownloadPage() {
        clickOnElement(upDownLoad);
        return new UploadDownloadPage(driver);
    }

    public LinksPage openLinksPage() {
        clickOnElement(links);
        return new LinksPage(driver);
    }
}
