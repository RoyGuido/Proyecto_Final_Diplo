package webdriver.factory;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome  implements IWebDriver {
    @Override
    public WebDriver createWebDriver() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation","load-extension"});
        return new ChromeDriver(options);
    }
}
