import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IdentifyPage {
    private WebDriver driver;

    public IdentifyPage(WebDriver driver) {
        this.driver = driver;
    }

    private By heading = By.xpath("//h2[@class='uiHeaderTitle']");
    private By error = By.xpath("//div[@class='pam uiBoxRed']");
    private By emailField = By.xpath("//input[@type='email']");
    private By passwordField = By.xpath("//input[@type='password']");
    private By signUpButton = By.xpath("(//span[@class='a8c37x1j ni8dbmo4 stjgntxs l9j0dhe7 ltmttdrg g0qnabr5'])[2]");
    private By passwordReset = By.xpath("//a[text()='Забыли пароль?']");
    private By identifyEmailReset = By.xpath(".//*[@id='identify_email']");
    private By cancelButton = By.xpath("//div[@class='rfloat _ohf']/a");
    private By submitButton = By.xpath(".//*[@id='did_submit']");

    public String getHeadingText() {

        return driver.findElement(heading).getText();
    }

    public String getErrorText() {

        return driver.findElement(error).getText();
    }

    public IdentifyPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public IdentifyPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage clickSignUpFormButton() {
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public IdentifyPage clickPasswordReset() {
        driver.findElement(passwordReset).click();
        return new IdentifyPage(driver);
    }

    public IdentifyPage typeidentifyEmail(String email) {
        driver.findElement(identifyEmailReset).sendKeys(email);
        return this;
    }

    public LoginPage clickCancelButton() {
        driver.findElement(cancelButton).click();
        return new LoginPage(driver);
    }

    public SignUpPage clicksubmitButton() {
        driver.findElement(submitButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage register(String email, String password) {
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpFormButton();
        return new SignUpPage(driver);
    }
}
