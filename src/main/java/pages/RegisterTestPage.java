package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Click;
import utils.Enter;
import utils.SelectOption;
import utils.Verify;

public class RegisterTestPage extends BasePage{
    private By source = By.name("procedencia");
    private By name = By.name("nombre");
    private By lastName = By.name("apellido");
    private By date = By.name("fecha");
    //private By day = By.xpath("//*[@data-pick=\"1647230400000\"]");
    private By day = By.xpath("//*[@aria-selected=\"true\"]");
    private By day2 = By.xpath("//*[@aria-activedescendant=\"true\"]");
    private By selectOption1 = By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/form/div[6]/div/span/span[1]/span/span[1]");
    private By selectOption1_update = By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div/div/div/form/div[6]/div/span/span[1]/span/span[1]");
    private By option1 = By.xpath("/html/body/span/span/span[2]/ul/li[2]");
    private By selectOption2 = By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/form/div[7]/div/span/span[1]/span/span[1]");
    private By selectOption2_update = By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div/div/div/form/div[7]/div/span/span[1]/span/span[1]");
    private By option2 = By.xpath("/html/body/span/span/span[2]/ul/li[4]");
    private By add = By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/form/button");
    private By add_update = By.xpath("/html/body/div/div[2]/div[2]/div/div/div/div/div/div/form/button");
    private By registerSuccessful = By.xpath("/html/body/div/div[2]/div/div/div/div/div/h2");
    private Enter enter = new Enter(webDriver);
    private Click click = new Click(webDriver);
    private Verify verify= new Verify(webDriver);
    private SelectOption selectOption = new SelectOption(webDriver);


    public RegisterTestPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void selectSource(String option){
        selectOption.selectByVisibleText(option,source);
    }
    public void typeName(String data){
        enter.enterText(name,data);
    }
    public void typeLastName(String data){
        enter.enterText(lastName,data);
    }
    public void typeDate() throws MalformedURLException {
        selectOption.selectByDay(date,day,day2);
    }
    public void selectOption1() throws MalformedURLException {
        selectOption.selectByMultiOption(option1,selectOption1,selectOption1_update);
    }
    public void selectOption2() throws MalformedURLException {
        selectOption.selectByMultiOption(option2,selectOption2,selectOption2_update);
    }

    public TestDQDescriptionPage clickOnAddButton() throws MalformedURLException {
        click.clickEventOption(add,add_update);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Test DQ Description");
        return new TestDQDescriptionPage(webDriver);
    }
    public boolean getRegisterSuccessful() {
        return verify.statusCheckElement(registerSuccessful);
    }
    public TestDQDescriptionPage registerTest(String source,String name,String lastName)
        throws MalformedURLException {
        selectSource(source);
        typeName(name);
        typeLastName(lastName);
        typeDate();
        selectOption1();
        selectOption2();
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Register for Test");
        return clickOnAddButton();
    }
}
