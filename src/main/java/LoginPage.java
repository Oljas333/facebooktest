import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    private By emailField = By.xpath(".//*[@id='email']");
    private By passwordField = By.xpath(".//*[@id='pass']");
    private By signInButton = By.xpath("//button[@class='_42ft _4jy0 _6lth _4jy6 _4jy1 selected _51sy']");
    private By newAccountButton = By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']");
    private By heading = By.xpath("//h2[@class='_8eso']");
    private By error = By.xpath("//div[@class='_9ay7']");
    private By passwordReset = By.xpath("//a[text()='Забыли пароль?']");


    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage clickSignInFormButton() {
        driver.findElement(signInButton).click();
        return new SignUpPage(driver);
    }

    public LoginPage loginWithInvalidCreds(String email, String password) {
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public LoginPage createAccount() {
        driver.findElement(newAccountButton).click();
        return this;
    }

    public String getHeadingText() {

        return driver.findElement(heading).getText();
    }

    public String getErrorText() {

        return driver.findElement(error).getText();
    }

    public LoginPage loginWithEmptyCredsTest(String email, String password) {
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signInButton).click();
        return new LoginPage(driver);
    }

    public IdentifyPage clickPasswordReset() {
        driver.findElement(passwordReset).click();
        return new IdentifyPage(driver);
    }


}
