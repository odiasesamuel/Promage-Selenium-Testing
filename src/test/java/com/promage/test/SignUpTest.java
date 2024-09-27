package com.promage.test;

import com.promage.base.BaseTest;
import com.promage.pages.DashboardPage;
import com.promage.pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utilities.JavaScriptUtility.clearSessionStorage;

public class SignUpTest extends BaseTest {

    @Test
    public void testSignUpError() {
        clearSessionStorage();
        SignUpPage signUpPage = signInPage.clickLinkToSignUpPage();

        Assert.assertTrue(signUpPage.isOrganisationFormDisplayed(), "\n Organisation form is not displayed \n");
        signUpPage.fillOrganisationDetailsForm("Boltzmenn", "boltzmenn@gmail.com","Biodun Ajayi", "biodunajayi@gmail.com");

        Assert.assertTrue(signUpPage.isEmployeeFormDisplayed(), "\n Employee form is not displayed \n");
        signUpPage.fillEmployeeDetailsForm("Kunle Ojo", "kunle.ojo@gamil.com", "Software Engineer");
        signUpPage.fillEmployeeDetailsForm("Peter Ejehi", "peter.ejehi@gmail.com", "Product Designer");
        signUpPage.clickNextIcon();

        Assert.assertTrue(signUpPage.isMetricFormDisplayed(), "\n Metrics form is not displayed \n");
        DashboardPage dashboardPage = signUpPage.fillMetricDetailForm("600000000", "10", "12000", "12");

        Assert.assertTrue(signUpPage.isErrorModalDisplayed(), "\n Error Modal was not displayed Signup was successful \n");

    }

    @Test
    public void testSuccessfulSignUp() {
        clearSessionStorage();
        SignUpPage signUpPage = signInPage.clickLinkToSignUpPage();

        Assert.assertTrue(signUpPage.isOrganisationFormDisplayed(), "\n Organisation form is not displayed \n ");
        signUpPage.fillOrganisationDetailsForm("Lamdex Enterprise", "lamdex_enterprise@gmail.com","Biodun Ajayi", "biodunajayi@gmail.com");

        Assert.assertTrue(signUpPage.isEmployeeFormDisplayed(), "\n Employee form is not displayed \n");
        signUpPage.fillEmployeeDetailsForm("Kunle Ojo", "kunle.ojo@gamil.com", "Software Engineer");
        signUpPage.fillEmployeeDetailsForm("Peter Ejehi", "peter.ejehi@gmail.com", "Product Designer");
        signUpPage.clickNextIcon();

        Assert.assertTrue(signUpPage.isMetricFormDisplayed(), "\n Metrics form is not displayed \n ");
        DashboardPage dashboardPage = signUpPage.fillMetricDetailForm("600000000", "10", "12000", "12");

        Assert.assertTrue(dashboardPage.isDashboardheaderDisplayed(), "\n Signup was not successful \n");
    }

}