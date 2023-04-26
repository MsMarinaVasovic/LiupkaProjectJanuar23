import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class StorePages extends BasePage{
    //web elements
    @FindBy(xpath = "//a[@href='/rs/pribor-za-masine']/parent::li/parent::ul//a[@href='/rs/Masine-za-sivenje']")
    WebElement sewingMachines;
    @FindBy(xpath = "//select[@class='sorter-options form-control']")
    WebElement sortDropDownOptionsButton;
    @FindBy(xpath = "//select[@class='sorter-options form-control']")
    WebElement fieldWithSortingOptions;
    @FindBy(xpath = "//a[@class='open-cate btn-view-all']")
    WebElement optionSveKategorije;
    @FindBy(xpath = "//div[@class='block-nav-categori has-open']//li[@class='parent cat-link-orther']/a")
    WebElement optionKurseviIRadionice;
    @FindBy(xpath = "//div[@class='product-item-actions div-animation']/span[@class='stock-left']")
    WebElement stockStatusNaZalihi;
    @FindBy (xpath = "//div[@class='product-item-opt-2']")
    WebElement containerForSTORITVEProductItem;
    @FindBy (xpath = "//div[@class='product-item-detail']/button/span")
    WebElement uKorpuSTORITVEButton;

    //constructor
    public StorePages (ChromeDriver driver){
        super(driver);
        print("StorePages");
    }
    //methods
    public void clickOnSewingMachines () {
        print("clickOnSewingMachines");
        waitForElement(sewingMachines);
        assert isElementPresent(sewingMachines) : "Element sewing machines ('Masine za sivenje') is not present";
        sewingMachines.click();
    }
    public boolean  isDropdownIsPresent () {
        return isElementPresent(sortDropDownOptionsButton);
    }
    public void sortItemsByCriteria (String sortCriteria) {
        print("sortItemsByCriteria");
        Select select= new Select(sortDropDownOptionsButton);
        select.selectByVisibleText(sortCriteria);
    }
    public void clickOnSortDropDownOptionsButton (){
        print("clickOnSortDropDownOptionsButton;" + "Option:" + Strings.SORT_BY_PRICE_ASC );
        waitForElement(sortDropDownOptionsButton);
        sortDropDownOptionsButton.click();
    }
    public void clickOnFieldWithSortingOptions () {
        print("clickOnFieldWithSortingOptions");
        waitForElement(fieldWithSortingOptions);
        assert isElementPresent(fieldWithSortingOptions) : "Element field with sorting options is not present";
        fieldWithSortingOptions.click();
    }
    public void clickOnSveKategorije () {
        print("clickOnSveKategorije");
        waitForElement(optionSveKategorije);
        assert isElementPresent(optionSveKategorije) : "Element Sve kategorije is not present";
        optionSveKategorije.click();
    }
    public void clickOnKurseviIRadionice () {
        print("clickOnKurseviiRadionice");
        waitForElement(optionKurseviIRadionice);
        assert isElementPresent(optionKurseviIRadionice) : "Element Kursevi i radionice is not present";
        optionKurseviIRadionice.click();
    }
    public void clickOnUKorpuSTORITVEButton (){
        print("clickOnUKorpuSTORITVEButton");
        hoverOverElement(containerForSTORITVEProductItem);
        waitForElement(uKorpuSTORITVEButton);
        assert isElementPresent(uKorpuSTORITVEButton) : "Element U Korpu for product STORITVE is not present";
        uKorpuSTORITVEButton.click();
    }
}
