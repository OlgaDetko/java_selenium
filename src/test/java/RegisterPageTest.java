import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import page.RegisterPage;

import static org.testng.Assert.assertTrue;

public class RegisterPageTest {

    static WebDriver driver;

    @Test
    public void registerPage_TC02() {
        String testId = "TC02";
        System.out.println("The automatic test " + testId + " starts.");

        Generic generic = new Generic();
        driver = generic.init();
        generic.openPage(driver,"https://spotify.com/pl/signup/");
        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.acceptCookie();

        try {
            registerPage.clickRegisterButton();
            assertTrue(registerPage.isErrorPresent("Podaj swój adres e-mail"));
            assertTrue(registerPage.isErrorPresent("Potwierdź swój adres e-mail"));
            assertTrue(registerPage.isErrorPresent("Wprowadź hasło"));
            assertTrue(registerPage.isErrorPresent("Wprowadź nazwę użytkownika dla swojego profilu"));
            assertTrue(registerPage.isErrorPresent("Podaj prawidłowy dzień miesiąca"));
            assertTrue(registerPage.isErrorPresent("Wybierz miesiąc z listy"));
            assertTrue(registerPage.isErrorPresent("Podaj prawidłowy rok"));
            assertTrue(registerPage.isErrorPresent("Wybierz swoją płeć"));
            assertTrue(registerPage.isErrorPresent("Zaakceptuj warunki, aby kontynuować"));
            assertTrue(registerPage.isErrorPresent("Potwierdź, że nie jesteś robotem"));

            registerPage.enterEmail("sampleIncorrectEmail.com");
            registerPage.enterConfirmationEmail("anotherSampleIncorrectEmail.com");
            registerPage.enterPassword("1234567");
            registerPage.enterDayOfBirth(99);
            registerPage.enterYearOfBirth(1000);
            registerPage.clickNonInteractivePasswordLabel();
            assertTrue(registerPage.isErrorPresent("Podany adres jest nieprawidłowy"));
            assertTrue(registerPage.isErrorPresent("Podane adresy e-mail są różne"));
            assertTrue(registerPage.isErrorPresent("Twoje hasło jest za krótkie"));
            assertTrue(registerPage.isErrorPresent("Podaj prawidłowy dzień miesiąca"));
            assertTrue(registerPage.isErrorPresent("Podaj prawidłowy rok"));

            generic.showMessage(testId, "Success");
        } catch (Exception e) {
            generic.showMessage(testId, "Fail");
        } finally {
            driver.close();
        }
    }
}
