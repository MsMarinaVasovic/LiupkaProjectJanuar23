import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class FooterLinksTests extends BaseTest{
    /**
     * Test link KURSEVI
     * Steps:
     * 1.Go to home page
     * 2.Click on the link KURSEVI from the footer field
     *
     * Expected results:
     * Verify that a new window with defined URL has opened
     */
    @Test
    public void testSiteFooterLinkKursevi() {
        print("testSiteFooterLinkKursevi");
        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Go to home page");
            HomePage homePage = new HomePage(driver);
            print("2.Click on the link KURSEVI from the footer field");
            homePage.clickOnFooterLinkKursevi();
            String actualUrl1 = driver.getCurrentUrl();
            print("Verify that a new window with defined URL has opened");
            assert actualUrl1.equals(Strings.KURSEVI_I_RADIONICE_URL) : "User is on wrong page. Expected: " + Strings.KURSEVI_I_RADIONICE_URL + "Actual:" + actualUrl1;
        }finally {
            driver.quit();
        }
    }

    /**
     * Test link NACIN PLACANJA
     * Steps:
     * 1.Go to home page
     * 2.Click on the link NACIN PLACANJA from the footer field
     *
     * Expected results:
     * Verify that a new window with defined URL has opened
     */
    @Test
    public void testSiteFooterLinkNacinPlacanja() {
        print("testSiteFooterLinkNacinPlacanja");
        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Go to home page");
            HomePage homePage = new HomePage(driver);
            print("2.Click on the link NACIN PLACANJA from the footer field");
            homePage.clickOnFooterLinkNacinPlacanja();
            String actualUrl1 = driver.getCurrentUrl();
            print("Verify that a new window with defined URL has opened");
            assert actualUrl1.equals(Strings.NACIN_PLACANJA_URL) : "User is on wrong page. Expected: " + Strings.NACIN_PLACANJA_URL + "Actual:" + actualUrl1;
        }finally {
            driver.quit();
        }
    }

    /**
     * Test link DOSTAVA
     * Steps:
     * 1.Go to home page
     * 2.Click on the link DOSTAVA from the footer field
     *
     * Expected results:
     * Verify that a new window with defined URL has opened
     */
    @Test
    public void testSiteFooterLinkDostava() {
        print("testSiteFooterLinkDostava");
        ChromeDriver driver = openChromeDriver();
        try {
            print("1.Go to home page");
            HomePage homePage = new HomePage(driver);
            print("2.Click on the link DOSTAVA from the footer field");
            homePage.clickOnFooterLinkDostava();
            String actualUrl1 = driver.getCurrentUrl();
            print("Verify that a new window with defined URL has opened");
            assert actualUrl1.equals(Strings.DOSTAVA_URL) : "User is on wrong page. Expected: " + Strings.DOSTAVA_URL + "Actual:" + actualUrl1;
        }finally {
            driver.quit();
        }
    }
}
