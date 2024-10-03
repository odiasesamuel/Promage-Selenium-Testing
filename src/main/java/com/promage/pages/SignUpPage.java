package com.promage.pages;

import com.promage.base.BasePage;
import org.openqa.selenium.By;


public class SignUpPage extends BasePage {

    private By navigationTextBackToSignInPage = By.xpath("//p[text()='Already part of an organization?']");
    private By organisationNameInputField = By.name("organisation_name");
    private By organisationEmailInputField = By.name("organisation_email");
    private By administratorNameInputField = By.name("administrator_name");
    private By administratorEmailInputField = By.name("administrator_email");

    private By employeeNameInputField = By.name("employee_name");
    private By employeeEmailInputField = By.name("employee_email");
    private By jobTitleEmployeeInputField = By.name("job_title");
    private By nextIcon = By.cssSelector("body > div.text-white.grid.grid-cols-\\[repeat\\(12\\,_1fr\\)\\].grid-rows-\\[auto\\].min-h-screen > div.bg-\\[\\#FAFFFB\\].col-start-7.col-end-13.md\\:col-start-1.grid.place-content-center.my-5 > div.flex.flex-col.items-center > div > form > div.flex.items-center.justify-between.text-black > svg.lucide.lucide-chevron-right.w-10.h-8.cursor-pointer");

    private By revenueForLastQuarterInputField = By.name("last_quarter_revenue");
    private By projectForLastQuarterInputField = By.name("last_quarter_project");
    private By timeForLastQuarterInputField = By.name("last_quarter_time");
    private By numberOfEmployeeLastQuarterInputField = By.name("last_quarter_resources");

    private By submitButton = By.xpath("//button[text()='Submit']");
    private By errorModal = By.cssSelector("li > div > div");

    // 1) Asserters method
    public boolean isOrganisationFormDisplayed() {
        waitForElement(organisationNameInputField, 10); // Wait for the element to be visible
        return find(organisationNameInputField).isDisplayed();
    }

    public boolean isEmployeeFormDisplayed() {
        return find(employeeNameInputField).isDisplayed();
    }

    public boolean isMetricFormDisplayed() {
        return find(revenueForLastQuarterInputField).isDisplayed();
    }

    public boolean isErrorModalDisplayed() {
        waitForElement(errorModal, 10);
        return find(errorModal).isDisplayed();
    }

    // 2) Setters methods
    public void setOrganisationNameInputField(String organisationName) {
        set(organisationNameInputField, organisationName);
    }

    public void setOrganisationEmailInputField(String organisationEmail) {
        set(organisationEmailInputField, organisationEmail);
    }

    public void setAdministratorNameInputField(String administratorName) {
        set(administratorNameInputField, administratorName);
    }

    public void setAdministratorEmailInputField(String administratorEmail) {
        set(administratorEmailInputField, administratorEmail);
    }

    // 3) Click methods
    public SignUpPage clickOrganisationDetailSubmitButton() {
        click(submitButton);
        return new SignUpPage();
    }

    // 4) Convenience methods
    public SignUpPage fillOrganisationDetailsForm(String organisationName, String organisationEmail, String administratorName, String administratorEmail) {
        setOrganisationNameInputField(organisationName);
        setOrganisationEmailInputField(organisationEmail);
        setAdministratorNameInputField(administratorName);
        setAdministratorEmailInputField(administratorEmail);

        return clickOrganisationDetailSubmitButton();
    }

    public void setEmployeeNameInputField(String employeeName) {
        set(employeeNameInputField, employeeName);
    }

    public void setEmployeeEmailInputField(String employeeEmail) {
        set(employeeEmailInputField, employeeEmail);
    }

    public void setJobTitleEmployeeInputField(String jobTitle) {
        set(jobTitleEmployeeInputField, jobTitle);
    }

    public SignUpPage clickEmployeeDetailSubmitButton() {
        click(submitButton);
        return new SignUpPage();
    }

    public SignUpPage fillEmployeeDetailsForm(String employeeName, String employeeEmail, String jobTitle) {
        setEmployeeNameInputField(employeeName);
        setEmployeeEmailInputField(employeeEmail);
        setJobTitleEmployeeInputField(jobTitle);

        return clickEmployeeDetailSubmitButton();

    }

    public SignUpPage clickNextIcon() {
        click(nextIcon);
        return new SignUpPage();
    }

    public void setRevenueForLastQuarterInputField(String revenueForLastQuarter) {
        set(revenueForLastQuarterInputField, revenueForLastQuarter);
    }

    public void setProjectForLastQuarterInputField(String projectForLastQuarter) {
        set(projectForLastQuarterInputField, projectForLastQuarter);
    }

    public void setTimeForLastQuarterInputField(String timeForLastQuarter) {
        set(timeForLastQuarterInputField, timeForLastQuarter);
    }

    public void setNumberOfEmployeeLastQuarterInputField(String numberOfEmployeeLastQuarter) {
        set(numberOfEmployeeLastQuarterInputField, numberOfEmployeeLastQuarter);
    }

    public DashboardPage clickMetricDetailsButton() {
        click(submitButton);
        return new DashboardPage();
    }


    public DashboardPage fillMetricDetailForm(String revenueForLastQuarter, String projectForLastQuarter, String timeForLastQuarter, String numberOfEmployeeLastQuarter) {
        setRevenueForLastQuarterInputField(revenueForLastQuarter);
        setProjectForLastQuarterInputField(projectForLastQuarter);
        setTimeForLastQuarterInputField(timeForLastQuarter);
        setNumberOfEmployeeLastQuarterInputField(numberOfEmployeeLastQuarter);

        return clickMetricDetailsButton();
    }

// In a  Page there are three methods to write
//    1) Asserters method
//    2) Setters method
//    3) Getters method
//    4)

}
