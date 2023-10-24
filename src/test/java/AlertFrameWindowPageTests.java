import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners(TestListener.class)
public class AlertFrameWindowPageTests extends BaseTest {

    @Test(description = "Switches from one tab to another.")
    void shouldSwitchBetweenTabs() {
        var browserWindowsPage = homePage.clickAlertFrameWindow().openBrowserWindowsPage();
        browserWindowsPage.clickOnNewTabButton();
        getWindowManager().goToSpecifiedTab(1);
        getWindowManager().switchToTab("DEMOQA");

        assertEquals(browserWindowsPage.getTabTitle(), "DEMOQA",
                "The tab title is incorrect.");
    }

    @Test(description = "Confirms with OK in a popup box with the message.")
    void shouldTriggerConfirmAlertAndAccept() {
        var alertsPage = homePage.clickAlertFrameWindow().openAlertsPage();

        alertsPage.triggerConfirmButton();
        assertEquals(alertsPage.getAlertText(), "Do you confirm action?",
                "The alert message is incorrect.");

        alertsPage.alertClickToAccept();
        assertEquals(alertsPage.getConfirmResult(), "You selected Ok",
                "The result message after accepting an confirm alert is incorrect.");
    }

    @Test(description = "Confirms with OK in a popup box after sending a prompt.")
    void shouldTriggerPromptAlertAndSendPrompt() {
        String prompt = "Harry Potter";
        var alertsPage = homePage.clickAlertFrameWindow().openAlertsPage();

        alertsPage.triggerPromptButton();

        alertsPage.clickToSendPrompt(prompt);
        alertsPage.alertClickToAccept();

        assertEquals(alertsPage.getPromptResult(), "You entered " + prompt,
                "The result message after accepting an prompt alert is incorrect.");
    }
}
