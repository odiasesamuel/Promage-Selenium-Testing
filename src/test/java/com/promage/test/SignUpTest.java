package com.promage.test;

import com.promage.base.BaseTest;
import com.promage.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest extends BaseTest {

    @Test
    public void testSignUpPageHeaderIsDisplayed() {
        SignUpPage signUpPage = signInPage.clickLinkToSignUpPage();
        Assert.assertTrue(signUpPage.isNavigationTextBackToSignInPageDisplayed(),"\n Already part of an organization?Sign in not displayed");
    }

    @Test
    public void testSignUpForm() {
        signInPage.clickLinkToSignUpPage();
        signUpPage.fillOrganisationDetailsForm("Lamdex Enterprise", "lamdex@gmail.com","Biodun Ajayi", "biodunajayi@gmail.com");
    }
}