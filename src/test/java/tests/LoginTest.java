package tests;

import framework.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.CartPage;
import io.qameta.allure.Step;
@SuppressWarnings("unused")
public class LoginTest extends BaseTest {

   @Test(groups = {"smoke", "regression"})
public void validLoginAndAddProductToCartTest(){

        // Login
        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        // Products page
        ProductsPage productsPage =
                new ProductsPage(driver);

        Assert.assertTrue(
                productsPage.isProductsPageDisplayed(),
                "Products page was not displayed"
        );

        // Add product
        productsPage.addBackpackToCart();

        // Open cart
        productsPage.openCart();

        // Verify cart
        CartPage cartPage =
                new CartPage(driver);

        Assert.assertTrue(
                cartPage.isProductInCart(
                        "Sauce Labs Backpack"
                ),
                "Sauce Labs Backpack was not found in the cart"
        );
    }
}