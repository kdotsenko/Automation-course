package Pages;

import Data.Utils;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ChallengeFourPage extends BasePage {
    WebDriver driver;

    public ChallengeFourPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name="CNP")
    @CacheLookup private WebElement CPNField;

    @FindBy(name = "formSubmit")
    @CacheLookup private WebElement submitButton;

    @FindBy(xpath="//font[contains(text(),'YOU HAVE DONE IT')]")
    @CacheLookup private WebElement successAlert;

    public void enterCPN(){
        CPNField.sendKeys(Utils.randomCPN.CPN());

    }

    public void submitResult(){
        submitButton.click();
    }

    public void verifySuccess(){
        Assert.assertTrue(successAlertCheck());
    }

    public Boolean successAlertCheck(){
      return  successAlert.isDisplayed();
    }

    }



