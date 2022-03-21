package utils;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectOption {

    private WebDriver webDriver;

    public SelectOption(WebDriver webDriver) {
            this.webDriver = webDriver;
        }
    public void selectByVisibleText(String option, By selectBy){
            Select toSelect = new Select(webDriver.findElement(selectBy));
            toSelect.selectByVisibleText(option);
        }
    public void selectByOption(By option, By selectBy){
        WebDriverWait wait = new WebDriverWait(webDriver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectBy));
        WebElement clickElement = webDriver.findElement(selectBy);
        clickElement.click();
        WebDriverWait wait2 = new WebDriverWait(webDriver, 2);
        wait2.until(ExpectedConditions.visibilityOfElementLocated(option));
        WebElement inputElement = webDriver.findElement(option);
        inputElement.click();
    }
    public void selectByMultiOption(By option, By selectBy, By selectBy2)
        throws MalformedURLException {
        if (isVisible(selectBy) == true) {
            WebElement inputElement = webDriver.findElement(selectBy);
            inputElement.click();
        } else {
            WebElement inputElement = webDriver.findElement(selectBy2);
            inputElement.click();
        }
        WebDriverWait wait = new WebDriverWait(webDriver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(option));
        WebElement inputElement = webDriver.findElement(option);
        inputElement.click();
    }
    public void selectByDay(By option, By selectBy, By selectBy2)
        throws MalformedURLException {
        WebDriverWait wait = new WebDriverWait(webDriver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(option));
        WebElement inputElement = webDriver.findElement(option);
        inputElement.click();
        if (isVisible(selectBy) == true) {
            WebElement inputElement2 = webDriver.findElement(selectBy);
            inputElement2.click();
        } else {
            WebElement inputElement3 = webDriver.findElement(selectBy2);
            inputElement3.click();
        }
    }
    public boolean isVisible(By selectBy) throws MalformedURLException {
        try {
           return webDriver.findElement(selectBy).isDisplayed();
        } catch (
            Exception e
        )
        {
            return false;
        }
    }

}
