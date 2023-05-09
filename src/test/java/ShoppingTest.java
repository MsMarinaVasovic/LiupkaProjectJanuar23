import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

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

    /**
     * Testing adding two same items to the shopping cart
     * Steps:
     * 1.Go to home page
     * 2.Click on burger menu PRODAVNICA
     * 3.Click on option Sve kategorije
     * 4.Click on option Kursevi i radionice
     * 5. Click on button U KORPU on the selected product
     * 6.Click on field for quantity enter (modal window) and enter 2
     * 7.Click on close button from modal window
     *
     * Expected results:
     * Verify that icon on shopping cart shows 1
     * Verify that number of same items in mini cart is 2
     */
    @Test
    public void testAddTwoSameItemsInShoppingCart() {
        print("Testing adding two same items to the shopping cart");
        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Go to home page");
            HomePage homePage = new HomePage(driver);
            homePage.allowCoociesButton.click();
            print("2.Click on burger menu PRODAVNICA");
            homePage.clickOnBurgerMenuProdavnica();
            StorePages storePages = new StorePages(driver);
            print("3.Click on option Sve kategorije");
            storePages.clickOnSveKategorije();
            print("4.Click on option Kursevi i radionice");
            storePages.clickOnKurseviIRadionice();
            print("5. Click on button U KORPU on the selected product");
            storePages.clickOnUKorpuSTORITVEButton();
            print("6.Click on field for quantity enter and enter 2");
            WebDriverWait wait = new WebDriverWait(driver, 30);
            WebElement kolicinaFieldFromModal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='addItemQuantity']")));
            Actions action=new Actions(driver);
            action.moveToElement(kolicinaFieldFromModal).click().build().perform();
            kolicinaFieldFromModal.sendKeys(Keys.BACK_SPACE);
            kolicinaFieldFromModal.sendKeys("2");
            print("7.Click on close button from modal window");
            action.moveToElement(storePages.closeButtonFromModalWindow).click().build().perform();
            driver.navigate().refresh();
            homePage.shoppingCart.click();
            String currentlNumberOfItemsInCart = homePage.getNumberOfItemsInShoppingCart();
            String currentNumberOfSameItemsMiniCart = storePages.numberOfItemsInMiniCartWindow.getText();

            assert currentlNumberOfItemsInCart.equals("1") : "Wrong number of items in cart. Expected 1, actual: " + currentlNumberOfItemsInCart;
            assert currentNumberOfSameItemsMiniCart.equals("2") : "Wrong number of same items in mini cart. Expected 2, actual : " + currentNumberOfSameItemsMiniCart;

        }finally {
            driver.quit();
        }
    }
}
