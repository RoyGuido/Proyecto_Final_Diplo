package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Enter {
    protected WebDriver webDriver;

    public  Enter(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public void enterText(By input, String text){
        WebElement inputElement = webDriver.findElement(input);
        inputElement.clear();
        inputElement.sendKeys(text);
    }
}
