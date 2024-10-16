package webui.applications;

import org.openqa.selenium.WebDriver;

import webui.pages.LoginPage;

public class PageApplications {

    public LoginPage loginPage;

    public PageApplications(WebDriver driver){
        loginPage = new LoginPage();
    }
}

