import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class InteractionsPageTests extends BaseTest {

    @Test(description = "Sorts elements in reversed order.")
    void shouldMoveElementUp() {
        var sortablePage = homePage.clickInteractions().openInteractionsPage();
        sortablePage.holdAndMoveUp(2);
        sortablePage.holdAndMoveUp(3);
        sortablePage.holdAndMoveUp(4);
        sortablePage.scrollDown();
        sortablePage.holdAndMoveUp(5);
        sortablePage.scrollDown();
        sortablePage.holdAndMoveUp(6);

        assertEquals(sortablePage.getListOfSortedElements(),
                List.of("Six", "Five", "Four", "Three", "Two", "One"),
                "The elements are sorted incorrectly.");
    }

    @Test(description = "Resizes a box to the larger size.")
    void shouldResizeBoxToSize() {
        var resizablePage = homePage.clickInteractions().openResizablePage();
        resizablePage.resizeBox(200, 50);
        assertEquals(resizablePage.getBoxSize(), "width: 400px; height: 250px;", "The box size is incorrect.");
    }
}
