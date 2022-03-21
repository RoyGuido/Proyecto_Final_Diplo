package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Click;

public class TestDQDescriptionPage extends BasePage{
    private By nextButton = By.xpath("/html/body/div/div[2]/div/div/div/div/div/a");
    private Click click = new Click(webDriver);

    public TestDQDescriptionPage(WebDriver webDriver) {
        super(webDriver);
    }
    public TestDqPage clickOnNext(){
        click.clickEvent(nextButton);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Test DQ Start");
        return new TestDqPage(webDriver);
    }
}
