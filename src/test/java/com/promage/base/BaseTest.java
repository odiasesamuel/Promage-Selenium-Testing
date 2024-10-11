package com.promage.base;

import com.promage.pages.DashboardPage;
import com.promage.pages.SignInPage;
import com.promage.pages.SignUpPage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
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
        testData = new Properties();
        try {
            FileInputStream input = new FileInputStream("src/test/resources/testData.properties");
            testData.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String browser = testData.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void loadApplication() {
        driver.get(testData.getProperty("url"));
        basePage = new BasePage();
        basePage.setDriver(driver);
        setUtiliyDriver();
        signInPage = new SignInPage();
    }

    @AfterMethod
    public void takeFailedResultScreenshot(ITestResult testResult) {
        if (ITestResult.FAILURE == testResult.getStatus()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshots/(" +
                    java.time.LocalDate.now() + ") " +
                    testResult.getName() + ".png");
            try {
                FileHandler.copy(source, destination);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Screenshot Located At " + destination);
        }
    }

    @AfterClass
    public void tearDown() {
        delay(3000);
//        driver.quit();
    }
}
