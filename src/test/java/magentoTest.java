import MagentoPage.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class magentoTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "resourcee/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testHome() {
        homesPage homes = new homesPage(driver);

        String url = homes.getUrlHome();
        Assert.assertEquals("https://magento.softwaretestingboard.com/", url);
    }

    @Test
    public void testCreateAccount() {
        homesPage homes = new homesPage(driver);
        homes.clickAccount();

        createAccountPage form = new createAccountPage(driver);
        form.setFirstName("Afifah");
        form.setLastName("Laily");
        form.setCheckbox();
        form.setEmail("afilaily2@gmail.com");
        form.setPassword("Lilyihsanyahya123");
        form.setConfirmPassword("Lilyihsanyahya123");
        form.clickButton();
        accountPage succes = new accountPage(driver);
        String url = succes.getUrlPageAccount();
        //Assert.assertTrue(url.contains("account"));
        Assert.assertEquals("https://magento.softwaretestingboard.com/customer/account/", url);
    }
    @Test
    public void testChooseMenuProduct() {
        homesPage homes = new homesPage(driver);
        homes.clickSignIn();

        signInPage akun = new signInPage (driver);
        akun.setEmail("afilaily2@gmail.com");
        akun.setPassword("Lilyihsanyahya123");
        akun.clickSubmitAcc();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setHoodie();
        produkPage show = new produkPage(driver);
        String url = show.getUrlPageProduct();
        Assert.assertEquals("https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html", url);
    }
    @Test
    public void testChooseProduct() {
        homesPage homes = new homesPage(driver);
        homes.clickSignIn();

        signInPage akun = new signInPage (driver);
        akun.setEmail("afilaily2@gmail.com");
        akun.setPassword("Lilyihsanyahya123");
        akun.clickSubmitAcc();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setHoodie();

        produkPage clothes = new produkPage(driver);
        clothes.clickProduk1();

        detailProductPage show = new detailProductPage(driver);
        String url = show.getUrlDetailPageProduct();
        Assert.assertEquals("https://magento.softwaretestingboard.com/grayson-crewneck-sweatshirt.html", url);
    }

    @Test
    public void testAddCart() {
        homesPage homes = new homesPage(driver);
        homes.clickSignIn();

        signInPage akun = new signInPage (driver);
        akun.setEmail("afilaily2@gmail.com");
        akun.setPassword("Lilyihsanyahya123");
        akun.clickSubmitAcc();

        accountPage product = new accountPage(driver);
        product.setMen();
        product.setTops();
        product.setHoodie();

        produkPage clothes = new produkPage(driver);
        clothes.clickProduk1();

        detailProductPage product1 = new detailProductPage(driver);
        product1.selectSize("L");
        product1.selectColor1("Red");
        product1.setQuantity("2");
        product1.setAddCart();
        product1.setClickBackProduct();

        clothes.clickProduk2();
        product1.selectSize("M");
        product1.selectColor2("Grey");
        product1.setQuantity("1");
        product1.setAddCart();

        Assert.assertEquals("3", product1.getCart());
    }

    @Test
    public void testCheckout() {
        homesPage homes = new homesPage(driver);
        homes.clickSignIn();

        signInPage akun = new signInPage (driver);
        akun.setEmail("afilaily2@gmail.com");
        akun.setPassword("Lilyihsanyahya123");
        akun.clickSubmitAcc();

        accountPage checkOut = new accountPage(driver);
        checkOut.setClickCart();
        checkOut.clickCheckout();

        shippingPage show = new shippingPage(driver);
        String url = show.getUrlPageShipping();
        Assert.assertEquals("https://magento.softwaretestingboard.com/checkout/", url);
    }
    @Test
    public void testSignOut() {
        homesPage homes = new homesPage(driver);
        homes.clickSignIn();

        signInPage akun = new signInPage (driver);
        akun.setEmail("afilaily2@gmail.com");
        akun.setPassword("Lilyihsanyahya123");
        akun.clickSubmitAcc();

        accountPage signOut = new accountPage(driver);
        signOut.setClickMenu();
        signOut.setClickSignOut();
        logOutPage logout = new logOutPage(driver);
        String url = logout.getUrlPageLogOut();
        Assert.assertEquals("https://magento.softwaretestingboard.com/customer/account/logoutSuccess/", url);
    }
}
