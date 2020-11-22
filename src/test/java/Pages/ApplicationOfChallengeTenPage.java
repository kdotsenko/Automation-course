package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ApplicationOfChallengeTenPage {
    WebDriver driver;

    public ApplicationOfChallengeTenPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath="//th/h1[contains(text(),'Wellcome to your')]")
    private WebElement welcomeSign;

    public void verifyUserIsLoggedIn(){
        String displayedUrl=driver.getCurrentUrl();
        Assert.assertEquals(displayedUrl, "http://testingchallenges.thetestingmap.org/login/main_page.php");
        Assert.assertTrue(welcomeSign.isDisplayed());
    }
}
