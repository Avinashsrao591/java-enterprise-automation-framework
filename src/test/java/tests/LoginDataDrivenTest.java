package tests;

import framework.base.BaseTest;
import framework.utils.TestDataReader;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginDataDrivenTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][] {

            {
                TestDataReader.getProperty(
                        "standard.username"
                ),

                TestDataReader.getProperty(
                        "standard.password"
                )
            },

            {
                TestDataReader.getProperty(
                        "problem.username"
                ),

                TestDataReader.getProperty(
                        "problem.password"
                )
            },

            {
                TestDataReader.getProperty(
                        "performance.username"
                ),

                TestDataReader.getProperty(
                        "performance.password"
                )
            }
        };
    }

    @Test(
            dataProvider = "loginData",
    groups = {"regression"}
)

    public void validLoginTest(
            String username,
            String password) {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                username,
                password
        );

        Assert.assertTrue(
                loginPage.isInventoryPageDisplayed(),
                "Inventory page was not displayed for user: "
                        + username
        );
    }
}