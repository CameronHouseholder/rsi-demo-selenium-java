package pages.careers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PositionsPage {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    // Elements
    @FindBy(id = "location")
    WebElement locationTextBox;
    @FindBy(xpath = "//button[contains(text(), 'Search')]")
    WebElement searchButton;
    @FindBy(id = "taleo-embed")
    WebElement taleoIframe;
    @FindBy(linkText = "Save")
    WebElement saveButton;
    @FindBy(linkText = "New Search")
    WebElement newSearchButton;
    By locationCheckboxes = By.className("oracletaleocwsv2-checkbox-wrapper");
    By searchResultRows = By.className("oracletaleocwsv2-accordion-head");


    public PositionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 20);
    }

    public void clickLocationTextBox() {
        // Switch to iFrame before moving the mouse to and clicking the element
        this.switchToTaleoIframe();
        wait.until(ExpectedConditions.visibilityOf(locationTextBox));
        actions = new Actions(driver);
        actions.moveToElement(locationTextBox).click().build().perform();
    }

    public void clickSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.submit();
    }

    public void switchToTaleoIframe() {
        wait.until(ExpectedConditions.visibilityOf(taleoIframe));
        driver.switchTo().frame(taleoIframe);
    }

    public void clickLocationCheckbox(String location) {
        List<WebElement> list = driver.findElements(locationCheckboxes);
        for (WebElement elem : list) {
            String text = elem.getText();
            if (text.contains(location)) {
                actions = new Actions(driver);
                actions.moveToElement(elem).click().build().perform();
                break;
            }
        }
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }

    public void clickNewSearchButton() {
        wait.until(ExpectedConditions.visibilityOf(newSearchButton));
        newSearchButton.click();
        driver.switchTo().defaultContent();
    }

    public List<WebElement> getSearchResultRows() {
        List<WebElement> list = driver.findElements(searchResultRows);
        return list;
    }
}
