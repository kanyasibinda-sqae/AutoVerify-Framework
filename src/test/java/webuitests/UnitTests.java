package webuitests;
import org.testng.annotations.Test;

import base_tests.WebUIBaseTest;
import data_providers.LoginCredentials;
import webui.utils.WebDriverUtil;

public class UnitTests extends WebUIBaseTest {

   
    @Test
    public void validateSiteAccessibility(){
        String urlWithSessionID = WebDriverUtil.getDriver().getCurrentUrl();
        String urlWithOutSessionId = urlWithSessionID.split(";")[0];
        softAssert.assertEquals(urlWithOutSessionId, "https://parabank.parasoft.com/parabank/index.html");
        softAssert.assertAll();
    }

    @Test(dataProvider = "loginCredentials", dataProviderClass = LoginCredentials.class)
    public void validateLoginFailure(String username, String password){
        pageApplications.loginPage.inputUsername(username);
        pageApplications.loginPage.inputPassword(password);
        pageApplications.loginPage.clickLoginButton();
        softAssert.assertEquals(pageApplications.loginPage.getErrorMessage(), "The username and password could not be verified.");
        softAssert.assertAll();
    }

}
