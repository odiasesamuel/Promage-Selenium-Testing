package com.promage.pages;

import com.promage.base.BasePage;
import com.promage.forms.ProjectFormComponent;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    private By dashboardHeader = By.xpath("//h1[contains(@class, 'font-medium')]//span[text()='Dashboard']");
    private By createNewProjectTab = By.xpath("//span[text()='Create new ']/..");
    private By projectPageLink = By.xpath("//a[@href='/project']");

    private By newProjectName = By.xpath("//tbody//tr[1]//td[1][text()='Nelsa Web Application']");
    private By newProjectManager = By.xpath("//tbody//tr[1]//td[2][text()='Alice Johnson']");
    private By newProjectStatus = By.xpath("//tbody//tr[1]//td[4]/div[text()='On going']");

    public boolean isDashboardheaderDisplayed() {
        waitForElement(dashboardHeader, 20);
        return find(dashboardHeader).isDisplayed();
    }

    public ProjectFormComponent clickCreateNewProjectTab() {
        click(createNewProjectTab);
        return new ProjectFormComponent();
    }

    public ProjectPage navigateToProjectPage() {
        click(projectPageLink);
        return  new ProjectPage();
    }

    public String getNewProjectName() {
        waitForElement(newProjectName, 10);
        return find(newProjectName).getText();
    }

    public String getNewProjectManager() {
        return find(newProjectManager).getText();
    }

    public String getNewProjectStatus() {
        return find(newProjectStatus).getText();
    }
}
