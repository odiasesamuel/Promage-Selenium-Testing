package com.promage.test;

import com.promage.base.BasePage;
import com.promage.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseTest {

    @Test
    public void testLoginError() {
        signInPage.setEmailInputField("peter.quil@gmail.com");
        signInPage.setEmployeeIDInputField("PET490");
        signInPage.clickSignInButton();
        String actualErrorMessage = signInPage.getErrorMessage();

        Assert.assertTrue(actualErrorMessage.contains("Could not authenticate employee"));
    }
}
