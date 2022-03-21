package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultTestPage extends BasePage{
    private By TestSuccessful = By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/p[3]");
    public ResultTestPage(WebDriver webDriver) {
        super(webDriver);
    }
    public String getMessageSuccessful() {
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Test Completed");
        return webDriver.findElement(TestSuccessful).getText();
    }
}
