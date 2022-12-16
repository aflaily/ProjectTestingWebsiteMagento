package FormPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import pages.inventoryPage;

public class formPage {
    private By firstName = new By.ById("first-name");
    private By lastName = new By.ById("last-name");
    private By jobTitle = new By.ById("job-title");
    private By radioButton1 = new By.ById("radio-button-1");
    private By radioButton2 = new By.ById("radio-button-2");
    private By radioButton3 = new By.ById("radio-button-3");
    private By checkbox1 = new By.ById("checkbox-1");
    private By checkbox2 = new By.ById("checkbox-2");
    private By checkbox3 = new By.ById("checkbox-3");
    private By dropdown = new By.ById("select-menu");
    private By dateField = new By.ById("datepicker");
    private By submit = new By.ByLinkText("Submit");
    private WebDriver driver;

    public formPage(WebDriver driver) {
        this.driver = driver;
    }
    public void setFirstName(String query) {
        driver.findElement(firstName).sendKeys(query);
    }
    public void setLastName(String query) {
        driver.findElement(lastName).sendKeys(query);
    }
    public void setJobTitle(String query) {
        driver.findElement(jobTitle).sendKeys(query);
    }
    public void selectHighestEdu(String select) {
        if (select == "High School") {
            driver.findElement(radioButton1).click();
        } else if (select == "College") {
            driver.findElement(radioButton2).click();
        } else if (select == "Grad School") {
            driver.findElement(radioButton3).click();
        }
    }

    public void selectSex(String select) {
        if (select == "Male") {
            driver.findElement(checkbox1).click();
        } else if (select == "Female") {
            driver.findElement(checkbox2).click();
        } else if (select == "Prefer not to say") {
            driver.findElement(checkbox3).click();
        }
    }
    public void setDropdown(String option){
        Select years = new Select(driver.findElement(dropdown));
        years.selectByVisibleText(option);
    }
    public void setDate(String date) {
        driver.findElement(dateField).sendKeys(date);
    }

    public completePage clickSubmit() {
        driver.findElement(submit).click();
        return new completePage(driver);
    }
}