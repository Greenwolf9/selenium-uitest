package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends HomePage {

    private final By userEmail = By.id("userEmail");
    private final By submitButton = By.id("submit");
    private final By submittedEmail = By.id("email");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmailField(String email) {
        driver.findElement(userEmail).sendKeys(email);
    }

    public String confirmSubmit() {
        clickOnElement(submitButton);
        return driver.findElement(submittedEmail).getText();
    }
}
