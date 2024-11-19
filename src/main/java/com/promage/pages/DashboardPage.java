package com.promage.pages;

import com.promage.base.BasePage;
import com.promage.forms.ProjectFormComponent;
import org.openqa.selenium.By;

import java.util.Objects;

public class DashboardPage extends BasePage {

    private By dashboardHeader = By.xpath("//h1[contains(@class, 'font-medium')]//span[text()='Dashboard']");
    private By createNewProjectTab = By.xpath("//span[text()='Create new ']/..");
    private By projectPageLink = By.xpath("//a[@href='/project']");
    private By taskPageLink = By.xpath("//a[@href='/tasks']");

    private By newProjectName = By.xpath("//tbody//tr[1]//td[1][text()='Nelsa Web Application']");
    private By newProjectManager = By.xpath("//tbody//tr[1]//td[2][text()='Alice Johnson']");
    private By newProjectStatus = By.xpath("//tbody//tr[1]//td[4]/div[text()='On going']");
    private By assignedTaskCheckBox = By.xpath("//label[text()='Implement authorization for DBKS portal']/preceding-sibling::button");


    public boolean isDashboardheaderDisplayed() {
        waitForElementVisibility(dashboardHeader, 20);
        return find(dashboardHeader).isDisplayed();
    }

    public ProjectFormComponent clickCreateNewProjectTab() {
        click(createNewProjectTab);
        return new ProjectFormComponent();
    }

    public ProjectPage navigateToProjectPage() {
        click(projectPageLink);
        return new ProjectPage();
    }

    public TaskPage navigateToTaskPage() {
        click(taskPageLink);
        return new TaskPage();
    }

    public String getNewProjectName() {
        waitForElementVisibility(newProjectName, 10);
        return find(newProjectName).getText();
    }

    public String getNewProjectManager() {
        return find(newProjectManager).getText();
    }

    public String getNewProjectStatus() {
        return find(newProjectStatus).getText();
    }

    public DashboardPage clickAssignedTask() {
        String checkAttributeValue = find(assignedTaskCheckBox).getAttribute("data-state");
        if ("unchecked".equals(checkAttributeValue)) {
        click(assignedTaskCheckBox);
        }
        return new DashboardPage();
    }

    public String checkboxState () {
        return find(assignedTaskCheckBox).getAttribute("data-state");
    }
}
