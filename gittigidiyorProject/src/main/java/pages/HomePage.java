package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage clickLoginLink() throws InterruptedException {

        Thread.sleep(7000);
        Actions action = new Actions(driver);

        WebElement loginLink = driver.findElement(By.cssSelector("div[name='profile']"));
        action.moveToElement(loginLink).perform();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("a[href='https://www.gittigidiyor.com/uye-girisi']")).click();
        return new LoginPage(driver);
    }


}