package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Click;
import utils.Enter;
import utils.SelectOption;

public class AddReservationInPage extends BasePage{

    private By transaction = By.name("idtipotra");
    private By ci = By.name("ci");
    private By paymentSlip = By.name("boleta");
    private By contact = By.name("telefono");
    private By country = By.name("pais");
    private By add = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/div/div/div[2]/div/form/div/div[6]/button");
    private By messageSuccessful = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div/div[2]");
    private Enter enter = new Enter(webDriver);
    private Click click = new Click(webDriver);
    private SelectOption selectOption = new SelectOption(webDriver);


    public AddReservationInPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void selectTransaction(String option){
        selectOption.selectByVisibleText(option,transaction);
    }
    public void typeCi(String data){
        enter.enterText(ci,data);
    }
    public void typePaymentSlip(String data){
        enter.enterText(paymentSlip,data);
    }
    public void typeContact(String data){
        enter.enterText(contact,data);
    }
    public void selectCountry(String data){
        selectOption.selectByVisibleText(data,country);
    }
    public AddReservationInPage clickOnAddButton(){
        click.clickEvent(add);
        return new AddReservationInPage(webDriver);
    }
    public String getMessageSuccessful() {
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Create Reservation Successful");
        return webDriver.findElement(messageSuccessful).getText();
    }

    public AddReservationInPage createReservationIn(String transaction,String ci,String paymentSlip,String contact,String country){
        selectTransaction(transaction);
        typeCi(ci);
        typePaymentSlip(paymentSlip);
        typeContact(contact);
        selectCountry(country);
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Create Reservation");
        return clickOnAddButton();
    }
}
