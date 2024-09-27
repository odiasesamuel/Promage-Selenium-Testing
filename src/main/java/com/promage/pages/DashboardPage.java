package com.promage.pages;

import com.promage.base.BasePage;
import org.openqa.selenium.By;

public class DashboardPage extends BasePage {

    private By dashboardHeader = By.xpath("/html/body/div[1]/header/div[1]/h1/span");

    public boolean isDashboardheaderDisplayed() {
        waitForElement(dashboardHeader, 20);
        return find(dashboardHeader).isDisplayed();
    }
}
