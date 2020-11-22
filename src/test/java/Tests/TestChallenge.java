package Tests;
import Data.*;
import Pages.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners(Listener.class)
public class TestChallenge extends BrowserManager {



    @Test (priority = 1)
    public void challengeNumberOne() {

        int theElement = 0;
        while (theElement < testChallengeDataCollections.amountOfElements()) {
            String testElement = testChallengeDataCollections.getData(theElement);
            challengeOnePage.enterTestData(testElement);
            challengeOnePage.verifyNameIsDisplayedCorrectly(testElement);
            challengeOnePage = new ChallengeOnePage(driver);
            theElement++;
        }
        challengeOnePage.verifyCountsAreDisplayedCorrectly(theElement);
    }


    @Test (priority = 2)
    public void challengeNumberTen() {
        challengeOnePage.openChallengeTenPage(driver);
        challengeTenPage.enterLoginPasswordFirstAndLastNameAndSubmit(user);
        challengeTenPage.verifyDisplayedUserDetails(user);
        challengeTenPage.openLoginPage(user);
        loginPage.login(user);
        applicationOfChallengeTenPage.verifyUserIsLoggedIn();

    }




    @Test (priority = 3)
    public void challengeNumberEightEnterAndVerifyData(){
        TestClass.isValidGoodDataTest =true;
        challengeOnePage.openChallengeEightPage();
        int numberOfGoodsEntered=0;
        while(numberOfGoodsEntered<testChallengeDataCollections.amountOfGoods(good)) {
            challengeEightPage.enterGoodsData(testChallengeDataCollections.getGoodsData(good,numberOfGoodsEntered));
            challengeEightPage = new ChallengeEightPage(driver);
            challengeEightPage.verifyGoodsDetailsDisplayedCorrectly(testChallengeDataCollections.getGoodsData(good,numberOfGoodsEntered));
            numberOfGoodsEntered++;
        }
    }



    @Test (priority = 4)
    public void challengeNumberEightEnterAndDeleteData(){
        TestClass.isValidGoodDataTest =true;
        challengeOnePage.openChallengeEightPage();
        int numberOfGoodsEntered=0;
        while(numberOfGoodsEntered<testChallengeDataCollections.amountOfGoods(good)) {
            challengeEightPage.enterGoodsData(testChallengeDataCollections.getGoodsData(good,numberOfGoodsEntered));
            challengeEightPage = new ChallengeEightPage(driver);
            challengeEightPage.verifyGoodsDetailsDisplayedCorrectly(testChallengeDataCollections.getGoodsData(good,numberOfGoodsEntered));
            numberOfGoodsEntered++;
        }
        challengeEightPage.deleteSecondItem(good);
        challengeEightPage.verifyGoodIsDeleted(good);

    }

    @Test (priority = 5)
    public void challengeNumberEightEnterInvalidData(){
        TestClass.isValidGoodDataTest =false;
        challengeOnePage.openChallengeEightPage();
        challengeEightPage.enterGoodsData(good);
        challengeEightPage.verifyIncorrectDataValidation();
    }


    @Test (priority = 6)
    public void challengeFour(){
        challengeOnePage.openChallengeFourPage();
        int numberOfEneteredCPNs =0;
       while (numberOfEneteredCPNs<5) {
            challengeFourPage.enterCPN();
            challengeFourPage.submitResult();
            challengeFourPage=new ChallengeFourPage(driver);
            numberOfEneteredCPNs++;
        }
       challengeFourPage.verifySuccess();

    }


}
