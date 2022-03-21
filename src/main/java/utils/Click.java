package utils;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Click {

    protected WebDriver webDriver;

    public Click(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public void clickEvent(By element){
        WebElement clickElement = webDriver.findElement(element);
        clickElement.click();
    }
    public void clickEventWait(By element,int number){
        WebDriverWait wait = new WebDriverWait(webDriver, number);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        WebElement inputElement = webDriver.findElement(element);
        inputElement.click();
    }
    public void clickEventOption(By selectBy, By selectBy2) throws MalformedURLException{
            if (isVisible(selectBy) == true) {
                WebElement inputElement = webDriver.findElement(selectBy);
                inputElement.click();
            } else {
                WebElement inputElement = webDriver.findElement(selectBy2);
                inputElement.click();
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
