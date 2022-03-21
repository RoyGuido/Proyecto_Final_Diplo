package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Verify {
    private WebDriver webDriver;

    public Verify(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public boolean statusCheckElement(By element) {
        try {
            return webDriver.findElement(element).isDisplayed();
        } catch (
            Exception e
        ) {
            return false;
        }
    }
}
