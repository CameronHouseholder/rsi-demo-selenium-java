package pages.careers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareersPage {
    // Driver
    WebDriver driver;
    WebDriverWait wait;
    // Elements
    @FindBy(linkText = "OPEN POSITIONS")
    WebElement openPositionsButton;

    public CareersPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public void clickOpenPositionsButton() {
        wait.until(ExpectedConditions.visibilityOf(openPositionsButton));
        openPositionsButton.click();
    }
}
