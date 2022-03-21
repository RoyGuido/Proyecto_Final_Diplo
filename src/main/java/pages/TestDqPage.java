package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ChooseOption;
import utils.Click;
import java.util.Random;
import utils.Verify;

public class TestDqPage extends BasePage{

    private By option1 = By.xpath("//*[@id=\"centrarlo\"]/div[3]");
    private By option2 = By.xpath("//*[@class=\"image-radio\"]");
    private Random numberRandom = new Random();
    private By nextButton = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/form/div/div[3]/button");
    private By nextButton2 = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/form/div/div[4]/button");
    private By completedSuccessful = By.xpath("/html/body/div/div[2]/div/div/div/div/div/h2");
    private Click click = new Click(webDriver);
    private Verify verify= new Verify(webDriver);
    private ChooseOption chooseOption= new ChooseOption(webDriver);

    public TestDqPage(WebDriver webDriver) {
        super(webDriver);
    }
    public boolean getCompleteSuccefull() {
        return verify.statusCheckElement(completedSuccessful);
    }
    public TestTQDescriptionPage starTest() throws MalformedURLException {
        int i=1;
        while(i<=40){
            int rand  = numberRandom.nextInt((5 - 1)+1)+1;
            By optionSelect1 = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/form/div/div[2]/div["+rand+"]/div");
            By optionSelect2 = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/form/div/div[3]/div["+rand+"]/label/img");
            By optionSelect3 = By.xpath("/html/body/div/div[2]/div/div/div/div/div[2]/form/div/div[3]/div["+rand+"]/div/label");
            chooseOption.selectToOptionDQ(option2,optionSelect1,optionSelect2,optionSelect3);
            click.clickEventOption(nextButton,nextButton2);
            i++;// incrementing i value.

        }
        return new TestTQDescriptionPage(webDriver);
    }
}
