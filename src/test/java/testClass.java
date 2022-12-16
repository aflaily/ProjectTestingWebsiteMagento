import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.resultPage;
import pages.searchPage;

public class testClass {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://google.com/");
    }
@Test
    public void driverTest()
    {
        searchPage search = new searchPage(driver);
        search.setSearch_bar("lily");
        resultPage result = search.clickButton();
        String title = result.getPageTitle();
        Assert.assertTrue(title.contains("lily"));
    }

}
