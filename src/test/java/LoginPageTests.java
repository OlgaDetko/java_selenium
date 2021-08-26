import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import page.LoginPage;
import page.MainUserPage;

import static org.testng.Assert.assertTrue;

public class LoginPageTests {

    static WebDriver driver;

    @Test
    public void loginPage_TC03() {
        String testId = "TC03";
        System.out.println("The automatic test " + testId + " starts.");

        Generic generic = new Generic();
        driver = generic.init();
        generic.openPage(driver,"https://spotify.com/pl/login");
        Dotenv dotenv = Dotenv.load();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(dotenv.get("EMAIL"));
        loginPage.enterPassword(dotenv.get("PASSWORD"));
        loginPage.clickLoginButton();

        MainUserPage mainUserPage = new MainUserPage(driver);

        try {
            assertTrue(mainUserPage.isUserWidgetPresent());
            generic.showMessage(testId, "Success");
        } catch (Exception e) {
            generic.showMessage(testId, "Fail");
        } finally {
            driver.close();
        }
    }
}
