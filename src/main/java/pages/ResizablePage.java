package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ResizablePage extends HomePage{

    private final By resizableBox = By.xpath("//span[@class = 'react-resizable-handle react-resizable-handle-se']");
    private final By box = By.id("resizableBoxWithRestriction");
    public ResizablePage(WebDriver driver) {
        super(driver);
    }

    public void resizeBox(int x, int y) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(resizableBox))
                .moveByOffset(x, y)
                .pause(Duration.ofSeconds(1))
                .release().build().perform();
    }

    public String getBoxSize() {
        return driver.findElement(box).getAttribute("style");
    }
}
