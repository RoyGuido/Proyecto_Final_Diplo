package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Click;
import utils.Enter;

public class FormTestPage extends BasePage{

    private By ciId = By.id("ci");
    private By codeId = By.id("password");
    private By loginXpath = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/form/div[3]/button");
    private Enter enter = new Enter(webDriver);
    private Click click = new Click(webDriver);

    public FormTestPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void typeCi(String ci){
        enter.enterText(ciId,ci);
    }

    public void typeCode(String passWord){
        enter.enterText(codeId,passWord);
    }

    public RegisterTestPage clickOnLoginButton(){
        click.clickEvent(loginXpath);
        return new RegisterTestPage(webDriver);
    }
    public RegisterTestPage loginAs(String ci, String code){
        typeCi(ci);
        typeCode(code);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Login Test");
        return clickOnLoginButton();
    }
}
