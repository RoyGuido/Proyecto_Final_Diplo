package Test;

import base.BaseTests;
import java.net.MalformedURLException;
import java.util.Random;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddReservationGruPage;
import pages.AddReservationInPage;
import pages.FormAdminIndexPage;
import pages.FormAdminPage;
import pages.FormTestPage;
import pages.IndexPage;
import pages.RegisterTestPage;
import pages.ReservationGruPage;
import pages.ReservationInPage;
import pages.ResultTestPage;
import pages.TestDQDescriptionPage;
import pages.TestDqPage;
import pages.TestTQDescriptionPage;
import pages.TestTqPage;

public class LoginTests extends BaseTests {
    private Random numberRandom = new Random();

    @Test
    public void testLogin(){
        IndexPage indexPage = new IndexPage(this.webDriver);
        FormAdminPage formAdminPage = indexPage.clickOnFormAdminXpath();
        FormAdminIndexPage formAdminIndexPage = formAdminPage.loginAs("analia@gmail.com","123456");
        ReservationInPage reservationInPage = formAdminIndexPage.clickOnReservationInButton();
    }
    @Test
    public void testLogin2() {
        IndexPage indexPage = new IndexPage(this.webDriver);
        FormAdminPage formAdminPage = indexPage.clickOnFormAdminXpath();
        FormAdminIndexPage formAdminIndexPage = formAdminPage.loginAs("analia@gmail.com","123456");
        ReservationGruPage reservationGruPage = formAdminIndexPage.clickOnReservationGruButton();
    }

    @Test
    public void testLoginTest() throws MalformedURLException {
        IndexPage indexPage = new IndexPage(this.webDriver);
        FormTestPage formTestPage = indexPage.clickOnFormTestXpath();
        RegisterTestPage registerTestPage= formTestPage.loginAs("3132699","69363");
        registerTestPage.registerTest("CHUQUISACA","Pepe","Ramos");
        Assert.assertEquals(registerTestPage.getRegisterSuccessful(),true);

    }

}

