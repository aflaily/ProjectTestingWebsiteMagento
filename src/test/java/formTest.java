import FormPages.completePage;
import FormPages.homePage;
import FormPages.formPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class formTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "resource/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/");
    }

    @Test
    public void testForm() {
        homePage home = new homePage(driver);
        home.clickWebForm();

        formPage form = new formPage(driver);
        form.setFirstName("Afifah");
        form.setLastName("Laily");
        form.setJobTitle("Student");
        form.selectHighestEdu("College");
        form.selectSex("Female");
        form.setDropdown("0-1");
        form.setDate("11/18/2022");
        form.clickSubmit();
        completePage complete = new completePage(driver);
        String url = complete.getPageurl();
        Assert.assertEquals("https://formy-project.herokuapp.com/thanks", url);
        //driver.quit();
    }
}




