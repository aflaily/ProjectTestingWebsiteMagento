import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.inventoryPage;
import pages.loginPage;
import pages.resultPage;
import pages.searchPage;

public class loginTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void testSaucedemoLogin() {
        loginPage login = new loginPage(driver);
        login.setUsername("standard_user");
        login.setPassword("secret_sauce");
        inventoryPage inventory = login.clickButton();
        String url = inventory.getUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", url);
        //driver.quit();
    }
    @Test
    public void testSaucedemoFailLogin() {
        loginPage login = new loginPage(driver);
        login.setUsername("standard_user");
        login.setPassword("secret");
        inventoryPage inventory = login.clickButton();
        String url = inventory.getUrl();
        Assert.assertEquals("https://www.saucedemo.com/", url);
        //driver.quit();
    }
}

