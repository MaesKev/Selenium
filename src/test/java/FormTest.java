import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormTest {

    WebDriver driver;
    FormPage page;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        page = new FormPage(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void fillInForm() {
        page.navigateTo()
                .enterFullName("Kevin", "Maes")
                .enterEmail("kevin.maes@bignited.be")
                .selectGender("Male")
                .enterCellphoneNumber("0496703400")
                .submit();

        Boolean isDisplayed = page.submitIsSuccesful();
        Assert.assertEquals(true, isDisplayed);
    }
}
