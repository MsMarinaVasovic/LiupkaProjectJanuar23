import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest extends BaseTest {
    /**
     * Presence of options for sorting in drop down menu
     * Steps:
     * 1.Go to home page
     * 2.Click on burger menu PRODAVNICA
     * 3.Click on option Masine za sivenje
     * 4.Click on field with sorting options
     *
     * Expected results:
     * Verify that the total number of sorting options is equal to the defined number of sorting options
     * Verify that each listed sort option matches the defined sort option
     */

    @Test
    public void testThePresenceOfOptionsFromSortingDropdownMenu() {
        print("Test presence of options for sorting in drop down menu");
        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Go to home page");
            HomePage homePage = new HomePage(driver);
            print("2.Click on burger menu PRODAVNICA");
            homePage.clickOnBurgerMenuProdavnica();
            StorePages storePages = new StorePages(driver);
            print("3.Click on option Masine za sivenje");
            storePages.clickOnSewingMachines();
            List<WebElement> allSortingOptions = driver.findElements(By.xpath("//select[@class='sorter-options form-control']/option"));
            for (int i = 0; i<allSortingOptions.size(); i++) {
                String option = allSortingOptions.get(i).getText();
                print("Sorting option"+(1+i) +": "  +option);
            }
            print("4.Click on field with sorting options");
            storePages.clickOnFieldWithSortingOptions();
            print("Verify that the total number of sorting options is equal to the defined number of sorting options");
            int numberOfSortingOptions = allSortingOptions.size();
            assert numberOfSortingOptions == Strings.NUMBER_OF_SORTING_OPTIONS :"Wrong number of sorting options";
            print("Verify that each listed sort option matches the defined sort option");
            assert allSortingOptions.get(0).getText().contains(Strings.SORT_OPTION_1) : "Wrong option 1";
            assert allSortingOptions.get(1).getText().contains(Strings.SORT_OPTION_2) : "Wrong option 2";
            assert allSortingOptions.get(2).getText().contains(Strings.SORT_OPTION_3) : "Wrong option 3";
            assert allSortingOptions.get(3).getText().contains(Strings.SORT_OPTION_4) : "Wrong option 4";
            assert allSortingOptions.get(4).getText().contains(Strings.SORT_OPTION_5) : "Wrong option 5";
            assert allSortingOptions.get(5).getText().contains(Strings.SORT_OPTION_6) : "Wrong option 6";

        } finally {
            driver.quit();
        }
    }
}

