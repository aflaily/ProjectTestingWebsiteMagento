package MagentoPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class createAccountPage {
    private static WebDriver driver;
    private By firstName = new By.ById("firstname");
    private By lastName = new By.ById("lastname");
    private By checkbox = new By.ById("is_subscribed");
    private By email = new By.ById("email_address");
    private By password = new By.ById("password");
    private By confirmPassword = new By.ById("password-confirmation");

    private By buttonSubmit = new By.ByXPath("//*[@id=\"form-validate\"]/div/div[1]/button");

    public createAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String query) {
        driver.findElement(firstName).sendKeys(query);
    }

    public void setLastName(String query) {
        driver.findElement(lastName).sendKeys(query);
    }

    public void setCheckbox() {
            driver.findElement(checkbox).click();
        }
    public void setEmail(String query) {
        driver.findElement(email).sendKeys(query);
    }
    public void setPassword(String query) {
        driver.findElement(password).sendKeys(query);
    }
    public void setConfirmPassword(String query) {
        driver.findElement(confirmPassword).sendKeys(query);
    }
    public accountPage clickButton() {
        driver.findElement(buttonSubmit).submit();
        return new accountPage(driver);
    }
}
