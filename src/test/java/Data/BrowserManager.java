package Data;

import Data.Good;
import Data.TestChallengeDataCollections;
import Data.User;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static Data.GoodFactory.testGood;
import static Data.UserFactory.testUser;


public class BrowserManager {
        public static WebDriver driver;
        public static ChallengeOnePage challengeOnePage;
        public static TestChallengeDataCollections testChallengeDataCollections;
        public static ChallengeTenPage challengeTenPage;
        public static LoginPage loginPage;
        public static ApplicationOfChallengeTenPage applicationOfChallengeTenPage;
        public static User user;
        public static Good good;
        public static ChallengeEightPage challengeEightPage;
        public static ChallengeFourPage challengeFourPage;




       public static void openBrowser() {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Asus X540LJ\\IdeaProjects\\TestAutomationCourse\\src\\test\\java\\browsers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("http://testingchallenges.thetestingmap.org/index.php");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

           challengeOnePage = new ChallengeOnePage(driver);
           testChallengeDataCollections = new TestChallengeDataCollections();
           challengeTenPage = new ChallengeTenPage(driver);
           loginPage = new LoginPage(driver);
           applicationOfChallengeTenPage=new ApplicationOfChallengeTenPage(driver);
            user = testUser();
            challengeEightPage=new ChallengeEightPage(driver);
            good=testGood();
           challengeFourPage=new ChallengeFourPage(driver);
        }

@AfterTest
        public static void closeBrowser() {
            driver.quit();
        }
    }


