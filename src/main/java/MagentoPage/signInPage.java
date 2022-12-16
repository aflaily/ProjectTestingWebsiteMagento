package MagentoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signInPage {
    private static WebDriver driver;
    private By email = new By.ById("email");
    private By password = new By.ById("pass");
    private By submitAcc = new By.ById("send2");
    public signInPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setEmail(String query) {
        driver.findElement(email).sendKeys(query);
    }
    public void setPassword(String query) {
        driver.findElement(password).sendKeys(query);
    }
    public accountPage clickSubmitAcc() {
        driver.findElement(submitAcc).submit();
        return new accountPage(driver);
    }
}
