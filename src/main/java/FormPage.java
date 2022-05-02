import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {

    WebDriver driver;
    String url = "https://demoqa.com/automation-practice-form";
    By firstNameInput = By.id("firstName");
    By lastNameInput = By.id("lastName");
    By emailInput = By.id("userEmail");
    By maleRadio = By.cssSelector("#gender-radio-1 + label");
    By femaleRadio = By.cssSelector("#gender-radio-2 + label");
    By otherRadio = By.cssSelector("#gender-radio-3 + label");

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
}
