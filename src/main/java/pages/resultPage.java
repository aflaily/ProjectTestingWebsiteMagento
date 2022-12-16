package pages;

import org.openqa.selenium.WebDriver;

public class resultPage {
    private WebDriver driver;

    public resultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
