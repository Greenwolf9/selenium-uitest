import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.HomePage;
import utils.Links;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {

    private static WebDriver driver;
    protected HomePage homePage;
    public ExtentSparkReporter spark;
    public static ExtentReports extent;


    @BeforeSuite
    void initReporter() {
        spark = new ExtentSparkReporter("reports/" + "TestAutomationReport.html");
        spark.config().setDocumentTitle("Test Automation Report");
        spark.config().setEncoding("utf-8");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }


    void setUpDriver(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
    }

    @BeforeMethod
    @Parameters(value = {"browser"})
    void goHome(String browser, Method method) {
        setUpDriver(browser);
        driver.get(Links.HOME);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    public static void takeScreenshot(String name) {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShot, new File("reports/screenshots/" + name + ".png"));
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }


    @AfterSuite
    void flush() {
        extent.flush();
    }
}
