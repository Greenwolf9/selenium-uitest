import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
@Listeners(TestListener.class)
public class WidgetsPageTests extends BaseTest {

    @Test(description = "Auto completes the color name by one letter.")
    void shouldAutoCompleteColorByOneLetter() {
        String[] letters = {"y", "m", "g"};
        var autoCompletePage = homePage.clickWidgets().openAutoCompletePage();

        List<String> colors = autoCompletePage.getListAutoCompletedColors(letters);

        assertEquals(colors, List.of("Yellow", "Magenta", "Green"), "The result of auto complete is incorrect.");
    }

    @Test(description = "Hovers over menu and expands it.")
    void shouldHoverOverMenuItems() {
        var menuPage = homePage.clickWidgets().openMenuPage();
        menuPage.hoverOverMenuItems(By.linkText("Main Item 2"));
        menuPage.hoverOverMenuItems(By.linkText("SUB SUB LIST »"));
    }

    @Test(description = "Picks the specified date in the opened calender.")
    void shouldPickDate() {
        var datePicker = homePage.clickWidgets().openDatePickerPage();
        datePicker.pickDate("March", "1");
        assertEquals(datePicker.getDate(), "03/01/2023", "The selected date is incorrect.");
    }

}
