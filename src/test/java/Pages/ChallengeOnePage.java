package Pages;
import Data.TestChallengeDataCollections;
import Data.TestClass;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;



public class ChallengeOnePage extends BasePage {
    WebDriver driver;

    public ChallengeOnePage(WebDriver driver)  {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id="firstname")
    @CacheLookup public WebElement nameField;

    @FindBy(name="formSubmit")
    @CacheLookup public WebElement submitButton;

    @FindBy(xpath="//span[@class='values-tested']")
    @CacheLookup public WebElement checksCounter;

    @FindBy(xpath = "//p[4]/strong[contains(text(),'Gheorghe')]")
    @CacheLookup public WebElement nameOfUser;

    @FindBy(xpath = "//*[contains(text(),'Challenge #10 ')]")
    @CacheLookup public WebElement challenge10Link;

    @FindBy(xpath = "//*[contains(text(),'Challenge #8 ')]")
    @CacheLookup public WebElement challenge8Link;

    @FindBy(xpath = "//*[contains(text(),'Challenge #4')]")
    @CacheLookup public WebElement challenge4Link;


    public void enterTestData(String testData){
        nameField.sendKeys( testData);
        submitButton.click();
        TestClass.dataVerification.shownCounter=checksCounter.getText();
        TestClass.dataVerification.shownName=nameOfUser.getText();

    }


    public void verifyNameIsDisplayedCorrectly(String testElement){

       driver.navigate().refresh();
        Assert.assertEquals(TestClass.dataVerification.shownName, "Gheorghe_"+testElement );
    }

    public ChallengeOnePage verifyCountsAreDisplayedCorrectly(int triesCounter){

        Assert.assertEquals(TestClass.dataVerification.shownCounter, String.valueOf(triesCounter));
        return new ChallengeOnePage(driver);
    }

    public void openChallengeTenPage( WebDriver driver){
        challenge10Link.click();


    }

    public void openChallengeEightPage(){

        challenge8Link.click();
    }

    public void openChallengeFourPage(){
        challenge4Link.click();
    }











}
