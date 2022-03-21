package webdriver.factory;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String browser) throws Exception {
        switch (browser){
            case "chrome":
                Chrome chromeDriver = new Chrome();
                return chromeDriver.createWebDriver();
            case "firefox":
                Firefox firefoxDriver = new Firefox();
                return firefoxDriver.createWebDriver();
            default:
                throw new Exception("Navegador " + browser + " no soportado");
        }
    }

}
