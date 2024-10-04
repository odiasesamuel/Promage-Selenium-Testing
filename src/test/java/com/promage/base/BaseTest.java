package com.promage.base;

import com.promage.pages.DashboardPage;
import com.promage.pages.SignInPage;
import com.promage.pages.SignUpPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.promage.base.BasePage.delay;
import static utilities.Utility.setUtiliyDriver;

public class BaseTest {

    private WebDriver driver;
    protected BasePage basePage;
    protected SignInPage signInPage;
    protected Properties testData;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        testData = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/test/resources/testData.properties");
            testData.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(testData.getProperty("url"));
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtiliyDriver();
        signInPage = new SignInPage();
    }

    @AfterClass
    public void tearDown() {
        delay(3000);
//        driver.quit();
    }
}
