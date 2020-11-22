package Data;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    private static WebDriver driver;
    @Override
    public void onTestStart(ITestResult context){
        BrowserManager.openBrowser();

    }



    @Override
    public void onFinish(ITestContext context) {
        BrowserManager.closeBrowser();
    }


}
