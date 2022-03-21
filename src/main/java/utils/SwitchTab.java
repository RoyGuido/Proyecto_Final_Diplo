package utils;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwitchTab {
    protected WebDriver webDriver;
    public  SwitchTab(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }
    public void switchTab(By input,int number){

        WebElement inputElement = webDriver.findElement(input);
        inputElement.click();
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(number));
    }
    public void switchTabWait(By input,int number,int number2, By input2){
        WebDriverWait wait = new WebDriverWait(webDriver, number2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(input));
        WebElement inputElement = webDriver.findElement(input);
        inputElement.click();
        ArrayList<String> tabs = new ArrayList<String>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(number));
        wait.until(ExpectedConditions.visibilityOfElementLocated(input2));
    }

}
