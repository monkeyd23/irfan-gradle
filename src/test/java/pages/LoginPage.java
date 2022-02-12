package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By SIGN_IN = By.xpath("//*[@id='nav-link-accountList']");
    public By SIGN_IN_TITLE = By.xpath("//*[@class='a-spacing-small']");

    public WebElement clickSignIn() {
        return driver.findElement(SIGN_IN);
    }

    public WebElement verifySignInTitle() {
        return driver.findElement(SIGN_IN_TITLE);
    }

}
