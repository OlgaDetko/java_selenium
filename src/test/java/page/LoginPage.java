package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@id='login-button']")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        this.emailField.clear();
        this.emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }
}
