package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MenuPage extends HomePage {

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverMenuItems(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).perform();
    }
}
