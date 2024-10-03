package com.promage.pages;

import com.promage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePage {

    private By emailInputField = By.name("email");
    private By employeeIDInputField = By.name("employee_id");
    private By signInButton = By.xpath("//button[text()='Sign in']");
    private By errorMessage = By.xpath("//p[contains(text(), 'please check your credentials')]");
    private By linkToSignupPage = By.xpath("//a[text()='Sign up your organization']");

    public void setEmailInputField(String email) {
        set(emailInputField, email);
    }

    public void setEmployeeIDInputField(String employeeID) {
        set(employeeIDInputField, employeeID);
    }

    public DashboardPage clickSignInButton() {
        click(signInButton);
        return new DashboardPage();
    }

    public DashboardPage logIntoApplication(String email, String employeeID) {
        setEmailInputField(email);
        setEmployeeIDInputField(employeeID);

        return clickSignInButton();
    }

    public String getErrorMessage() {
        WebElement errorElement = waitForElement(errorMessage, 10);
        return errorElement.getText();
    }

    public SignUpPage clickLinkToSignUpPage() {
        click(linkToSignupPage);
        return new SignUpPage();
    }
}
