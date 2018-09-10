package pages.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    // Constants
    private final static String BASE_URL = "https://www.ruralsourcing.com/";
    // Driver
    WebDriver driver;
    WebDriverWait wait;
    // Elements
    @FindBy(linkText = "CAREERS")
    WebElement careersButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public void goTo() {
        driver.get(BASE_URL);
    }

    public void clickCareersButton() {
        wait.until(ExpectedConditions.visibilityOf(careersButton));
        careersButton.click();
    }
}
