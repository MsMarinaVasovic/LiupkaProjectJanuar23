import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    //web elements
    @FindBy(xpath = "//div[@class='header-box-search']//div[@class='block-minicart dropdown summary_cart']/a[@class='dropdown-toggle']/span[@class='cart-icon']")
    WebElement shoppingCart;

    //constructor
    public BasePage(){}
    public BasePage (ChromeDriver driver) {
        print("Base page");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    ChromeDriver driver;

    //methods
    public void clickShoppingCart (){
        print("clickShoppingCart");
        shoppingCart.click();
    }
    public static void print (String s) { System.out.println(s); }

    public boolean verifyURL (String expectedUrl){
        print("Verify URL(" + expectedUrl+ ")");
        String currentURL= driver.getCurrentUrl();
        return currentURL.equals(expectedUrl);
    }
    public void sleep (int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e) {
            print(e.getMessage());
        }
    }
    public boolean isElementPresent (WebElement element) {
        try {
            print("isElementPresent()");
            boolean isPresent = element.isDisplayed();
            return isPresent;
        }catch (Exception e) {
            return false;
        }
    }
    public void scrollIntoView (WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public void waitForElement (WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void hoverOverElement (WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }
}
