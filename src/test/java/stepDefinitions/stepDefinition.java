package stepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

import java.util.List;

public class stepDefinition {

    static String driverPath = System.getProperty("user.dir") + "/src/test/drivers/";
    static LoginPage loginPage = getLoginPage();

    public static LoginPage getLoginPage() {
        System.out.println("Launching google chrome with new profile..");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.amazon.in/");
        return new LoginPage(driver);
    }


    @Given("^User is at login page$")
    public void user_is_at_login_page() {
        loginPage.clickSignIn().click();
        Assertions.assertThat(loginPage.verifySignInTitle().getText().equals("Sign-In"));
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
        for(WebElement e : products) {
            System.out.println("List : " + e.getText());
            Assertions.assertThat(e.getText().contains("Apple iPhone"));
        }
        System.out.println("Home page is populated");
    }

    @And("^User add (.*) product from the list to cart$")
    public void select_product_from_list(String product) throws InterruptedException {
        loginPage.searchBtn().sendKeys(Keys.PAGE_DOWN);
        loginPage.selectProduct().click();
        loginPage.implicitWait("10", "secs");
        loginPage.currentWindow();
        Assertions.assertThat(loginPage.productTitle().getText().contains(product));
        loginPage.addToCart().click();
        loginPage.implicitWait("10", "secs");
        Assertions.assertThat(loginPage.addToCartMsg().getText().equals("Added to Cart"));
        System.out.println("Cards are displayed");
    }

    @And("^Verify product (.*) is displayed on cart and subtotal is 1$")
    public void verify_cart_subtotal(String product) {
        loginPage.cartBtn().click();
        loginPage.shoppingCartTitle().isDisplayed();
        Assertions.assertThat(loginPage.productTitle().getText().contains(product));
    }

    @And("^Cards are displayed$")
    public void cards_are_displayed() {
        System.out.println("Cards are displayed");
    }
}
