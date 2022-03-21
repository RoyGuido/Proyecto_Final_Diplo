package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Click;

public class TestTQDescriptionPage extends BasePage{
    private By nextButton = By.xpath("/html/body/div/div[2]/div/div/div/div/div/a");
    private Click click = new Click(webDriver);

    public TestTQDescriptionPage(WebDriver webDriver) {
        super(webDriver);
    }
    public TestTqPage clickOnNext(){
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Test TQ Description");
        click.clickEvent(nextButton);
        return new TestTqPage(webDriver);
    }
}
