package com.promage.base;

import com.promage.pages.DashboardPage;
import com.promage.pages.SignInPage;
import com.promage.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import static com.promage.base.BasePage.delay;
import static utilities.Utility.setUtiliyDriver;

public class BaseTest {

    private WebDriver driver;
    protected BasePage basePage;
    protected SignInPage signInPage;
    private String PROMAGE_URL = "https://promage-project-management-system.onrender.com/";

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(PROMAGE_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtiliyDriver();
        signInPage = new SignInPage();
    }

    @AfterClass
    public void tearDown() {
        delay(3000);
        driver.quit();
    }
}
