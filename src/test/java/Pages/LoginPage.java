package Pages;
import Data.User;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name="username")
    @CacheLookup public WebElement loginFieldOnLoginPage;

    @FindBy(name="password")
     private WebElement passwordFieldOnLoginPage;

    @FindBy(xpath="//button[contains(text(),'log in')]")
    private WebElement submitButtonOnLoginPage;



    public void login(User user){

        loginFieldOnLoginPage.sendKeys(user.getUserLogin());
        passwordFieldOnLoginPage.sendKeys(user.getUserPassword());
        submitButtonOnLoginPage.click();

}


}
