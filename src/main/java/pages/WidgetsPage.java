package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WidgetsPage extends HomePage {

    private final By autoComplete = By.xpath("(//*[@id='item-1'])[3]");
    private final By datePicker = By.xpath("(//*[@id='item-2'])[3]");
    private final By menu = By.xpath("(//*[@id='item-7'])[2]");


    public WidgetsPage(WebDriver driver) {
        super(driver);
    }

    public AutoCompletePage openAutoCompletePage() {
        clickOnElement(autoComplete);
        return new AutoCompletePage(driver);
    }

    public MenuPage openMenuPage() {
        clickOnElement(menu);
        return new MenuPage(driver);
    }

    public DatePicker openDatePickerPage() {
        clickOnElement(datePicker);
        return new DatePicker(driver);
    }
}
