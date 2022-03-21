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

public class TestCase extends BaseTests {
    private Random numberRandom = new Random();
    @Test
    public void addReservation() {
        int rand  = numberRandom.nextInt((9999999 - 1000000)+1)+1;
        IndexPage indexPage = new IndexPage(this.webDriver);
        FormAdminPage formAdminPage = indexPage.clickOnFormAdminXpath();
        FormAdminIndexPage formAdminIndexPage = formAdminPage.loginAs("analia@gmail.com","123456");
        ReservationInPage reservationInPage = formAdminIndexPage.clickOnReservationInButton();
        AddReservationInPage addReservationInPage= reservationInPage.clickOnAddReservationButton();
        addReservationInPage.createReservationIn("TEST DE ORIENTACIÓN",""+rand+"","234568434","76686115","ARGENTINA");
        Assert.assertEquals(addReservationInPage.getMessageSuccessful(),"Datos guardados correctamente");
    }
    @Test
    public void addReservationGru() {
        IndexPage indexPage = new IndexPage(this.webDriver);
        FormAdminPage formAdminPage = indexPage.clickOnFormAdminXpath();
        FormAdminIndexPage formAdminIndexPage = formAdminPage.loginAs("analia@gmail.com","123456");
        ReservationGruPage reservationGruPage = formAdminIndexPage.clickOnReservationGruButton();
        AddReservationGruPage addReservationGruPage= reservationGruPage.clickOnAddReservationButton();
        addReservationGruPage.createReservationGru("TEST DE ORIENTACIÓN","2345682222","1234567891","Prueba de Automatización","D:\\Cursos\\Diplomado\\Proyecto\\Proyecto_Final\\resources\\archivo.xlsx");
        Assert.assertEquals(addReservationGruPage.getMessageSuccessful(),"Reserva cargada correctamente, se guardaron 2 registros");
    }
    @Test
    public void testStart() throws MalformedURLException {
        IndexPage indexPage = new IndexPage(this.webDriver);
        FormTestPage formTestPage = indexPage.clickOnFormTestXpath();
        RegisterTestPage registerTestPage= formTestPage.loginAs("9988776","14019");
        TestDQDescriptionPage testDQDescriptionPage = registerTestPage.registerTest("CHUQUISACA","Pepe","Ramos");
        Assert.assertEquals(registerTestPage.getRegisterSuccessful(),true);
        TestDqPage testDqPage = testDQDescriptionPage.clickOnNext();
        TestTQDescriptionPage testTQDescriptionPage = testDqPage.starTest();
        Assert.assertEquals(testDqPage.getCompleteSuccefull(),true);
        TestTqPage testTqPage = testTQDescriptionPage.clickOnNext();
        ResultTestPage resultTestPage= testTqPage.starTest();
        Assert.assertEquals(resultTestPage.getMessageSuccessful(),"TEST PSICOTÉCNICO");
    }
}
