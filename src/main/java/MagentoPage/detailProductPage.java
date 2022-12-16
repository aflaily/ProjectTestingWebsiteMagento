package MagentoPage;

import dev.failsafe.internal.util.Durations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.apache.commons.lang3.StringUtils.split;

public class detailProductPage {
    private WebDriver driver;
    private By sizeXs = new By.ByXPath("//*[@id=\"option-label-size-143-item-166\"]");
    private By sizeS = new By.ByXPath("//*[@id=\"option-label-size-143-item-167\"]");
    private By sizeM = new By.ByXPath("//*[@id=\"option-label-size-143-item-168\"]");
    private By sizeL = new By.ByXPath("//*[@id=\"option-label-size-143-item-169\"]");
    private By sizeXl = new By.ByXPath("//*[@id=\"option-label-size-143-item-170\"]");

    private By orange = new By.ByXPath("//*[@id=\"option-label-color-93-item-56\"]");
    private By red = new By.ByXPath("//*[@id=\"option-label-color-93-item-58\"]");
    private By white = new By.ByXPath("//*[@id=\"option-label-color-93-item-59\"]");
    private By black = new By.ByXPath("//*[@id=\"option-label-color-93-item-49\"]");
    private By grey = new By.ByXPath("//*[@id=\"option-label-color-93-item-52\"]");
    private By green = new By.ByXPath("//*[@id=\"option-label-color-93-item-53\"]");

    private By quantity = new By.ById("qty");
    private By addCart = new By.ByXPath("//*[@id=\"product-addtocart-button\"]");

    private By checkCart = new By.ByXPath("//span[@class = \"counter qty\"]");
    private By backProduct = new By.ByXPath("/html/body/div[2]/div[2]/ul/li[4]/a");

    public detailProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectSize(String select) {
        WebDriverWait waits = new WebDriverWait(driver, (10));
        if (select == "XS") {
            waits.until(ExpectedConditions.elementToBeClickable(sizeXs)).click();
        } else if (select == "S") {
            waits.until(ExpectedConditions.elementToBeClickable(sizeS)).click();
        } else if (select == "M") {
            waits.until(ExpectedConditions.elementToBeClickable(sizeM)).click();
        } else if (select == "L") {
            waits.until(ExpectedConditions.elementToBeClickable(sizeL)).click();
        } else if (select == "XL") {
//            driver.findElement(sizeXl).click();
            waits.until(ExpectedConditions.elementToBeClickable(sizeXl)).click();
        }
    }


    public void selectColor1(String select) {
        if (select == "Orange") {
            driver.findElement(orange).click();
        } else if (select == "Red") {
            driver.findElement(red).click();
        } else if (select == "White") {
            driver.findElement(white).click();
        }
    }
    public void selectColor2(String select) {
        if (select == "Black") {
            driver.findElement(black).click();
        } else if (select == "Grey") {
            driver.findElement(grey).click();
        } else if (select == "Green") {
            driver.findElement(green).click();
        }
    }

    public void setQuantity (String query){
        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys(query);
    }

    public void setAddCart (){
        driver.findElement(addCart).submit();
    }
    public produkPage setClickBackProduct() {
        driver.findElement(backProduct).click();
        return new produkPage(driver);
    }
    public String getUrlDetailPageProduct() {
        return driver.getCurrentUrl();
    }
    public String getCart() {
        WebElement redBox = new WebDriverWait(driver, (10)).until(ExpectedConditions.visibilityOfElementLocated(checkCart));
        return redBox.findElement(checkCart).getText().split("\n")[0];
    }
}
