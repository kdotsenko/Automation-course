package Pages;
import Data.TestChallengeDataCollections;
import Data.User;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.Assert;


public class ChallengeTenPage {
    WebDriver driver;

   public ChallengeTenPage(WebDriver driver) {
       PageFactory.initElements(driver, this);
       this.driver = driver;
    }



    @FindBy(name="username")
    @CacheLookup public WebElement loginField;

    @FindBy(name="password")
    @CacheLookup public WebElement passwordField;

    @FindBy(name="firstname")
    @CacheLookup public WebElement firstNameField;

    @FindBy(name="lastname")
    @CacheLookup public WebElement lastNameField;

    @FindBy(xpath="//input[@value='Submit']")
    @CacheLookup public WebElement submitButton;

    @FindBy(xpath = "//*[contains(text(),'Challenge #10 ')]")
    @CacheLookup public WebElement challenge10Link;

    @FindBy(linkText = "link")
            @CacheLookup public WebElement loginLink;

    @FindBy(xpath="//table//th[3][contains(text(),'username')]")
            @CacheLookup public WebElement userNameColumn;



    TestChallengeDataCollections testChallengeDataCollections;


    public void enterLoginPasswordFirstAndLastNameAndSubmit(User user){
    loginField.sendKeys(user.getUserLogin());
    passwordField.sendKeys(user.getUserPassword());
    firstNameField.sendKeys(user.getUserFirstName());
    lastNameField.sendKeys(user.getUserLastName());
    submitButton.click();
}




public void getDisplayedDataAndVerifyUserWasCreatedCorrectly( User user){
      int userDataIndex=0;
      while(userDataIndex<testChallengeDataCollections.amountOfUserData(user)) {
          WebElement displayedElement = driver.findElement(By.xpath("//th[contains(text(),'" + testChallengeDataCollections.getUsersData(user, userDataIndex) + "')]"));
          String displayedValue = displayedElement.getText();
          Assert.assertTrue(displayedValue.contains(testChallengeDataCollections.getUsersData(user, userDataIndex)));
          userDataIndex++;

      }

}

public void verifyDisplayedUserDetails(User user){

    WebElement displayedElementLogin = driver.findElement(By.xpath("//table//th[2][contains(text(),'username')]")).findElement(By.xpath("//table//th[2][contains(text(),'"+user.getUserLogin()+"')]"));
    String displayedUserLogin = displayedElementLogin.getText();
    Assert.assertTrue(displayedUserLogin.contains( user.getUserLogin()));

    WebElement displayedElementPassword = driver.findElement(By.xpath("//table//th[3][contains(text(),'password')]")).findElement(By.xpath("//table//th[3][contains(text(),'"+user.getUserPassword()+"')]"));
    String displayedPassword = displayedElementPassword.getText();
    Assert.assertTrue(displayedPassword.contains( user.getUserPassword()));

    WebElement displayedElementUserName = driver.findElement(By.xpath("//table//th[4][contains(text(),'firstname')]")).findElement(By.xpath("//table//th[4][contains(text(),'"+user.getUserFirstName()+"')]"));
    String displayedUserName = displayedElementUserName.getText();
    Assert.assertTrue(displayedUserName.contains( user.getUserFirstName()));

    WebElement displayedElementUserLastName = driver.findElement(By.xpath("//table//th[5][contains(text(),'lastname')]")).findElement(By.xpath("//table//th[5][contains(text(),'"+user.getUserLastName()+"')]"));
    String displayedUserLastName = displayedElementUserLastName.getText();
    Assert.assertTrue(displayedUserLastName.contains( user.getUserLastName()));

}

public void openLoginPage(User user){

    String winHandleBefore = driver.getWindowHandle();
    loginLink.click();
    for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
    }


}




}
