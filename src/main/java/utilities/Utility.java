package utilities;

import com.promage.base.BasePage;
import org.openqa.selenium.WebDriver;

public class Utility {

    public static WebDriver driver;

    public static void setUtiliyDriver() {
        driver = BasePage.driver;
    }
}
