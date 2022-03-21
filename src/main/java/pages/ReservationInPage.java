package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Click;


public class ReservationInPage extends BasePage {

    private By addReservationButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/div[1]/div/a");
    private Click click = new Click(webDriver);

    public ReservationInPage(WebDriver webDriver) {
        super(webDriver);
    }
    public AddReservationInPage clickOnAddReservationButton(){
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Reservation Admin");
        click.clickEvent(addReservationButton);
        return new AddReservationInPage(webDriver);
    }
}
