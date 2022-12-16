import FormPages.completePage;
import FormPages.homePage;
import FormPages.formPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class waitTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "resourcee/chromedriver.exe");
        driver = new ChromeDriver();

    }
    @Test
    public void testLoadingImplicit() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement finish = driver.findElement(new By.ById("finish"));
    }

    @Test (expected = TimeoutException.class)
    public void testLoadingExplicit1() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(new By.ById("finish")));
    }

    @Test
    public void testLoadingExplicit() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        WebElement button = driver.findElement(new By.ByXPath("//*[@id=\"start\"]/button"));
        button.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(new By.ById("loading")));
    }
}


