package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;


public class AutoCompletePage extends HomePage {
    private final By autoCompleteMultipleInput = By.id("autoCompleteMultipleInput");
    private final By outOfInputBox = By.id("autoCompleteContainer");
    private final By autoCompletedOption = By.id("autoCompleteMultipleContainer");

    public AutoCompletePage(WebDriver driver) {
        super(driver);
    }

    public List<String> getListAutoCompletedColors(String[] letters)  {
        List<String> colors = new ArrayList<>();
        Actions action = new Actions(driver);
        int i = 1;
        for (String letter : letters) {
            action.sendKeys(driver.findElement(autoCompleteMultipleInput), letter)
                    .moveToElement(driver.findElement(outOfInputBox))
                    .sendKeys(Keys.RETURN)
                    .perform();
            String[] element = driver.findElement(autoCompletedOption).getText().split("\n");
            colors.add(element[i++]);

        }
        return colors;
    }
}
