package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class searchPage {
    //field searchbar dan button
    private By search_bar = new By.ByName("q");
    private By button = new By.ByName("btnK");
    private WebDriver driver;

    public searchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearch_bar(String query) {
        driver.findElement(search_bar).sendKeys(query);
    }

    public resultPage clickButton() {
        driver.findElement(button).submit();
        return new resultPage(driver);
    }
}
