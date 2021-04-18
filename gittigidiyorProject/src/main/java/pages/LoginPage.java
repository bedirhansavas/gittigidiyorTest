package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.xpath("//*[text()='ile giriş yapın']/following::input[2]");
    private By passwordField = By.xpath("//*[text()='ile giriş yapın']/following::input[3]");
    private By loginButton = By.xpath("//*[text()='Sms ile Giriş Yap']/preceding::input[1]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setUsernameField(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public ProductPage clickLoginButton() {
        driver.findElement(loginButton).click();
        return new ProductPage(driver);
    }
}
