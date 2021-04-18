package gittigidiyor;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.ChartPage;
import pages.LoginPage;
import pages.ProductPage;

public class GittiGidiyorTest extends BaseTest {

    @Test
    public void gittiGidiyorTest() throws InterruptedException {
        LoginPage loginPage = homePage.clickLoginLink();
        Thread.sleep(2000);
        loginPage.setUsernameField("testproject01@yandexmail.com");
        Thread.sleep(1000);
        loginPage.setPasswordField("test1234");
        Thread.sleep(1000);
        ProductPage productPage = loginPage.clickLoginButton();
        ChartPage cp = productPage.searchProduct();
        cp.controlChart();


    }
}
