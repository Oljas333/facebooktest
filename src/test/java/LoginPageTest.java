import clojure.lang.IFn;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private Object identifyPage;
    private IdentifyPage signUpPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://ru-ru.facebook.com");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithEmptyCredsTest() {
        LoginPage newLoginPage = loginPage.loginWithEmptyCredsTest("", "");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Веденный вами электронный адрес или номер мобильного телефона не связан ни с одним аккаунтом. Найдите свой аккаунт и войдите в систему.", error);
    }

    @Test
    public void loginWithIncorrectCredsTest() {
        LoginPage newLoginPage = loginPage.loginWithInvalidCreds("qweqewqwe", "qweqweweqwe");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Вы ввели неверный пароль. Забыли пароль?", error);
    }

    @Test
    public void createAccTest() {
        LoginPage signUpPage = loginPage.createAccount();
        String heading = signUpPage.getHeadingText();
        Assert.assertEquals("Facebook помогает вам всегда оставаться на связи и общаться со своими знакомыми.", heading);
    }

    @Test
    public void clickPasswordReset() {
        IdentifyPage identifyPage = loginPage.clickPasswordReset();
        String heading = identifyPage.getHeadingText();
        Assert.assertEquals("Поиск аккаунта", heading);

    }

    @Test
    public void PasswordFailTest() {
        LoginPage newLoginPage = loginPage.typePassword("fghfghfgh");
        loginPage.clickSignInFormButton();
        String error = loginPage.getErrorText();
        Assert.assertEquals("Веденный вами электронный адрес или номер мобильного телефона не связан ни с одним аккаунтом. Найдите свой аккаунт и войдите в систему.", error);

    }


    @After
    public void tearDown() {
        driver.quit();
    }

}
