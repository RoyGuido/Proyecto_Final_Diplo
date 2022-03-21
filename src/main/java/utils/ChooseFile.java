package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ChooseFile {
    protected WebDriver webDriver;

    public ChooseFile(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }
    public void uploadFile(By element,String rute){
        WebElement chooseFile = webDriver.findElement(element);
        chooseFile.sendKeys(rute);
    }

}
