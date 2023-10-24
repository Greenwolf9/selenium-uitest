package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class SortablePage extends HomePage {

    private final By list = By.id("demo-tab-list");

    public SortablePage(WebDriver driver) {
        super(driver);
    }

    public void holdAndMoveUp(int index) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElementToDrag(index))
                .pause(Duration.ofMillis(500))
                .clickAndHold(findElementToDrag(index))
                .pause(Duration.ofMillis(500))
                .moveToElement(driver.findElement(list))
                .release().build().perform();
    }

    public List<String> getListOfSortedElements() {
        return driver.findElements(By.xpath("//*[@class='vertical-list-container mt-4']/div"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void scrollDown() {
        String script = "window.scrollTo(0,document.body.scrollHeight);";
        var jsDriver = (JavascriptExecutor) driver;
        jsDriver.executeScript(script);
    }

    private WebElement findElementToDrag(int index) {
        return driver.findElement(By.xpath("//*[@id= 'demo-tabpane-list']/div/div[" + index + "]"));
    }
}
