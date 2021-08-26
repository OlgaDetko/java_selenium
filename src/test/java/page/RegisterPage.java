package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageObject {

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='confirm']")
    private WebElement confirmationEmailField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='displayname']")
    private WebElement nickNameField;

    @FindBy(xpath = "//input[@id='day']")
    private WebElement dayOfBirthField;

    @FindBy(xpath = "//select[@id='month']")
    private WebElement monthOfBirthField;

    @FindBy(xpath = "//input[@id='year']")
    private WebElement yearOfBirthField;

    @FindBy(xpath = "//button[@type='submit']/div[contains(@class,'Signup')]")
    private WebElement registerButton;

    @FindBy(xpath = "//label[@for='password']")
    private WebElement passwordLabel;

    @FindBy(xpath = "//button[text()='Akceptuj pliki cookie']")
    private WebElement acceptCookieButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        this.emailField.clear();
        this.emailField.sendKeys(email);
    }

    public void enterConfirmationEmail(String confirmationEmail) {
        this.confirmationEmailField.clear();
        this.confirmationEmailField.sendKeys(confirmationEmail);
    }

    public void enterPassword(String password) {
        this.passwordField.clear();
        this.passwordField.sendKeys(password);
    }

    public void enterNickname(String nickname) {
        this.nickNameField.clear();
        this.nickNameField.sendKeys(nickname);
    }

    public void enterDayOfBirth(Integer day) {
        this.dayOfBirthField.clear();
        this.dayOfBirthField.sendKeys(day.toString());
    }

    public void enterYearOfBirth(Integer year) {
        this.yearOfBirthField.clear();
        this.yearOfBirthField.sendKeys(year.toString());
    }

    public void clickRegisterButton() {
        this.registerButton.click();
    }

    public void clickNonInteractivePasswordLabel() {
        this.passwordLabel.click();
    }

    public void acceptCookie() {
        this.acceptCookieButton.click();
    }

    public Boolean isErrorPresent(String errorMessage) {
        if (errorMessage.equals("Podaj swój adres e-mail") || errorMessage.equals("Podany adres jest nieprawidłowy")) {
            return driver.findElements(By.xpath("//div[@aria-label='Informacja o błędzie']/span[contains(text(),'" + errorMessage + "')]")).size() > 0;
        } else {
            return driver.findElements(By.xpath("//div[@aria-label='Informacja o błędzie'][contains(text(),'" + errorMessage + "')]")).size() > 0;
        }
    }
}
