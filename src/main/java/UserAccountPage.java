import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class UserAccountPage extends BasePage {
    //web elements
    @FindBy(xpath ="//form[@id='cart_login_default']/div[@class='form-group']/input")
    WebElement emailAdresaField;
    @FindBy(xpath = "//form[@id='cart_login_default']/div[@class='input-group']/input")
    WebElement lozinkaField;
    @FindBy(xpath = "//div[@class='input-group-btn']")
    WebElement prijavaButton;
    @FindBy(xpath = "//form[@id='cart_login_default']/span")
    WebElement errorMessage;
    @FindBy (xpath = "//div[@class='co co-delivery-address']/button[contains(text(),'Uredi')]")
    WebElement urediButton;


    //constructor
    public UserAccountPage (ChromeDriver driver){
        super(driver);
        print("UserAccountPage");
        assert verifyURL(Strings.USER_ACCOUNT_PAGE_URL) : "Wrong URL";
    }
    //methods
    public void enterTextInEmailAdresaField (String text){
        emailAdresaField.click();
        emailAdresaField.sendKeys(text);
    }
    public void enterTextInLozinkaField (String text){
        lozinkaField.click();
        lozinkaField.sendKeys(text);
    }
    public void urediButtonText (){
        String buttonText = urediButton.getText();
    }
}
