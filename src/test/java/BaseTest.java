import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public ChromeDriver openChromeDriver (){
        print("Opening Chrome Driver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--disable-popup-blocking"});
        options.addArguments(new String[]{"--incognito"});
        options.addArguments(new String[]{"--start-maximized"});
        options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        return driver;
    }
    public static void print (String s) { System.out.println(s); }
    public void sleep (int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e) {
            print(e.getMessage());
        }
    }
}
