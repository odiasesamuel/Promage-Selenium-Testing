package com.promage.test;

import com.promage.base.BaseTest;
import com.promage.forms.TaskFormComponent;
import com.promage.pages.DashboardPage;
import com.promage.pages.TaskPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TaskTest extends BaseTest {

    @Test
    public void testAssigningNewTask() {
        DashboardPage dashboardPage = signInPage.logIntoApplication(testData.getProperty("signInSuccessEmployeeEmail"), testData.getProperty("signInSuccessEmployeeID"));
        Assert.assertTrue(dashboardPage.isDashboardheaderDisplayed(), "\n Sign in was not successful \n");

        TaskPage taskPage = dashboardPage.navigateToTaskPage();
        Assert.assertTrue(taskPage.isTaskPageDisplayed());

        TaskFormComponent taskFormComponent = taskPage.clickAssignTaskButton();
        Assert.assertTrue(taskFormComponent.isTaskFormDisplayed());
        taskFormComponent.assignTaskForm(testData.getProperty("newTask"), testData.getProperty("assignedTo"));

        String taskDescription = taskPage.getTaskDescription();
        String taskAssignedToEmployee = taskPage.getTaskAssignedToEmployee();
        String taskCheck = taskPage.getUnCheckedTask();
        String taskStatus = taskPage.getTaskStatus();

        Assert.assertEquals(taskDescription, testData.getProperty("newTask"), "\n Task Description isn't" + testData.getProperty("newTask") + "\n");
        Assert.assertEquals(taskAssignedToEmployee, testData.getProperty("assignedTo"), "\n Employee assigned task isn't" + testData.getProperty("assignedTo") + "\n");
        Assert.assertEquals(taskCheck, "No", "\n Task isn't checked as No \n");
        Assert.assertEquals(taskStatus, "On going", "\n Task isn't on going \n");


    }

    @Test(dependsOnMethods = {"testAssigningNewTask"})
    public void checkTaskInAssignedEmployeeDashboard() {
        DashboardPage taskAssignedToEmployeeDashboardPage = signInPage.logIntoApplication(testData.getProperty("assignedToEmployeeEmail"), testData.getProperty("assignedToEmployeeId"));
        Assert.assertTrue(taskAssignedToEmployeeDashboardPage.isDashboardheaderDisplayed(), "\n Sign in was not successful \n");

        taskAssignedToEmployeeDashboardPage.clickAssignedTask();

        String checkboxState = taskAssignedToEmployeeDashboardPage.checkboxState();

        Assert.assertEquals(checkboxState, "checked", "\n The assigned task is unchecked \n");

    }

    @Test(dependsOnMethods = {"testAssigningNewTask"})
    public void testReviewTask() {
        DashboardPage dashboardPage = signInPage.logIntoApplication(testData.getProperty("signInSuccessEmployeeEmail"), testData.getProperty("signInSuccessEmployeeID"));
        Assert.assertTrue(dashboardPage.isDashboardheaderDisplayed(), "\n Sign in was not successful \n");

        TaskPage taskPage = dashboardPage.navigateToTaskPage();
        Assert.assertTrue(taskPage.isTaskPageDisplayed());

        TaskFormComponent taskFormComponent = taskPage.clickReviewTaskButton(testData.getProperty("newTask"));
        taskFormComponent.reviewTaskForm(testData.getProperty("reviewTaskName"), testData.getProperty("reviewTaskStatus"));

        String reviewedTaskDescription = taskPage.getReviewedTaskDescription();
        String taskCheck = taskPage.getCheckedTask();
        String reviewedTaskStatus = taskPage.getReviewedTaskStatus();

        Assert.assertEquals(reviewedTaskDescription, testData.getProperty("reviewTaskName"));
        Assert.assertEquals(taskCheck, "Yes", "\n Task isn't checked as Yes \n");
        Assert.assertEquals(reviewedTaskStatus, testData.getProperty("reviewTaskStatus"));
    }


    @Test(dependsOnMethods = {"testAssigningNewTask"})
    public void testTaskDeletion() {
        DashboardPage dashboardPage = signInPage.logIntoApplication(testData.getProperty("signInSuccessEmployeeEmail"), testData.getProperty("signInSuccessEmployeeID"));
        Assert.assertTrue(dashboardPage.isDashboardheaderDisplayed(), "\n Sign in was not successful \n");

        TaskPage taskPage = dashboardPage.navigateToTaskPage();
        Assert.assertTrue(taskPage.isTaskPageDisplayed());

        TaskFormComponent taskFormComponent = taskPage.clickReviewTaskButton(testData.getProperty("reviewTaskName"));
        taskFormComponent.clickDeleteTaskButton();

        Assert.assertFalse(taskPage.isReviewedTaskDisplayed(), "\n Reviewed Task is still displayed on the Task table \n");
    }

}
