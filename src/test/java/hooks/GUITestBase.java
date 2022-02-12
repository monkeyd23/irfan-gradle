package hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Arrays;

public class GUITestBase {

    private WebDriver driver;
    static String driverPath = System.getProperty("user.dir") + "/src/test/drivers/";

    public WebDriver getDriver() {
        return driver;
    }

    public void initializeTestBaseSetup(String browserType, String appURL) {
        try {
            driver = "firefox".equals(browserType) ? initFirefoxDriver(appURL) : initChromeDriver(appURL);
        } catch (Exception e) {
            System.out.println("Error....." + Arrays.toString(e.getStackTrace()));
        }
    }

    private static WebDriver initChromeDriver(String appURL) {
        System.out.println("Launching google chrome with new profile..");
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }

    private static WebDriver initFirefoxDriver(String appURL) {
        System.out.println("Launching Firefox browser..");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.navigate().to(appURL);
        return driver;
    }


    public void tearDown() {
        driver.quit();
    }
}
