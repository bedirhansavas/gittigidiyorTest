package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import static org.testng.AssertJUnit.assertEquals;

public class ProductPage {
    WebDriver driver;
    public static String prodPriceValue;

    private By searchBar = By.xpath("//*[text()='BUL']/preceding::input[1]");
    private By submitButton = By.xpath("//*[@type='submit']");
    private By closePrivacy = By.xpath("(//*[text()='Çerez Politikası']/following::span[1])[1]");
    private By secondPage = By.xpath("//*[text()='2']");
    private By secondPageClick= By.xpath("(//ul[@class='clearfix'])[2]//following::li[2]");
    private By selectProduct = By.xpath("//*[text()='Akıllı Sıralama']/following::li[1]");
    private By addChart = By.xpath("//button[contains(text(),'Sepete Ekle')]");
    private By prodPrice = By.cssSelector("div[id='sp-price-discountPrice']");
    private By chartButton = By.xpath("//*[text()='Sepete Git']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public ChartPage searchProduct() throws InterruptedException {
        driver.findElement(searchBar).sendKeys("bilgisayar");
        driver.findElement(submitButton).click();
        Thread.sleep(1000);
        driver.findElement(closePrivacy).click();
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(secondPage));
        Thread.sleep(1000);
        driver.findElement(secondPage).click();
        Thread.sleep(1000);
        String currentStatus = driver.findElement(secondPage).getAttribute("class");
        assertEquals("2. Sayfa Acilamadi", currentStatus, "current");
        driver.findElement(selectProduct).click();
        prodPriceValue = driver.findElement(prodPrice).getText().replaceAll(" TL", "");
        System.out.println("Urunlerim Sayfa Fiyati=" + prodPriceValue);
        driver.findElement(addChart).click();
        Thread.sleep(2000);
        driver.findElement(chartButton).click();
        return new ChartPage(driver);

    }

}


