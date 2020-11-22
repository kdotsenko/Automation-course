package Pages;

import Data.Good;
import Data.TestChallengeDataCollections;
import Data.TestClass;
import Data.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ChallengeEightPage  {
    WebDriver driver;

    public ChallengeEightPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    @FindBy(name = "selling")
    @CacheLookup
    private WebElement sellingNameField;

    @FindBy(name = "description")
    @CacheLookup
    private WebElement sellingDescriptionField;

    @FindBy(name = "start_date")
    @CacheLookup
    private WebElement startDateField;

    @FindBy(name = "end_date")
    @CacheLookup
    private WebElement endDateField;

    @FindBy(name = "formSubmit")
    @CacheLookup
    private WebElement sendButton;



    @FindBy(xpath="//table/tbody/tr[2]")
            @CacheLookup private WebElement rowToDelete;

    @FindBy(xpath="//div[contains(@class, 'confirm t15')]")
            @CacheLookup private WebElement auctionTable;

    public void enterGoodsData(Good good) {

        sellingNameField.sendKeys(good.getGoodName());
        sellingDescriptionField.sendKeys(good.getGoodDescription());
        startDateField.clear();
        startDateField.sendKeys(good.getStartDate());
        endDateField.clear();
        if(validGoodTest()==true){
        endDateField.sendKeys(good.getEndDate());}
        else{
            endDateField.sendKeys("dghjhgjhgdh");
        }
        sendButton.click();

    }

    public void verifyGoodsDetailsDisplayedCorrectly(Good good) {

        WebElement displayedElementGoodName = driver.findElement(By.xpath("//table//td[1][contains(text(),'Selling')]")).findElement(By.xpath("//table//td[1][contains(text(),'" + good.getGoodName() + "')]"));
        String displayedGoodName = displayedElementGoodName.getText();
        Assert.assertTrue(displayedGoodName.contains(good.getGoodName()));

        WebElement displayedElementGoodDescription = driver.findElement(By.xpath("//table//td[2][contains(text(),'Description')]")).findElement(By.xpath("//table//td[2][contains(text(),'" + good.getGoodDescription() + "')]"));
        String displayedGoodDescription = displayedElementGoodDescription.getText();
        Assert.assertTrue(displayedGoodDescription.contains(good.getGoodDescription()));

        WebElement displayedElementGoodStartTime = driver.findElement(By.xpath("//table//td[3][contains(text(),'Start date')]")).findElement(By.xpath("//table//td[3][contains(text(),'" + good.getStartDate() + "')]"));
        String displayedGoodStartDate = displayedElementGoodStartTime.getText();
        Assert.assertTrue(displayedGoodStartDate.contains(good.getStartDate()));

        WebElement displayedElementGoodEndTime = driver.findElement(By.xpath("//table//td[4][contains(text(),'End date')]")).findElement(By.xpath("//table//td[4][contains(text(),'" + good.getEndDate() + "')]"));
        String displayedGoodEndDate = displayedElementGoodEndTime.getText();
        Assert.assertTrue(displayedGoodEndDate.contains(good.getEndDate()));

    }

    public void deleteSecondItem(Good good){

       WebElement deleteButton = driver.findElement(By.xpath("//table/tbody/tr[td//text()[contains(., '"+ good.getGoodName()+"')]]/td[5]/a[contains(text(),'Delete')]"));

       deleteButton.click();
    }

    public Boolean checkDeletedGood(Good good){
        String removedGoodXpath="//table/tbody/tr[td//text()[contains(., '"+ good.getGoodName()+"')]]/td[5]/a[contains(text(),'Delete')]";
        List<WebElement> removedGood = auctionTable.findElements(By.xpath(removedGoodXpath));
        if (removedGood.size()!=0){
            return true;
        } else{
            return false;
        }
    }

    public void verifyGoodIsDeleted(Good good){
        Assert.assertFalse(checkDeletedGood(good));
    }

public Boolean validGoodTest(){
        if (TestClass.isValidGoodDataTest ==true){
            return true;
        }
        return false;
}

public void verifyIncorrectDataValidation(){

  String alertValidationMessage= driver.switchTo().alert().getText();
   Assert.assertEquals("There are some issues with your input\"\n" +
           "End time not recognized. Please use HH:MM 12 hours  \\n\"", alertValidationMessage);
   driver.switchTo().alert().accept();
}


}

