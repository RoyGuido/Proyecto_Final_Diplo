package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ChooseFile;
import utils.Click;
import utils.Enter;
import utils.SelectOption;

public class AddReservationGruPage extends BasePage{

    private By transaction = By.name("idtipotra");
    private By paymentSlip = By.name("boleta");
    private By contact = By.name("telefono");
    private By selectSchool = By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div[2]/div/form/div/div[3]/div/div/span/span[1]/span/span[2]");
    private By school = By.xpath("/html/body/span/span/span[2]/ul/li[2]");
    private By detail= By.name("detalle");
    private By file = By.name("archivo");
    private By add = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/div/div/div[2]/div/form/div/div[6]/button");
    private By messageSuccessful = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/div/div/div[2]");
    private Enter enter = new Enter(webDriver);
    private Click click = new Click(webDriver);
    private ChooseFile chooseFile= new ChooseFile(webDriver);
    private SelectOption selectOption = new SelectOption(webDriver);

    public AddReservationGruPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void selectTransaction(String data){
        selectOption.selectByVisibleText(data,transaction);
    }
    public void typePaymentSlip(String data){
        enter.enterText(paymentSlip,data);
    }
    public void typeContact(String data){
        enter.enterText(contact,data);
    }
    public void typeSchool(){
        selectOption.selectByOption(school,selectSchool);
    }
    public void typeDetail(String data){
        enter.enterText(detail,data);
    }
    public void uploadFile(String rute){
        chooseFile.uploadFile(file,rute);
    }
    public AddReservationGruPage clickOnAddButton(){
        click.clickEvent(add);
        return new AddReservationGruPage(webDriver);
    }
    public String getMessageSuccessful() {
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Create Reservation Successful");
        return webDriver.findElement(messageSuccessful).getText();
    }
    public AddReservationGruPage createReservationGru(String transaction,String paymentSlip,String contact,String detail,String rute){
        selectTransaction(transaction);
        typePaymentSlip(paymentSlip);
        typeContact(contact);
        typeSchool();
        typeDetail(detail);
        uploadFile(rute);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Create Reservation");
        return clickOnAddButton();
    }
}
