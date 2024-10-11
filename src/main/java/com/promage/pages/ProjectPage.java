package com.promage.pages;

import com.promage.base.BasePage;
import com.promage.forms.ProjectFormComponent;
import org.openqa.selenium.By;

public class ProjectPage extends BasePage {

    private By projectHeader = By.xpath("//h1[contains(@class, 'font-medium')]//span[text()='Project']");
    private By reviewedProjectName = By.xpath("//tbody//tr[1]//td[1][text()='Kaylee E-commerce website']");
    private By reviewedProjectManager = By.xpath("//tbody//tr[1]//td[2][text()='Charlie Brown']");
    private By reviewedProjectStatus = By.xpath("//tbody//tr[1]//td[4]/div[text()='Completed']");
    private By reviewButton = By.xpath("//tbody//tr[1]//td[1][text()='Nelsa Web Application']/..//button[text()='Review']");

    public boolean isProjectPageDisplayed() {
        waitForElement(projectHeader, 20);
       return find(projectHeader).isDisplayed();
    }

    public ProjectFormComponent clickReviewProjectButton() {
        click(reviewButton);

        return new ProjectFormComponent();
    }

    public String getReviwedProjectName() {
        waitForElement(reviewedProjectName, 10);
        return find(reviewedProjectName).getText();
    }

    public String getReviwedProjectManager() {
        return find(reviewedProjectManager).getText();
    }

    public String getReviwedProjectStatus() {
        return find(reviewedProjectStatus).getText();
    }


}
