import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    /**
     * Login test with valid credentials
     * Steps:
     * 1.Go to home page
     * 2.Click on User icon
     * 3.Enter valid Email
     * 4.Enter valid password
     * 5.Click PRIJAVA button
     *
     * Expected result:
     * Verify that user is logged in
     */
    @Test
    public void loginTestWithValidEmailAndPassword() {
        print("Login test with valid credentials");
        ChromeDriver driver = openChromeDriver();

        try {
            print("1.Go to home page");
            HomePage homePage = new HomePage(driver);
            print("2.Click on User icon");
            homePage.clickOnUserIcon();
            UserAccountPage userAccountPage = new UserAccountPage(driver);
            print("3.Enter valid Email");
            userAccountPage.enterTextInEmailAdresaField(Strings.VALID_USER_NAME);
            print("4.Enter valid password");
            userAccountPage.enterTextInLozinkaField(Strings.VALID_PASSWORD);
            print("5.Click PRIJAVA button");
            userAccountPage.prijavaButton.click();
            driver.navigate().refresh();
            print("Verify that user is logged in");
            String textOfButtonUredi = userAccountPage.urediButton.getText();
            assert textOfButtonUredi.equals("UREDI") : "The user is not logged in.";

        } finally {
            driver.quit();
        }
    }//
}
