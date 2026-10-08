package framework.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.utils.ConfigReader;
import framework.utils.ScreenshotUtils;

public class BaseTest {

    protected WebDriver driver;

    protected Logger logger =
            LogManager.getLogger(
                    this.getClass()
            );

    @SuppressWarnings("null")
    @BeforeMethod
    public void setUp() {

        logger.info("Starting test setup");

        driver =
                DriverFactory.createDriver();

        String baseUrl =
                ConfigReader.getProperty(
                        "baseUrl"
                );

        logger.info(
                "Opening application: {}",
                baseUrl
        );

        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown(
            ITestResult result) {

        if (result.getStatus()
                == ITestResult.FAILURE) {

            logger.error(
                    "Test failed: {}",
                    result.getName()
            );

            ScreenshotUtils.captureScreenshot(
                    driver,
                    result.getName()
            );
        }

        if (driver != null) {

            logger.info(
                    "Closing browser"
            );

            driver.quit();
        }
    }
}