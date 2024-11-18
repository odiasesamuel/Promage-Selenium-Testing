package com.promage.forms;

import com.promage.base.BasePage;
import com.promage.pages.TaskPage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clearInputField;

public class TaskFormComponent extends BasePage {

    private By taskFormHeader = By.xpath("//h2[text()='Assign task']");
    private By taskdescriptionInputField = By.name("task_description");
    private By assignedToSelectField = By.xpath("//label[text()='Assigned to']/following-sibling::select");
    private By taskStatusSelectField = By.xpath("//label[text()='Status']/following-sibling::select");
    private By assignTaskButton = By.xpath("//button[text()='Assign Task']");
    private By reviewTaskButton = By.xpath("//button[text()='Review Task']");
    private By deleteTaskButton = By.xpath("//button[text()='Delete Task']");
    private By confirmTaskDeleteButton = By.xpath("//button[text()='Continue']");

    public boolean isTaskFormDisplayed() {
        waitForElementVisibility(taskFormHeader, 20);
        return find(taskFormHeader).isDisplayed();
    }

    public TaskPage clickAssignTaskButton() {
        click(assignTaskButton);
        return new TaskPage();
    }

    public TaskPage clickReviewTaskButton() {
        click(reviewTaskButton);
        return new TaskPage();
    }

    public TaskPage clickDeleteTaskButton() {
        click(deleteTaskButton);
        click(confirmTaskDeleteButton);
        return new TaskPage();
    }

    public TaskPage assignTaskForm(String taskDescription, String assignedTo) {
        set(taskdescriptionInputField, taskDescription);
        selectVisibleText(assignedToSelectField, assignedTo);

        return clickAssignTaskButton();
    }

    public TaskPage reviewTaskForm(String taskDescription, String taskStatus) {
        clearInputField(taskdescriptionInputField);
        set(taskdescriptionInputField, taskDescription);
        selectVisibleText(taskStatusSelectField, taskStatus);

        return clickReviewTaskButton();
    }
}
