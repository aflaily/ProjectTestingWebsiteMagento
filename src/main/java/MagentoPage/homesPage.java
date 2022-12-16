package MagentoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homesPage {
    private WebDriver driver;
    private By account = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[3]/a");
    private By signIn = new By.ByXPath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
    public homesPage(WebDriver driver) {
            this.driver = driver;
    }
    public createAccountPage clickAccount() {
        driver.findElement(account).click();
        return new createAccountPage(driver);
    }
    public signInPage clickSignIn() {
        driver.findElement(signIn).click();
        return new signInPage(driver);
        }
    public String getUrlHome() {
        return driver.getCurrentUrl();
        }
    }

