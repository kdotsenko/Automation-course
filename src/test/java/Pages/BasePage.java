package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage{

    public static WebDriver driver;

    public static <T extends BasePage> T initPage(Class<T> pageClass) {
        return PageFactory.initElements(driver, pageClass);
    }


}


