import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationPageTest {
    private WebDriver driver;
    private RegistrationPage registrationPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://ru-ru.facebook.com/r.php?locale=ru_RU&display=page");
        registrationPage = new RegistrationPage(driver);

    }

    @Test
    public void register() {
        RegistrationPage newRegistrationPage = registrationPage.register("dgfgd", "zczcfasf", "ddfsfds", "vdfsgdg", "25", "фев", "1980", "Мужчина");
        String error = newRegistrationPage.getErrorText();
        Assert.assertEquals("", error);
    }
    @Test
    public void loginUpFormButton(){
        LoginPage loginPage = registrationPage.clickLoginUpFormButton();
        String heading = loginPage.getHeadingText();
        Assert.assertEquals("Facebook", heading);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

