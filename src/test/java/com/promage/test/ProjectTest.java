package com.promage.test;

import com.promage.base.BaseTest;
import com.promage.forms.ProjectFormComponent;
import com.promage.pages.DashboardPage;
import com.promage.pages.ProjectPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {

    @Test(priority = 2)
    public void testReviewProject() {
        DashboardPage dashboardPage = signInPage.logIntoApplication(testData.getProperty("signInSuccessEmployeeEmail"), testData.getProperty("signInSuccessEmployeeID"));
        Assert.assertTrue(dashboardPage.isDashboardheaderDisplayed(), "\n Sign in was not successful \n");

        ProjectPage projectPage = dashboardPage.navigateToProjectPage();
        Assert.assertTrue(projectPage.isProjectPageDisplayed());

       ProjectFormComponent projectFormComponent = projectPage.clickReviewProjectButton(testData.getProperty("projectName"));
       projectFormComponent.reviewProjectForm(testData.getProperty("reviewProjectName"), testData.getProperty("reviewProjectManager"), testData.getProperty("reviewProjectRevenue"), testData.getProperty("reviewProjectStatus"), testData.getProperty("reviewProjectProgress"));

        String reviewedProjectName = projectPage.getReviwedProjectName();
        String reviewedProjectManager = projectPage.getReviwedProjectManager();
        String reviewedProjectStatus = projectPage.getReviwedProjectStatus();

        Assert.assertEquals(reviewedProjectName, testData.getProperty("reviewProjectName"), "\n Project name isn't" + testData.getProperty("reviewProjectName") + "\n");
        Assert.assertEquals(reviewedProjectManager, testData.getProperty("reviewProjectManager"), "\n Project manager isn't" + testData.getProperty("reviewProjectManager") + "\n");
        Assert.assertEquals(reviewedProjectStatus, testData.getProperty("reviewProjectStatus"), "\n Project status isn't" + testData.getProperty("reviewProjectStatus") + "\n");
    }

    @Test(priority = 3)
    public void testProjectDeletion() {
        DashboardPage dashboardPage = signInPage.logIntoApplication(testData.getProperty("signInSuccessEmployeeEmail"), testData.getProperty("signInSuccessEmployeeID"));
        Assert.assertTrue(dashboardPage.isDashboardheaderDisplayed(), "\n Sign in was not successful \n");

        ProjectPage projectPage = dashboardPage.navigateToProjectPage();
        Assert.assertTrue(projectPage.isProjectPageDisplayed());

        ProjectFormComponent projectFormComponent = projectPage.clickReviewProjectButton(testData.getProperty("reviewProjectName"));
        projectFormComponent.clickDeleteProjectButton();

        Assert.assertFalse(projectPage.isReviewedProjectDisplayed(), "\n Reviewed Project is still displayed on the project table \n");
    }
}
