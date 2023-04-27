import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    //web elements
    @FindBy(xpath = "//div[@class='box-header-nav']//div[@class='block-nav-categori']//div[@class='block-title']")
    WebElement burgerMenuProdavnica;
    @FindBy (xpath = "//a/span[@class='user-icon']")
    WebElement userIcon;
    @FindBy (xpath = "//a[@class='banner-youtube']")
    WebElement youtubeBanner;
    @FindBy (xpath = "//div[@class='col-md-3 col-sm-3 col-xs-12 nav-right']//span[@class='cart-icon']")
    WebElement shoppingCart;
    @FindBy (xpath = "//div[@class='col-md-3 col-sm-3 col-xs-12 nav-right']//span[@class='counter-number']")
    WebElement numberOfItemsInShoppingCart;
    @FindBy (xpath = "//div[@class='content-right p1']//div[contains(text(),'KURSEVI')]")
    WebElement footerLinkKursevi;
    @FindBy (xpath = "//div[@class='content-right p1']//div[contains(text(),'NAČIN PLAĆANJA')]")
    WebElement footerLinkNacinPlacanja;
    @FindBy (xpath = "//div[@class='content-right p1']//div[contains(text(),'DOSTAVA ')]")
    WebElement footerLinkDostava;

    //constructor
    public HomePage (ChromeDriver driver){
        super(driver);
        driver.get(Strings.HOME_PAGE_URL);
        print("HomePage");
    }

    //methods
    public void clickOnBurgerMenuProdavnica (){
        print("clickOnBurgerMenuProdavnica");
        assert isElementPresent(burgerMenuProdavnica) : "Burger menu 'Prodavnica' is not present";
        burgerMenuProdavnica.click();
    }
    public void clickOnUserIcon (){
        print("clickOnUserIcon");
        waitForElement(userIcon);
        assert isElementPresent(userIcon) : "Element User Icon is not present";
        userIcon.click();
    }
    public void clickOnYoutubeBanner (){
        print("clickOnYoutubeBanner");
        waitForElement(youtubeBanner);
        assert isElementPresent(youtubeBanner) : "Element youtube banner is not present";
        youtubeBanner.click();
    }
    public String getNumberOfItemsInShoppingCart(){
        print("getNumberOfItemsInShoppingCart");
        assert isElementPresent(numberOfItemsInShoppingCart) : "Cart Number is NOT present";
        scrollIntoView(numberOfItemsInShoppingCart);
        waitForElement(numberOfItemsInShoppingCart);
        return numberOfItemsInShoppingCart.getText();
    }
    public void clickOnFooterLinkKursevi (){
        print("clickOnFooterLinkKursevi");
        waitForElement(footerLinkKursevi);
        assert isElementPresent(footerLinkKursevi) : "Element from footer KURSEVI is not present";
        footerLinkKursevi.click();
    }
    public void clickOnFooterLinkNacinPlacanja (){
        print("clickOnFooterLinkNacinPlacanja");
        waitForElement(footerLinkNacinPlacanja);
        assert isElementPresent(footerLinkNacinPlacanja) : "Element from footer NACIN PLACANJA is not present";
        footerLinkNacinPlacanja.click();
    }
    public void clickOnFooterLinkDostava (){
        print("clickOnFooterLinkDostava");
        waitForElement(footerLinkDostava);
        assert isElementPresent(footerLinkDostava) : "Element from footer DOSTAVA is not present";
        footerLinkDostava.click();
    }
}
