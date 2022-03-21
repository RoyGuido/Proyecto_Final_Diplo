package pages;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Click;
import utils.Enter;

public class FormAdminIndexPage extends BasePage{

    private By reservation = By.xpath("//*[@id=\"side-menu\"]/li[6]/a");
    private By reservationSingle = By.xpath("//*[@id=\"side-menu\"]/li[6]/ul/li[1]/a");
    private By reservationGroup = By.xpath("//*[@id=\"side-menu\"]/li[6]/ul/li[2]/a");
    private Enter enter = new Enter(webDriver);
    private Click click = new Click(webDriver);

    public FormAdminIndexPage(WebDriver webDriver) {
        super(webDriver);
    }
    public ReservationInPage clickOnReservationInButton(){
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Login Successful");
        click.clickEvent(reservation);
        click.clickEvent(reservationSingle);
        return new ReservationInPage(webDriver);
    }
    public ReservationGruPage clickOnReservationGruButton() {
        ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.INFO, "Login Successful");
        click.clickEvent(reservation);
        click.clickEventWait(reservationGroup,1);
        return new ReservationGruPage(webDriver);
    }
}
