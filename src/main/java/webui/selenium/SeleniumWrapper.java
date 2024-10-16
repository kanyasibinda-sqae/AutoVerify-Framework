package webui.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.utils.WebDriverUtil;

import java.time.Duration;
import java.util.List;

public abstract class SeleniumWrapper {

    protected WebElement findOne(By by){
        WebDriverWait wait = new WebDriverWait(WebDriverUtil.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected List<WebElement> findMany(By by){
        WebDriverWait wait = new WebDriverWait(WebDriverUtil.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    protected void click(By by){
        WebDriverUtil.getDriver().findElement(by).click();
    }

    protected void sendKeys(By by, String txt){
        WebDriverUtil.getDriver().findElement(by).sendKeys(txt);
    }

    protected String getText(By by){
        return WebDriverUtil.getDriver().findElement(by).getText();
    }

}
