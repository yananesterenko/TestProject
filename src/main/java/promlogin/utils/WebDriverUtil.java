package promlogin.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverUtil {

    public static ChromeDriver getChromeDriver(String path) {
        System.setProperty("webdriver.chrome.driver",  System.getProperty("user.dir") + "\\webdrivers\\"+  "chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get(path);

        return driver;
    }
    public static void setTimeOutSec(ChromeDriver driver, long sec){
        driver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);
    }
}
