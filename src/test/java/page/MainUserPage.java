package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainUserPage extends PageObject {

    @FindBy(xpath = "//button[@aria-controls='profileMenu']")
    private WebElement privateAccountButton;

    public MainUserPage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserWidgetPresent() {
        return isElementPresent(privateAccountButton);
    }

}
