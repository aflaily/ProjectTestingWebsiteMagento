package MagentoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class produkPage {
    private WebDriver driver;
    private By product1 = new By.ByXPath(" //*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[3]/div/a");
    private By product2 = new By.ByXPath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[7]/div/a");

    private By cart = new By.ByXPath("/html/body/div[2]/header/div[2]/div[1]/a");
    private By checkout = new By.ByXPath("//*[@id=\"top-cart-btn-checkout\"]");

    public produkPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setClickCart() {
        driver.findElement(cart).click();
    }
    public shippingPage clickCheckout() {
        driver.findElement(checkout).click();
        return new shippingPage(driver);
    }
    public detailProductPage clickProduk1() {
        driver.findElement(product1).click();
        return new detailProductPage(driver);
    }
    public detailProductPage clickProduk2() {
        driver.findElement(product2).click();
        return new detailProductPage(driver);
    }
    public String getUrlPageProduct() {
        return driver.getCurrentUrl();
    }
}
