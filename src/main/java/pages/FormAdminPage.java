package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Click;
import utils.Enter;

public class FormAdminPage extends BasePage{
    private By emailId = By.name("email");
    private By passWordId = By.id("password");
    private By loginXpath = By.xpath("//*[@id=\"wrapper\"]/div[2]/div/form/div[3]/div/button");
    private Enter enter = new Enter(webDriver);
    private Click click = new Click(webDriver);

    public FormAdminPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void typeEmail(String email){
        enter.enterText(emailId,email);
    }

    public void typePassWord(String passWord){
        enter.enterText(passWordId,passWord);
    }

    public FormAdminIndexPage clickOnLoginButton(){
        click.clickEvent(loginXpath);
        return new FormAdminIndexPage(webDriver);
    }

    public FormAdminIndexPage loginAs(String email, String passWord){
        typeEmail(email);
        typePassWord(passWord);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Login Admin");
        return clickOnLoginButton();
    }
}
