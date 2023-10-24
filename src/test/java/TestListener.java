import com.aventstack.extentreports.Status;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestSuccess(ITestResult result) {
        BaseTest.extent.createTest(result.getName())
                .log(Status.PASS, result.getMethod().getMethodName())
                .info(result.getMethod().getDescription());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        BaseTest.takeScreenshot(result.getName());
        BaseTest.extent.createTest(result.getName())
                .log(Status.FAIL, result.getThrowable())
                .addScreenCaptureFromPath("../reports/screenshots/" + result.getName() + ".png")
                .info(result.getMethod().getDescription());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        BaseTest.extent.createTest(result.getName())
                .log(Status.SKIP, result.getTestName())
                .info(result.getMethod().getDescription());
    }
}
