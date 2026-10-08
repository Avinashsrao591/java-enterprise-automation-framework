package pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.utils.WaitUtils;
import io.qameta.allure.Step;
@SuppressWarnings("unused")
public class LoginPage {

    private WebDriver driver;

    private WaitUtils waitUtils;
 private Logger logger =
            LogManager.getLogger(
                    LoginPage.class
            );
    private By username =
            By.id("user-name");

    private By password =
            By.id("password");

    private By loginButton =
            By.id("login-button");

    public LoginPage(WebDriver driver) {

        this.driver = driver;

        this.waitUtils =
                new WaitUtils(driver);
    }

    @Step("Enter username")
public void enterUsername(
        String usernameValue) {

    logger.info(
            "Entering username: {}",
            usernameValue
    );

    waitUtils
            .waitForElement(username)
            .sendKeys(usernameValue);
}

    @Step("Enter password")
public void enterPassword(
        String passwordValue) {

    logger.info(
            "Entering password"
    );

    waitUtils
            .waitForElement(password)
            .sendKeys(passwordValue);
}

    @SuppressWarnings("null")
    @Step("Click Login button")
public void clickLogin() {

    logger.info(
            "Clicking Login button"
    );

    waitUtils
            .waitForElementToBeClickable(
                    loginButton
            );

    driver.findElement(
            loginButton
    ).click();
}

    public void login(
            String usernameValue,
            String passwordValue) {

        enterUsername(usernameValue);

        enterPassword(passwordValue);

        clickLogin();
    }

    @SuppressWarnings("null")
    public boolean isInventoryPageDisplayed() {

        waitUtils.waitForUrlContains(
                "inventory.html"
        );

    return true;
}
    }
