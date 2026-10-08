package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrowserTest {

    @Test
    public void openGoogleTest() {

        // Create Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open Google
        driver.get("https://www.google.com");

        // Get page title
        String actualTitle = driver.getTitle();

        System.out.println("Page Title: " + actualTitle);

        // Verify title
        Assert.assertEquals(
                actualTitle,
                "Google"
        );

        // Close browser
        driver.quit();
    }
}