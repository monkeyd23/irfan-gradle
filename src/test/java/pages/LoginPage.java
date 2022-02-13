package pages;

import managers.GUITestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage() {
        this.driver = GUITestBase.getDriver();
    }

    By SIGN_IN = By.xpath("//*[@id='nav-link-accountList']");
    By SIGN_IN_TITLE = By.xpath("//*[@class='a-spacing-small']");
    By EMAIL_FIELD = By.xpath("//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']");
    By CONTINUE_BTN = By.xpath("//input[@class='a-button-input']");
    By PASSWD_FIELD = By.xpath("//input[@class='a-input-text a-span12 auth-autofocus auth-required-field']");
    By SEARCH_BOX = By.id("twotabsearchtextbox");
    By SEARCH_BTN = By.id("nav-search-submit-button");
    By PRODUCTS = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
    By SELECT_PRODUCT = By.xpath("//span[contains(text(),'Apple iPhone XR (64GB)')]");
    By PRODUCT_TITLE = By.id("productTitle");
    By ADD_TO_CART = By.id("add-to-cart-button");
    By ADD_TO_CART_MSG = By.xpath("//div[@id='attach-added-to-cart-message']//h4[@class='a-alert-heading']");
    By CART_BTN = By.xpath("//span[text()=' Cart ']");
    By SHOPPING_CART_TITLE = By.xpath("//h1[contains(text(),'Shopping Cart')]");

    public WebElement clickSignIn() {
        return driver.findElement(SIGN_IN);
    }

    public WebElement verifySignInTitle() {
        return driver.findElement(SIGN_IN_TITLE);
    }

    public WebElement emailField() {
        return driver.findElement(EMAIL_FIELD);
    }

    public WebElement continueBtn() {
        return driver.findElement(CONTINUE_BTN);
    }

    public WebElement passwdField() {
        return driver.findElement(PASSWD_FIELD);
    }

    public WebElement searchBox() {
        return driver.findElement(SEARCH_BOX);
    }

    public WebElement searchBtn() {
        return driver.findElement(SEARCH_BTN);
    }

    public List<WebElement> products() {
        return driver.findElements(PRODUCTS);
    }

    public WebElement selectProduct() {
        return driver.findElement(SELECT_PRODUCT);
    }

    public WebElement productTitle() {
        return driver.findElement(PRODUCT_TITLE);
    }

    public WebElement addToCart() {
        return driver.findElement(ADD_TO_CART);
    }

    public WebElement addToCartMsg() {
        return driver.findElement(ADD_TO_CART_MSG);
    }

    public WebElement cartBtn() {
        return driver.findElement(CART_BTN);
    }

    public WebElement shoppingCartTitle() {
        return driver.findElement(SHOPPING_CART_TITLE);
    }

    public void currentWindow() {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }
}
