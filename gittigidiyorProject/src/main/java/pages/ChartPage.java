package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.testng.AssertJUnit.assertEquals;

public class ChartPage {
    WebDriver driver;


    private By chartPrice = By.cssSelector("p[class='new-price']");
    private By dropdownSelect = By.cssSelector("select[class='amount']");
    private By quantityText = By.cssSelector(("li[class='clearfix total-price-sticky-container'] div:nth-of-type(1)"));
    private By deleteButton = By.xpath("(//i[@class='gg-icon gg-icon-bin-medium'])[1]");
    private By chartIsEmpty = By.xpath("//h2[text()='Sepetinizde ürün bulunmamaktadır.']");


    public ChartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void controlChart() throws InterruptedException {
        ProductPage pp = new ProductPage(driver);
        String productPrice = pp.prodPriceValue;
        Thread.sleep(2000);
        String chartPriceValue = driver.findElement(chartPrice).getText().replaceAll(" TL", "");
        System.out.println("Sepet Sayfa Fiyati=" + chartPriceValue);
        assertEquals("Fiyatlar esit degil", productPrice, chartPriceValue);
        Thread.sleep(3000);
        Select dropdownList = new Select(driver.findElement(dropdownSelect));
        dropdownList.selectByVisibleText("2");
        Thread.sleep(1000);
        String quantity = driver.findElement(quantityText).getText();
        assertEquals("2 adet Urun Bulunmamaktadir", quantity, "Ürün Toplamı (2 Adet)");
        driver.findElement(deleteButton).click();
        Thread.sleep(1000);
        String chartIsEmptyLabel = driver.findElement(chartIsEmpty).getText();
        System.out.println(chartIsEmptyLabel);
        assertEquals("Sepetteki urun silinemedi", chartIsEmptyLabel, "Sepetinizde ürün bulunmamaktadır.");

    }



}
