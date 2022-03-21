package utils;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ChooseOption {
    protected WebDriver webDriver;

    public ChooseOption(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }
    public void selectToOptionDQ(By option, By select1, By select2, By select3) throws MalformedURLException {
        if (isVisible(option) == true) {
            WebDriverWait wait = new WebDriverWait(webDriver, 4);
            wait.until(ExpectedConditions.visibilityOfElementLocated(select2));
            WebElement inputElement = webDriver.findElement(select2);
            inputElement.click();
        }else{

            if (isVisible(select1) == true) {
                WebDriverWait wait2 = new WebDriverWait(webDriver, 4);
                wait2.until(ExpectedConditions.visibilityOfElementLocated(select1));
                WebElement inputElement2 = webDriver.findElement(select1);
                inputElement2.click();
            } else {
                WebDriverWait wait3 = new WebDriverWait(webDriver, 4);
                wait3.until(ExpectedConditions.visibilityOfElementLocated(select3));
                WebElement inputElement3 = webDriver.findElement(select3);
                inputElement3.click();
            }
        }
    }
    public void selectToOptionTQ(By option, By select) throws MalformedURLException {
        WebElement inputElement = webDriver.findElement(option);
        inputElement.click();
        if (isVisible(select) == true) {
            WebElement inputElement2 = webDriver.findElement(select);
            inputElement2.click();
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
