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
        String taskCheck = taskPage.getCheckedTask();
        String taskStatus = taskPage.getTaskStatus();

        Assert.assertEquals(taskDescription, testData.getProperty("newTask"), "\n Task Description isn't" + testData.getProperty("newTask") + "\n");
        Assert.assertEquals(taskAssignedToEmployee, testData.getProperty("assignedTo"), "\n Employee assigned task isn't" + testData.getProperty("assignedTo") + "\n");
        Assert.assertEquals(taskCheck, "No", "\n Task Description isn't No \n");
        Assert.assertEquals(taskStatus, "On going", "\n Task Description isn't on going \n");


    }

//    @Test(dependsOnMethods = {"testAssigningNewTask"})
    @Test
    public void checkTaskInAssignedEmployeeDashboard() {
        DashboardPage taskAssignedToEmployeeDashboardPage = signInPage.logIntoApplication(testData.getProperty("assignedToEmployeeEmail"), testData.getProperty("assignedToEmployeeId"));
    }

    @Test(dependsOnMethods = {"checkTaskInAssignedEmployeeDashboard"})
    public void testCheckingTask() {

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
        String reviewedTaskStatus = taskPage.getReviewedTaskStatus();

        Assert.assertEquals(reviewedTaskDescription, testData.getProperty("reviewTaskName"));
        Assert.assertEquals(reviewedTaskStatus, testData.getProperty("reviewTaskStatus"));
    }
}
