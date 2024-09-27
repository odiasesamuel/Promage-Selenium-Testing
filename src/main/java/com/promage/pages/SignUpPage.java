package com.promage.pages;

import com.promage.base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class SignUpPage extends BasePage {

    private By navigationTextBackToSignInPage = By.xpath("/html/body/div[1]/div[2]/div[2]/p");
    private By organisationNameInputField = By.name("organisation_name");
    private By organisationEmailInputField = By.name("organisation_email");
    private By administratorNameInputField = By.name("administrator_name");
    private By administratorEmailInputField = By.name("administrator_email");
    private By submitButton = By.xpath("/html/body/div[1]/div[2]/div[2]/div/form/div[2]/button");

    public boolean isNavigationTextBackToSignInPageDisplayed() {
        return find(navigationTextBackToSignInPage).isDisplayed();
    }

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

    public SignUpPage clickSubmitButton() {
        click(submitButton);
        return new SignUpPage();
    }

    public SignUpPage fillOrganisationDetailsForm(String organisationName, String organisationEmail, String administratorName, String administratorEmail) {
        waitForElement(organisationNameInputField, 10); // Wait for the element to be visible

        setOrganisationNameInputField(organisationName);
        setOrganisationEmailInputField(organisationEmail);
        setAdministratorNameInputField(administratorName);
        setAdministratorEmailInputField(administratorEmail);

        return clickSubmitButton();
    }


}
