package com.promage.test;

import com.promage.base.BaseTest;
import com.promage.forms.ProjectFormComponent;
import com.promage.pages.DashboardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    @Test(priority = 1)
    public void testProjectCreation() {
        DashboardPage dashboardPage = signInPage.logIntoApplication(testData.getProperty("signInSuccessEmployeeEmail"), testData.getProperty("signInSuccessEmployeeID"));
        Assert.assertTrue(dashboardPage.isDashboardheaderDisplayed(), "\n Sign in was not successful \n");

        ProjectFormComponent projectFormComponent = dashboardPage.clickCreateNewProjectTab();
        Assert.assertTrue(projectFormComponent.isProjectFormDisplayed());

        String[] projectTeam = testData.getProperty("teamMembers").split(",");
        projectFormComponent.fillProjectForm(testData.getProperty("projectName"), testData.getProperty("projectManager"), testData.getProperty("projectRevenue"), testData.getProperty("projectStatus"), testData.getProperty("projectProgress"), testData.getProperty("projectDueDate"), projectTeam);

        String newProjectName = dashboardPage.getNewProjectName();
        String newProjectManager = dashboardPage.getNewProjectManager();
        String newProjectStatus = dashboardPage.getNewProjectStatus();

        Assert.assertEquals(newProjectName, testData.getProperty("projectName"), "\n Project name isn't" + testData.getProperty("projectName") + "\n");
        Assert.assertEquals(newProjectManager, testData.getProperty("projectManager"), "\n Project manager isn't" + testData.getProperty("projectManager") + "\n");
        Assert.assertEquals(newProjectStatus, testData.getProperty("projectStatus"), "\n Project status isn't" + testData.getProperty("projectStatus") + "\n");
    }

}
