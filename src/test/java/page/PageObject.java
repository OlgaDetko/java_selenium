package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isElementPresent(WebElement webElement){
        try{
            webElement.getText();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
