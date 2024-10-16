package webui.utils;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverUtil {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static WebDriver getDriver(){
        return driver.get();
    }
    public static void setUpDriverManager(String browser){
       if (getDriver() == null){
           System.out.println("Setting up WebDriverManager for browser: " + browser);
           if (browser.equalsIgnoreCase("chrome")){
               WebDriverManager.chromedriver().setup();
           }
           else if (browser.equalsIgnoreCase("edge")){
               WebDriverManager.edgedriver().setup();
           }
           else {
               throw new IllegalArgumentException("Browser not supported: " + browser);
           }
       }

    }

    public static void setDriver(String browser){
        System.out.println("Setting up WebDriver for browser: " + browser);
        if (browser.equalsIgnoreCase("chrome")){
            driver.set(new ChromeDriver());
            getDriver().manage().window().maximize();
        }
        else if (browser.equalsIgnoreCase("edge")){
            driver.set(new EdgeDriver());
            getDriver().manage().window().maximize();
        }
        else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        System.out.println("WebDriver initialized: " + (getDriver() != null));
            
    }

    /*
    public static void setDriverWithOptions(String browser){
        if (driver == null){
            System.out.println("Setting up WebDriver with options for browser: " + browser);
            if (browser.equalsIgnoreCase("chrome")){
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--set-heardless");
                driver = new ChromeDriver();
            } 
            else if (browser.equalsIgnoreCase("edge")){
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--set-heardless");
                driver = new EdgeDriver();
            } 
            else {
                throw new IllegalArgumentException("Browser not supported: " + browser);
            }
            System.out.println("WebDriver initialized: " + (driver != null));
        }
    }
    */

    public static void getURL(String txt){
        System.out.println("Navigating to URL: " + txt);
        getDriver().get(txt);
    }

    public static void quitDriver(){
        if (getDriver() != null){
            getDriver().quit();
        }
    }
}

