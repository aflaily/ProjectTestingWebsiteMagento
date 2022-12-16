import FormPages.completePage;
import FormPages.homePage;
import FormPages.formPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
public class advanceInteractionTest  {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

    }

    @Test
    public void testHover() {
        WebElement hover = driver.findElement(new By.ByLinkText("Hovers"));
        hover.click();

        WebElement user1 = driver.findElement(new By.ByXPath("//*[@id=\"content\"]/div/div[1]/img"));
        Actions action = new Actions(driver);
        action.moveToElement(user1).perform();

        WebElement name1 = driver.findElement(new By.ByXPath("//*[@id=\"content\"]/div/div[1]/div/h5"));
        String name = name1.getText();
        Assert.assertEquals("name: user1", name);
    }

    @Test
    public void testDragDrop() {
        WebElement dragDrp = driver.findElement(new By.ByLinkText("Drag and Drop"));
        dragDrp.click();

        WebElement colA = driver.findElement(new By.ByXPath("//*[@id=\"column-a\"]"));
        Actions action = new Actions(driver);

        WebElement colB = driver.findElement(new By.ByXPath("//*[@id=\"column-b\"]"));
        action.dragAndDrop(colA, colB).perform();
    }


    @Test
    public void testKeyPressed() {
        WebElement keyPress = driver.findElement(new By.ByLinkText("Key Presses"));
        keyPress.click();

        WebElement form = driver.findElement(new By.ById("target"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).perform();

        WebElement result = driver.findElement(new By.ById("result"));
        String res = result.getText();

        Assert.assertEquals("You entered: SHIFT", res);
    }
}
