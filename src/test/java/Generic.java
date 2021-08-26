import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Generic {

    public static WebDriver init() {

        Dotenv dotenv = Dotenv.load();
        System.setProperty("webdriver.chrome.driver", dotenv.get("CHROME_DRIVER_PATH"));

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        return driver;
    }

    public void openPage(WebDriver driver, String page) {
        driver.get(page);
    }

    public void showMessage(String testId, String type) {
        String failMessage = "The automatic test " + testId + " finished.\n" + testId + ": FAILED";
        String successMessage = "The automatic test " + testId + " is successfully completed.\n" + testId + ": PASSED";
        if (type.equals("Success")) {
            System.out.println(successMessage);
        } else {
            System.out.println(failMessage);
        }
    }
}