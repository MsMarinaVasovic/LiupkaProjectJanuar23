import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class BannersTest extends BaseTest {
    /**
     * Link to YouTube
     * Steps:
     * 1.Go to home page
     * 2.Click on the YouTube link on the right link : POUCNI VIDEO
     *
     * Expected results:
     * Verify that a new window has opened on YouTube
     */
    @Test
    public void testLinkToYouTubeFromHomePage() {
        print("TestLinkToYouTubeFromHomePage");
        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Go to home page");
            HomePage homePage = new HomePage(driver);
            print("2.Click on the YouTube link on the right link : POUCNI VIDEO");
            homePage.clickOnYoutubeBanner();
            ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));
            String actualUrl1 = driver.getCurrentUrl();
            driver.close();
            driver.switchTo().window(tabs.get(0));
            String actualUrl2 = driver.getCurrentUrl();

            print("Verify that a new window has opened on YouTube");
            assert actualUrl1.equals(Strings.YOUTUBE_BANNER_URL) : "User is on wrong page. Expected: " + Strings.YOUTUBE_BANNER_URL + "Actual:" + actualUrl1;

        }finally {
            driver.quit();
        }
    }
}
