package com.promage.pages;

import com.promage.base.BasePage;
import com.promage.forms.TaskFormComponent;
import org.openqa.selenium.By;

public class TaskPage extends BasePage {

    private By taskHeader = By.xpath("//h1[contains(@class, 'font-medium')]//span[text()='Task']");
    private By assignTaskButton = By.xpath("//button[text()='Assign task']");
    private By newTaskDescription = By.xpath("//tbody//tr[1]//td[1][text()='Implement authorization for DBKS portal']");
    private By employeeAssignedToTask = By.xpath("//table/tbody/tr[1]/td[2][text()='Tom Parker']");
    private By checkedTask = By.xpath("//table/tbody/tr[1]/td[3]/div[text()='No']");
    private By taskStatus = By.xpath("//table/tbody/tr[1]/td[4]/div[text()='On going']");
    private By reviwedTaskDescription = By.xpath("//tbody//tr[1]//td[1][text()='Refactor Authentication implementation']");
    private By reviewTaskStatus = By.xpath("//table/tbody/tr[1]/td[4]/div[text()='Approved']");


    public boolean isTaskPageDisplayed() {
        waitForElementVisibility(taskHeader, 20);
        return find(taskHeader).isDisplayed();
    }

    public TaskFormComponent clickAssignTaskButton() {
        click(assignTaskButton);
        return new TaskFormComponent();
    }

    public TaskFormComponent clickReviewTaskButton(String taskDescription) {
        click(By.xpath("//tbody//tr[1]//td[1][text()='" + taskDescription + "']/..//button[text()='Review']"));

        return new TaskFormComponent();
    }

    public String getTaskDescription() {
        waitForElementVisibility(newTaskDescription, 20);
        return find(newTaskDescription).getText();
    }

    public String getTaskAssignedToEmployee() {
        return find(employeeAssignedToTask).getText();
    }

    public String getCheckedTask() {
        return find(checkedTask).getText();
    }

    public String getTaskStatus() {
        return find(taskStatus).getText();
    }

    public String getReviewedTaskDescription() {
        waitForElementVisibility(reviwedTaskDescription, 20);
        return find(reviwedTaskDescription).getText();
    }

    public String getReviewedTaskStatus() {
        return find(reviewTaskStatus).getText();
    }


}
