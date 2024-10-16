package webui.pages;

import org.openqa.selenium.By;

import webui.selenium.SeleniumWrapper;

public class LoginPage extends SeleniumWrapper {

    private By usernameField = By.xpath("//input[@name = 'username']");
    private By passwordField = By.xpath("//input[@name = 'password']");
    private By loginButton = By.xpath("//input[@value = 'Log In']");
    private By errorMessage = By.xpath("//div[@id = 'rightPanel']/descendant::p[@class = 'error']");


    public void inputUsername(String username){
        sendKeys(usernameField, username);
    }

    public void inputPassword(String password){
        sendKeys(passwordField, password);
    }

    public void clickLoginButton(){
        click(loginButton);
    }

    public String getErrorMessage(){
        return getText(errorMessage);
    }
}
