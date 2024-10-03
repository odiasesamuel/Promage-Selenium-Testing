package com.promage.forms;

import com.promage.base.BasePage;
import com.promage.pages.DashboardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ProjectFormComponent extends BasePage {

    private By projectFormHeader = By.xpath("//h2[text()='Create a new project']");
    private By projectNameInputField = By.name("projectName");
    private By projectManagerSelectField = By.xpath("//label[text()='Project Manager']/following-sibling::select");
    private By projectRevenueInputField = By.name("revenue");
    private By projectStatusSelectField = By.xpath("//label[text()='Status']/following-sibling::select");
    private By projectProgressInputField = By.name("progress");
    private By projectDueDateInputField = By.xpath("//span[text()='Pick a date']/..");
    private By projectTeamSelectField = By.cssSelector("input[role='combobox'][aria-autocomplete='list']");
    private By submitButton = By.xpath("//button[text()='Create Project']");

    public boolean isProjectFormDisplayed() {
        waitForElement(projectFormHeader, 10);
        return find(projectFormHeader).isDisplayed();
    }

    public DashboardPage fillProjectForm(String projectName, String projectManager, String projectRevenue, String projectStatus, String projectProgress, String projectDueDate, String[] projectTeam) {
        set(projectNameInputField, projectName);
        // Don't send keys for a select field: why test is falling
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

        click(submitButton);

        return new DashboardPage();
    }



}