package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import framework.utils.WaitUtils;

@SuppressWarnings("unused")
public class CartPage {

    @SuppressWarnings("unused")
    private WebDriver driver;

    private WaitUtils waitUtils;

    private By cartItem =
            By.className("inventory_item_name");

    public CartPage(WebDriver driver) {

        this.driver = driver;

        this.waitUtils =
                new WaitUtils(driver);
    }

    public String getCartItemName() {

        return waitUtils
                .waitForElement(cartItem)
                .getText();
    }

    @Step("Verify product is present in cart")
public boolean isProductInCart(
        String expectedProduct) {

    return getCartItemName()
            .equals(expectedProduct);
}
}