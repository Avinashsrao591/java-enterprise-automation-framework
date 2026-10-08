package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import framework.utils.WaitUtils;

@SuppressWarnings("unused")
public class ProductsPage {

    private WebDriver driver;

    private WaitUtils waitUtils;

    private By backpackAddToCart =
            By.id("add-to-cart-sauce-labs-backpack");

    private By cartIcon =
            By.className("shopping_cart_link");

    private By pageTitle =
            By.className("title");

    public ProductsPage(WebDriver driver) {

        this.driver = driver;

        this.waitUtils =
                new WaitUtils(driver);
    }

    public boolean isProductsPageDisplayed() {

        return waitUtils
                .waitForElement(pageTitle)
                .getText()
                .equals("Products");
    }

    @SuppressWarnings("null")
    @Step("Add Sauce Labs Backpack to cart")
public void addBackpackToCart() {

    waitUtils
            .waitForElementToBeClickable(
                    backpackAddToCart
            );

    driver.findElement(
            backpackAddToCart
    ).click();
}

    @SuppressWarnings("null")
    @Step("Open shopping cart")
public void openCart() {

    waitUtils
            .waitForElementToBeClickable(
                    cartIcon
            );

    driver.findElement(
            cartIcon
    ).click();
}
}