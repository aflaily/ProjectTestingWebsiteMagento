package MagentoPage;

import org.openqa.selenium.WebDriver;

public class shippingPage {
    private WebDriver driver;

    public shippingPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getUrlPageShipping() {
        return driver.getCurrentUrl();
    }
}

