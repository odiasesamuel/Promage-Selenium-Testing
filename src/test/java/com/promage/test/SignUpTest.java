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
        signUpPage.fillOrganisationDetailsForm(testData.getProperty("organisationNameError"), testData.getProperty("organisationEmailError"),testData.getProperty("administratorName"), testData.getProperty("administratorEmail"));

        Assert.assertTrue(signUpPage.isEmployeeFormDisplayed(), "\n Employee form is not displayed \n");
        signUpPage.fillEmployeeDetailsForm(testData.getProperty("employeeName1"), testData.getProperty("employeeEmail1"), testData.getProperty("jobTitle1"));
        signUpPage.fillEmployeeDetailsForm(testData.getProperty("employeeName2"), testData.getProperty("employeeEmail2"), testData.getProperty("jobTitle2"));
        signUpPage.clickNextIcon();

        Assert.assertTrue(signUpPage.isMetricFormDisplayed(), "\n Metrics form is not displayed \n");
        DashboardPage dashboardPage = signUpPage.fillMetricDetailForm(testData.getProperty("revenueForLastQuarter"), testData.getProperty("projectForLastQuarter"), testData.getProperty("timeForLastQuarter"), testData.getProperty("numberOfEmployeeLastQuarter"));

        Assert.assertTrue(signUpPage.isErrorModalDisplayed(), "\n Error Modal was not displayed Signup was successful \n");

    }

    @Test
    public void testSuccessfulSignUp() {
        clearSessionStorage();
        SignUpPage signUpPage = signInPage.clickLinkToSignUpPage();

        Assert.assertTrue(signUpPage.isOrganisationFormDisplayed(), "\n Organisation form is not displayed \n ");
        signUpPage.fillOrganisationDetailsForm(testData.getProperty("organisationName"), testData.getProperty("organisationEmail"),testData.getProperty("administratorName"), testData.getProperty("administratorEmail"));

        Assert.assertTrue(signUpPage.isEmployeeFormDisplayed(), "\n Employee form is not displayed \n");
        signUpPage.fillEmployeeDetailsForm(testData.getProperty("employeeName1"), testData.getProperty("employeeEmail1"), testData.getProperty("jobTitle1"));
        signUpPage.fillEmployeeDetailsForm(testData.getProperty("employeeName2"), testData.getProperty("employeeEmail2"), testData.getProperty("jobTitle2"));
        signUpPage.clickNextIcon();

        Assert.assertTrue(signUpPage.isMetricFormDisplayed(), "\n Metrics form is not displayed \n ");
        DashboardPage dashboardPage = signUpPage.fillMetricDetailForm(testData.getProperty("revenueForLastQuarter"), testData.getProperty("projectForLastQuarter"), testData.getProperty("timeForLastQuarter"), testData.getProperty("numberOfEmployeeLastQuarter"));

        Assert.assertTrue(dashboardPage.isDashboardheaderDisplayed(), "\n Signup was not successful \n");
    }

}