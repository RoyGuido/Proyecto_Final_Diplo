package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Click;
import utils.SwitchTab;

public class IndexPage extends BasePage{

    public IndexPage(WebDriver webDriver) {
        super(webDriver);
    }

    private By formTestXpath = By.xpath("//*[@id=\"main-navigation\"]/ul/li[4]/a");
    private By formTestOnXpath = By.xpath("//*[@id=\"main-navigation\"]/ul/li[4]/ul/li");
    private By formAdminXpath = By.xpath("/html/body/footer/div[2]/div/div/div[2]/ul/li[3]/a");
    private By logotestXpath = By.xpath("/html/body/div/div[2]/div/div[1]");
    private Click click = new Click(webDriver);
    private SwitchTab switchTab= new SwitchTab(webDriver);

    public FormTestPage clickOnFormTestXpath(){
        click.clickEvent(formTestXpath);
        switchTab.switchTabWait(formTestOnXpath,1,3,logotestXpath);
        return new FormTestPage(webDriver);
    }
    public FormAdminPage clickOnFormAdminXpath(){
        switchTab.switchTab(formAdminXpath,1);
        return new FormAdminPage(webDriver);
    }
}
