import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FormPage {

    WebDriver driver;
    String url = "https://demoqa.com/automation-practice-form";
    By firstNameInput = By.id("firstName");
    By lastNameInput = By.id("lastName");
    By emailInput = By.id("userEmail");
    By maleRadio = By.cssSelector("#gender-radio-1 + label");
    By femaleRadio = By.cssSelector("#gender-radio-2 + label");
    By otherRadio = By.cssSelector("#gender-radio-3 + label");
    By cellphoneInput = By.id("userNumber");
    By submitButton = By.id("submit");
    By resultModal = By.cssSelector("div.modal-body");
    By datepicker = By.id("dateOfBirthInput");
    By datepickerMonth = By.cssSelector("select.react-datepicker__month-select");
    By datepickerYear = By.cssSelector("select.react-datepicker__year-select");
    By datepickerDays = By.cs("div.react-datepicker__day");

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public FormPage navigateTo() {
        driver.get(this.url);
        return this;
    }

    public FormPage enterFullName(String firstName, String lastName) {
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        return this;
    }

    public FormPage enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
        return this;
    }

    public FormPage selectGender(String gender) {
        if ("Male".equals(gender)) {
            driver.findElement(maleRadio).click();
        } else if ("Female".equals(gender)) {
            driver.findElement(femaleRadio).click();
        } else if ("Other".equals(gender)) {
            driver.findElement(otherRadio).click();
        } else {
            throw new Error("Invalid gender selected");
        }

        return this;
    }

    public FormPage enterCellphoneNumber(String number) {
        driver.findElement(cellphoneInput).sendKeys(number);
        return this;
    }

    public FormPage submit() {
        WebElement button = driver.findElement(submitButton);
        button.submit();
        return this;
    }

    public FormPage enterDate(String day, String month, String year) {
        driver.findElement(datepicker).click();
        WebElement selectMonth = driver.findElement(datepickerMonth);
        Select selectObjectMonth = new Select(selectMonth);
        selectObjectMonth.selectByVisibleText(month);
        WebElement selectYear = driver.findElement(datepickerYear);
        Select selectObjectYear = new Select(selectYear);
        selectObjectYear.selectByVisibleText(year);

        //TODO fill in day as well
        return this;
    }

    public boolean submitIsSuccessful() {
        return driver.findElement(resultModal).isDisplayed();
    }
}
