package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import java.net.MalformedURLException;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ChooseOption;
import utils.Click;
import utils.Verify;

public class TestTqPage extends  BasePage{
    private Random numberRandom = new Random();
    private By nextButton = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/form/div/div[4]/button");
    private Click click = new Click(webDriver);
    private ChooseOption chooseOption= new ChooseOption(webDriver);

    public TestTqPage(WebDriver webDriver) {
        super(webDriver);
    }
    public ResultTestPage starTest() throws MalformedURLException {
        int i=1;
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Test TQ Start");
        while(i<=65){
            int rand  = numberRandom.nextInt((3 - 1)+1)+1;
            int rand2  = numberRandom.nextInt((4 - 1)+1)+1;
            By option = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/form/div/div[2]/div["+rand+"]/div/label");
            By optionSelect = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/form/div/div[3]/div["+rand2+"]/div/label");
            chooseOption.selectToOptionTQ(option,optionSelect);
            click.clickEvent(nextButton);
            i++;// incrementing i value.

        }
        return new ResultTestPage(webDriver);
    }
}
