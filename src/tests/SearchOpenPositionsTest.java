package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.careers.CareersPage;
import pages.careers.PositionsPage;
import pages.home.HomePage;
import utils.WebDriverUtil;

import java.util.List;

@Test()
public class SearchOpenPositionsTest {
    // Driver
    WebDriver driver;
    // Utils
    WebDriverUtil webDriverUtil;
    // Pages
    HomePage homePage;
    CareersPage careersPage;
    PositionsPage positionsPage;

    @DataProvider(name = "Locations")
    public static Object[][] locations() {
        return new Object[][] { { "Oklahoma City, OK"}, {"Mobile, AL"}};
    }

    @BeforeSuite
    public void setup() {
        // Navigate to search open positions page before
        webDriverUtil = new WebDriverUtil();
        driver = webDriverUtil.initWebDriver(webDriverUtil.CHROME);

        homePage = new HomePage(driver);
        homePage.goTo();
        homePage.clickCareersButton();

        careersPage = new CareersPage(driver);
        careersPage.clickOpenPositionsButton();
    }

    @Test (priority = 1, dataProvider = "Locations")
    public void searchForOpenPositionsByLocation(String location) {
        // Search for position
         positionsPage = new PositionsPage(driver);
         positionsPage.clickLocationTextBox();
         positionsPage.clickLocationCheckbox(location);
         positionsPage.clickSaveButton();
         positionsPage.clickSearchButton();

        List<WebElement> list = positionsPage.getSearchResultRows();
        for (WebElement elem : list) {
            String text = elem.getText();
            System.out.println(text);
            Assert.assertTrue(text.contains(location));
        }
        positionsPage.clickNewSearchButton();
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

}
