package com.promage.test.forms;

import com.promage.base.BaseTest;
import com.promage.forms.ProjectFormComponent;
import com.promage.pages.DashboardPage;
import com.promage.test.SignInTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectFormTest extends BaseTest {

    @Test
    public void testProjectCreation() {
        DashboardPage dashboardPage = signInPage.logIntoApplication("john.harris@gmail.com", "JHN789");
        Assert.assertTrue(dashboardPage.isDashboardheaderDisplayed(), "\n Sign in was not successful \n");

        ProjectFormComponent projectFormComponent = dashboardPage.clickCreateNewProjectTab();
        Assert.assertTrue(projectFormComponent.isProjectFormDisplayed());

        String[] projectTeam = {"Charlie Brown", "Bob Smith"};
        projectFormComponent.fillProjectForm("Nelsa Web Application", "Alice Johnson", "600", "On going", "70", "26", projectTeam);

        String newProjectName = dashboardPage.getNewProjectName();
        String newProjectManager = dashboardPage.getNewProjectManager();
        String newProjectStatus = dashboardPage.getNewProjectStatus();

        Assert.assertEquals(newProjectName, "Nelsa Web Application");
        Assert.assertEquals(newProjectManager, "Alice Johnson");
        Assert.assertEquals(newProjectStatus, "On going");
    }
}
