package MagentoPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logOutPage {
    private static WebDriver driver;

    public logOutPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getUrlPageLogOut() {
        return driver.getCurrentUrl();
    }
}
