package webdriver.factory;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;

public interface IWebDriver {
    WebDriver createWebDriver() throws MalformedURLException;
}
