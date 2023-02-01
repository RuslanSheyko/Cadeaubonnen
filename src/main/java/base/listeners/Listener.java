package base.listeners;

import base.driver.InitialDriver;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
/**
 * Listener for handling events and different test steps in TestNG
 */
@Slf4j
public class Listener implements ITestListener, ISuiteListener, IInvokedMethodListener {

    /**
     * Actions on successful completion of the test
     */
    @Override
    public void onTestSuccess(ITestResult arg0) {
        log.info("Test finished... " + arg0.getName() + " SUCCESS");

    }

    /**
     * Actions when test fails
     */
    @Override
    public void onTestFailure(ITestResult arg0) {
        log.info("Test finished... " + arg0.getName() + " FAILED");
        takeScreenshot(InitialDriver.getInstance().getDriver());
        InitialDriver.getInstance().destroy();
    }

    /**
     * Actions when starting the test
     */
    @Override
    public void onTestStart(ITestResult arg0) {

        log.info("\nTest started... " + arg0.getName() + "\n");
    }

    /**
     * Skip test actions
     */
    @Override
    public void onTestSkipped(ITestResult arg0) {
        log.info("Test finished... " + arg0.getName() + " SKIPPED");
    }

    /**
     * Actions when the test fails but with a lot of successful steps
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
        log.info("Test finished... " + arg0.getName() + " BROKEN");
        takeScreenshot(InitialDriver.getInstance().getDriver());

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        InitialDriver.getInstance().destroy();
    }

    /**
     * Taking a screenshot and attaching it to AllureReport
     */
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void onStart(ISuite iSuite) {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", "Chrome")
                        .put("Browser.Version", "70.0.3538.77")
                        .put("URL", "http://testjs.site88.net")
                        .build());

    }

    @Override
    public void onFinish(ISuite iSuite) {
        InitialDriver.getInstance().destroy();
    }
}