package MagentoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class accountPage {
    private static WebDriver driver;
    private By men = new By.ById("ui-id-5");
    private By tops = new By.ById("ui-id-17");
    private By hoodie = new By.ById("ui-id-20");

    private By checkCart = new By.ByXPath("//span[@class = \"counter qty\"]");
    private By cart = new By.ByXPath("/html/body/div[2]/header/div[2]/div[1]/a");
    private By checkout = new By.ByXPath("//*[@id=\"top-cart-btn-checkout\"]");
    private By menu = new By.ByXPath("//button[@class = \"action switch\"]");
    private By signOut = new By.ByXPath("//li[@class = \"authorization-link\"]");


    public accountPage(WebDriver driver) {
        this.driver = driver;

    }
    public void setMen() {
        WebElement waits = new WebDriverWait(driver, (10)).until(ExpectedConditions.visibilityOfElementLocated(men));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(men)).perform();
    }
    public void setTops() {
        WebElement waits = new WebDriverWait(driver, (10)).until(ExpectedConditions.visibilityOfElementLocated(tops));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(tops)).perform();
    }
    public produkPage setHoodie() {
        WebElement waits = new WebDriverWait(driver, (10)).until(ExpectedConditions.visibilityOfElementLocated(hoodie));
        Actions action = new Actions(driver);
        action.click(driver.findElement(hoodie)).perform();
        return new produkPage(driver);
    }
    public void setClickCart() {
        WebElement waits = new WebDriverWait(driver, (10)).until(ExpectedConditions.visibilityOfElementLocated(checkCart));
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(cart)).click().perform();
//        driver.findElement(cart).click();
    }
    public shippingPage clickCheckout() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(checkout)).click().perform();
//        driver.findElement(checkout).click();
        return new shippingPage(driver);
    }
    public void setClickMenu() {
        driver.findElement(menu).click();
    }

    public logOutPage setClickSignOut() {
        driver.findElement(signOut).click();
        return new logOutPage(driver);
    }
    public String getUrlPageAccount() {
        return driver.getCurrentUrl();
    }
}
