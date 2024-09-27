package com.promage.pages;

import com.promage.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SignInPage extends BasePage {

    private By emailInputField = By.name("email");
    private By employeeIDInputField = By.name("employee_id");
    private By signInButton = By.xpath("/html/body/div[1]/div[2]/div[2]/div/form/button");
    private By errorMessage = By.cssSelector("#\\:R9d7qbta\\:-form-item-message");

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

    public void goToSignUpPage() {

    }
}
