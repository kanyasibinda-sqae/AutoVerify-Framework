package data_providers;

import org.testng.annotations.DataProvider;

public class LoginCredentials {

    @DataProvider(name = "loginCredentials")
    public Object[][] loginCredentials() {
       return new Object[][] { 
        { "tester23@gmail.com", "tester23" } 
    };
       
   }
}
