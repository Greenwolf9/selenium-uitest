import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class ElementsPageTests extends BaseTest {


    @Test(description = "Submits the form after filling in an email.")
    void shouldSubmitTextBoxForm() {
        String email = "elem@textbox.com";
        var textBoxForm = homePage.clickElements().openTextBoxPage();

        textBoxForm.fillEmailField(email);
        String actual = textBoxForm.confirmSubmit();

        assertEquals(actual, "Email:" + email, "The Text Box Form wasn't submitted.");
    }

    @Test(description = "Checks boxes.")
    void shouldPlaceCheckMark() {
        var checkBox = homePage.clickElements().openCheckBoxPage();

        checkBox.expandAll();
        checkBox.checkDesktopBox();
        String actual = checkBox.getResultAfterCheckDesktopBox();

        assertEquals(actual, "You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands", "The desktop box wasn't checked.");
    }


    @Test(description = "Uploads the specified file.")
    void shouldUploadFile() {
        var uploadDownload = homePage.clickElements().openUploadDownloadPage();

        String actual = uploadDownload.uploadFile("C:\\Users\\santa\\dev\\uitest\\file\\uploadTest.txt");
        assertEquals(actual, "C:\\fakepath\\uploadTest.txt", "The file hasn't been uploaded.");
    }

    @Test(description = "Retrieves the number of opened tabs.")
    void shouldRetrieveNumberOfOpenTabs() {
        var linkPage = homePage.clickElements().openLinksPage();
        linkPage.clickOnLink();

        assertEquals(getWindowManager().numberOfTabs(), 2, "The number of open tabs is incorrect.");
    }

    @Test(description = "Goes to another url and switches back.")
    void shouldSwitchBetweenTabsAndNavigate() {
        var linkPage = homePage.clickElements().openLinksPage();
        linkPage.clickOnLink();
        getWindowManager().goTo("https://duckduckgo.com/");
        String actual = getWindowManager().switchToTab("DEMOQA");

        assertEquals(actual, "Current window title: DEMOQA", "The current window title is incorrect.");
    }
}
