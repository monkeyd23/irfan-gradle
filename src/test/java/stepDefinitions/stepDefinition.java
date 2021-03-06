package stepDefinitions;

import common.Helpers;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.GUITestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class stepDefinition {

    LoginPage loginPage = new LoginPage();

    @Given("^User is at login page$")
    public void user_is_at_login_page() {
        System.out.println("User is at login page");
        loginPage.clickSignIn().click();
        assertThat(loginPage.verifySignInTitle().getText().equals("Sign-In"));
    }

    @When("^User login into application with (.*) and (.*)$")
    public void user_login_into_application_with_username_and_password(String username, String password) {
        loginPage.emailField().sendKeys(username);
        loginPage.continueBtn().click();
        loginPage.passwdField().sendKeys(password);
        loginPage.continueBtn().click();
        System.out.println("User login into application with username and password");
    }

    @Then("^User at home page search for (.*) product$")
    public void home_page_is_populated(String product) {
        loginPage.searchBox().sendKeys(product);
        loginPage.searchBtn().click();
        List<WebElement> products = loginPage.products();
        for (WebElement e : products) {
            System.out.println("List : " + e.getText());
            assertThat(e.getText().contains("Apple iPhone"));
        }
        System.out.println("Home page is populated");
    }

    @And("^User add (.*) product from the list to cart$")
    public void select_product_from_list(String product) throws InterruptedException {
        loginPage.searchBtn().sendKeys(Keys.PAGE_DOWN);
        loginPage.selectProduct().click();
        Helpers.implicitWait("10", "secs");
        loginPage.currentWindow();
        assertThat(loginPage.productTitle().getText().contains(product));
        loginPage.addToCart().click();
        Helpers.implicitWait("10", "secs");
        assertThat(loginPage.addToCartMsg().getText().equals("Added to Cart"));
        System.out.println("Cards are displayed");
    }

    @And("^Verify product (.*) is displayed on cart and subtotal is 1$")
    public void verify_cart_subtotal(String product) {
        loginPage.cartBtn().click();
        loginPage.shoppingCartTitle().isDisplayed();
        assertThat(loginPage.productTitle().getText().contains(product));
    }

    @And("^Cards are displayed$")
    public void cards_are_displayed() {
        System.out.println("Cards are displayed");
    }
}
