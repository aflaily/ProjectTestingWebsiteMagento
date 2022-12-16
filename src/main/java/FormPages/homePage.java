package FormPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homePage {
    private By webForm = new By.ByLinkText("Complete Web Form");
    private WebDriver driver;
    public homePage(WebDriver driver) {
        this.driver = driver;
    }
    public formPage clickWebForm() {
        driver.findElement(webForm).click();
        //sebaiknya thread jangan dipakai karena akan membuang waktu
        //pakai wait akan berhenti menunggu ketika elemennya sudah bisa diakses
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new formPage(driver);
    }
}

