package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Click;

public class ReservationGruPage extends BasePage{

    private By addReservationButton = By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/div/div/a");
    private Click click = new Click(webDriver);

    public ReservationGruPage(WebDriver webDriver) {
        super(webDriver);
    }
    public AddReservationGruPage clickOnAddReservationButton(){
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Reservation Admin");
        click.clickEvent(addReservationButton);
        return new AddReservationGruPage(webDriver);
    }
}
