import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShoppingTest extends BaseTest {
    /**
     * Testing adding one item to the shopping cart
     * Steps:
     * 1.Go to home page
     * 2.Click on burger menu PRODAVNICA
     * 3.Click on option Sve kategorije
     * 4.Click on option Kursevi i radionice
     * 5. Click on button U KORPU on the selected product
     *
     * Expected results:
     * Verify that icon on shopping cart shows 1
     */
    @Test
    public void testAddOneItemInShoppingCart() {
        print("Testing adding one item to the shopping cart");
        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Go to home page");
            HomePage homePage = new HomePage(driver);
            print("2.Click on burger menu PRODAVNICA");
            homePage.clickOnBurgerMenuProdavnica();
            StorePages storePages = new StorePages(driver);
            print("3.Click on option Sve kategorije");
            storePages.clickOnSveKategorije();
            print("4.Click on option Kursevi i radionice");
            storePages.clickOnKurseviIRadionice();
            print("5. Click on button U KORPU on the selected product");
            storePages.clickOnUKorpuSTORITVEButton();
            driver.navigate().refresh();
            String currentlNumberOfItemsInCart = homePage.getNumberOfItemsInShoppingCart();
            assert currentlNumberOfItemsInCart.equals("1") : "Wrong number of items in cart. Expected 1, actual: " + currentlNumberOfItemsInCart;

        }finally {
            driver.quit();
        }
    }
}
