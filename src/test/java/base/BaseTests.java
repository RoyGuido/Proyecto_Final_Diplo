package base;

import com.aventstack.extentreports.Status;
import helper.ScreenShotHelper;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.BasePage;
import webdriver.factory.WebDriverFactory;

public class BaseTests {
    protected WebDriver webDriver;
    protected BasePage basePage;
    private String url="http://diplomadotest.xyz/";
    private String browser= "chrome";

    @BeforeSuite
    public static void setUpSuite() throws Exception {
        report.ReportManager.init("C:\\Reports", "LoginSite");
    }

    @BeforeMethod
    @Parameters({"browserSuite"})
    public void setUp(@Optional()String browserSuite,ITestResult iTestResult) throws Exception {
        report.ReportManager.getInstance().startTest(iTestResult.getMethod().getMethodName());
        webDriver = WebDriverFactory.getDriver((browserSuite!=null)?browserSuite:browser);
        webDriver.get(url);
        basePage = new BasePage(webDriver);
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        try {
            switch (iTestResult.getStatus()){
                case ITestResult.FAILURE:
                    report.ReportManager.getInstance().getTest().log(Status.FAIL, "Test failed");
                    break;
                case ITestResult.SKIP:
                    report.ReportManager.getInstance().getTest().log(Status.SKIP, "Test skipped");
                    break;
                case ITestResult.SUCCESS:
                    report.ReportManager.getInstance().getTest().log(Status.PASS, "Test passed");
                    break;
                default:
                    report.ReportManager.getInstance().getTest().log(Status.FAIL, "Test incomplete");
            }

            if(iTestResult.getStatus() != ITestResult.SUCCESS && iTestResult.getThrowable() != null){
                report.ReportManager.getInstance().getTest().log(Status.FAIL, iTestResult.getThrowable().getMessage());
                ScreenShotHelper.takeScreenShotAndAdToHTMLReport(webDriver, Status.FAIL, "Failure Image");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(webDriver != null)
                webDriver.quit();
        }
    }

    @AfterSuite
    public static void tearDownSuite(){
        report.ReportManager.getInstance().flush();
    }

}
