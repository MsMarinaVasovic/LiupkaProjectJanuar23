import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SortTest extends BaseTest{
    /**
     * Sorting products by price (on product Ves masine)
     * Steps:
     * 1.Go to home page
     * 2.Click on burger menu PRODAVNICA
     * 3.Click on option Masine za sivenje
     * 4.Click on field with sorting options
     * 5. Click on option Najnizoj ceni
     *
     * Expected results:
     * Verify that the products are sorted in ascending order
     */
    @Test
    public void sortingProductsByPrice (){
        print("Sorting products by price");
        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Go to home page");
            HomePage homePage = new HomePage(driver);
            print("2.Click on burger menu PRODAVNICA");
            homePage.clickOnBurgerMenuProdavnica();
            StorePages storePages = new StorePages(driver);
            print("3.Click on option Masine za sivenje");
            storePages.clickOnSewingMachines();
            List<WebElement> allItemPricesBeforeSort = driver.findElements(By.xpath("//div[@class='product-item-price']/span[@class='price']"));
            String firstItemPriceBeforeSort = allItemPricesBeforeSort.get(0).getText();
            print("4.Click on field with sorting options");
            storePages.clickOnSortDropDownOptionsButton();
            print("5. Click on option Najnizoj ceni");
            storePages.sortItemsByCriteria(Strings.SORT_BY_PRICE_ASC);
            List<WebElement> allItemPricesAfterSort = driver.findElements(By.xpath("//div[@class='product-item-price']/span[@class='price']"));
            ArrayList<Double>itemPricesAsNumbersAfterSort = new ArrayList<Double>();
            for (int i = 0; i< allItemPricesAfterSort.size(); i++){
                String itemPrice = allItemPricesAfterSort.get(i).getText();
                String priceWithoutCurrency = itemPrice.substring(0,itemPrice.length()-7);
                double priceToNumber = Double.valueOf(priceWithoutCurrency);
                itemPricesAsNumbersAfterSort.add(priceToNumber);
            }
            for (int i = 0; i<itemPricesAsNumbersAfterSort.size()-1; i++){
                assert itemPricesAsNumbersAfterSort.get(i) <= itemPricesAsNumbersAfterSort.get(i+1) : "Array is not in ascending order.";
            }
            String firstItemPriceAfterSort = allItemPricesAfterSort.get(0).getText();
            double priceAfterSort = Double.valueOf(firstItemPriceAfterSort.substring(0,firstItemPriceAfterSort.length()-7));
            double priceBeforeSort = Double.valueOf(firstItemPriceBeforeSort.substring(0,firstItemPriceBeforeSort.length()-7));
            print("Verify that the products are sorted in ascending order");
            assert priceAfterSort < priceBeforeSort : "Wrong sort. Expected to be in ascending order.";

        }finally {
            driver.quit();
        }
    }
}
