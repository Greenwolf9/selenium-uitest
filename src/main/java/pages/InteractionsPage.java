package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InteractionsPage extends HomePage{

    private final By sortable = By.xpath("(//*[@id='item-0'])[5]");
    private final By resizable = By.xpath("(//*[@id='item-2'])[4]");
    public InteractionsPage(WebDriver driver) {
        super(driver);
    }
    public SortablePage openInteractionsPage() {
        clickOnElement(sortable);
        return new SortablePage(driver);
    }

    public ResizablePage openResizablePage() {
        clickOnElement(resizable);
        return new ResizablePage(driver);
    }

}
