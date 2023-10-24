package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker extends HomePage{

    private final By datePickerMonthYearInput = By.id("datePickerMonthYearInput");
    private final By monthSelect = By.className("react-datepicker__month-select");
    public DatePicker(WebDriver driver) {
        super(driver);
    }


    public void pickDate(String month, String date) {
        clickOnElement(datePickerMonthYearInput);
        selectDropdownOption(month);
        clickOnElement(By.xpath("//*[text()='"+date+"']"));
    }

    private void selectDropdownOption(String option) {
        findDropdownElement().selectByVisibleText(option);
    }

    private Select findDropdownElement() {
        return new Select(driver.findElement(monthSelect));
    }

    public String getDate() {
        return driver.findElement(datePickerMonthYearInput).getAttribute("value");
    }
}
