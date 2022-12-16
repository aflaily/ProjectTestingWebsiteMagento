package FormPages;

import org.openqa.selenium.WebDriver;

public class completePage {
    private WebDriver driver;

    public completePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageurl() {
        return driver.getCurrentUrl();
    }
}
