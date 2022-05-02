import org.junit.After;
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
        page = new FormPage(driver);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void fillInForm() throws InterruptedException {
        page.navigateTo()
                .enterFullName("Kevin", "Maes")
                .enterEmail("kevin.maes@bignited.be")
                .selectGender("Female");

    }
}
