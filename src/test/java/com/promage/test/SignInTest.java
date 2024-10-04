package com.promage.test;

import com.promage.base.BaseTest;
import com.promage.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    @Test
    public void testSignInError() {
        signInPage.setEmailInputField(testData.getProperty("signInErrorEmployeeEmail"));
        signInPage.setEmployeeIDInputField(testData.getProperty("signInErrorEmployeeID"));
        signInPage.clickSignInButton();
        String actualErrorMessage = signInPage.getErrorMessage();

        Assert.assertTrue(actualErrorMessage.contains("Could not authenticate employee"));
    }

    @Test
    public void testSuccessfulSignIn() {
        DashboardPage dashboardPage = signInPage.logIntoApplication(testData.getProperty("signInSuccessEmployeeEmail"), testData.getProperty("signInSuccessEmployeeID"));

        Assert.assertTrue(dashboardPage.isDashboardheaderDisplayed(), "Sign in was not successful");
    }
}
