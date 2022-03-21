package webdriver.factory;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements IWebDriver{
    @Override
    public WebDriver createWebDriver() throws MalformedURLException {
        System.setProperty("webdriver.gecko.driver","resources/geckodriver.exe");
        return new FirefoxDriver();
    }
}
