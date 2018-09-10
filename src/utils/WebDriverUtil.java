package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtil {

    WebDriver driver;

    public final static String CHROME = "chrome";
    public final static String IE = "IE";
    public final static String FIREFOX = "firefox";

    private final static String CHROME_DRIVER_PATH = "webdrivers\\chromedriver.exe";

    public WebDriverUtil() {

    }

    public WebDriver initWebDriver(String browser) {
        switch(browser) {
            case CHROME:
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            case IE:
                break;
            case FIREFOX:
                break;
        }
        return driver;
    }
}
