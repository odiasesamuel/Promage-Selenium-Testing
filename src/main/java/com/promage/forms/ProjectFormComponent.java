package com.promage.forms;

import com.promage.base.BasePage;
import com.promage.pages.DashboardPage;
import com.promage.pages.ProjectPage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.clearInputField;

public class ProjectFormComponent extends BasePage {

    private By projectFormHeader = By.xpath("//h2[text()='Create a new project']");
    private By projectNameInputField = By.name("projectName");
    private By projectManagerSelectField = By.xpath("//label[text()='Project Manager']/following-sibling::select");
    private By projectRevenueInputField = By.name("revenue");
    private By projectStatusSelectField = By.xpath("//label[text()='Status']/following-sibling::select");
    private By projectProgressInputField = By.name("progress");
    private By projectDueDateInputField = By.xpath("//span[text()='Pick a date']/..");
    private By projectTeamSelectField = By.cssSelector("input[role='combobox'][aria-autocomplete='list']");
    private By createProjectButton = By.xpath("//button[text()='Create Project']");
    private By reviewProjectButton = By.xpath("//button[text()='Review Project']");
    private By deleteProjectButton = By.xpath("//button[text()='Delete Project']");
    private By confirmProjectDeleteButton = By.xpath("//button[text()='Continue']");

    public boolean isProjectFormDisplayed() {
        waitForElementVisibility(projectFormHeader, 10);
        return find(projectFormHeader).isDisplayed();
    }

    public DashboardPage clickCreateProjectButtonButton() {
        click(createProjectButton);
        reloadPage();
        return new DashboardPage();
    }

    public ProjectPage clickReviewProjectButton() {
        click(reviewProjectButton);
        return new ProjectPage();
    }

    public ProjectPage clickDeleteProjectButton() {
        click(deleteProjectButton);
        click(confirmProjectDeleteButton);
        return new ProjectPage();
    }

    public DashboardPage fillProjectForm(String projectName, String projectManager, String projectRevenue, String projectStatus, String projectProgress, String projectDueDate, String[] projectTeam) {
        set(projectNameInputField, projectName);
        selectVisibleText(projectManagerSelectField, projectManager);
        set(projectRevenueInputField, projectRevenue);
        selectVisibleText(projectStatusSelectField, projectStatus);
        set(projectProgressInputField, projectProgress);
        click(projectDueDateInputField);
        click(By.xpath("//button[text()='" + projectDueDate + "']"));
        for (String teamMember: projectTeam) {
            set(projectTeamSelectField, teamMember);
            click(By.xpath("//div[text()='" + teamMember + "']")
            );
        }

        return clickCreateProjectButtonButton();
    }

    public ProjectPage reviewProjectForm(String projectName, String projectManager, String projectRevenue, String projectStatus, String projectProgress) {
        clearInputField(projectNameInputField);
        set(projectNameInputField, projectName);
        selectVisibleText(projectManagerSelectField, projectManager);
        clearInputField(projectRevenueInputField);
        set(projectRevenueInputField, projectRevenue);
        selectVisibleText(projectStatusSelectField, projectStatus);

        return clickReviewProjectButton();
    }



}
