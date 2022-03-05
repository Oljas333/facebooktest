import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//div[@class='_9axz']");
    private By error = By.xpath("//div[@class='_9ay7']");
    private By emailField = By.xpath(".//*[@id='email']");
    private By passwordField = By.xpath(".//*[@id='pass']");
    private By signUpButton = By.xpath(".//*[@id='loginbutton']");
    private By passwordReset = By.xpath("//a[text()='Забыли пароль?']");

    public String getHeadingText() {

        return driver.findElement(heading).getText();
    }

    public String getErrorText() {

        return driver.findElement(error).getText();
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage clickSignUpFormButton() {
        driver.findElement(signUpButton).click();
        return this;
    }

    public IdentifyPage clickPasswordReset() {
        driver.findElement(passwordReset).click();
        return new IdentifyPage(driver);
    }

    public SignUpPage register(String email, String password) {
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }


}
