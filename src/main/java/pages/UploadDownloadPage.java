package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadDownloadPage extends HomePage{

    private final By uploadFile = By.id("uploadFile");
    private final By uploadedFilePath = By.id("uploadedFilePath");

    public UploadDownloadPage(WebDriver driver) {
        super(driver);
    }

    public String uploadFile(String path) {
        driver.findElement(uploadFile).sendKeys(path);
        return driver.findElement(uploadedFilePath).getText();
    }
}
