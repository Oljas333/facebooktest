import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistrationPage {
    private WebDriver driver;


    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }


    private By heading = By.xpath("//img[@alt='Facebook']");
    private By userName = By.xpath("//input[@aria-label='Имя']");
    private By userSurName = By.xpath("//input[@aria-label='Фамилия']");
    private By error = By.xpath("//i[@class='_5dbc img sp_98fCI7IVTTz sx_54513f']");
    private By emailField = By.xpath("//input[@aria-label='Номер мобильного телефона или эл. адрес']");
    private By passwordField = By.xpath("//input[@aria-label='Новый пароль']");
    private By userDay = By.xpath(".//*[@id='day']");
    private By userMonth = By.xpath(".//*[@id='month']");
    private By userYear = By.xpath(".//*[@id='year']");
    private By signUpButton = By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _6o _6v']");
    private By loginUpButton = By.xpath("//a[text()='У вас уже есть аккаунт?']");
    private By selectCheckBox = By.xpath("//label[text()='%s']']");


    public String getHeadingText() {

        return driver.findElement(heading).getText();
    }

    public RegistrationPage typeUserName(String username) {
        driver.findElement(userName).sendKeys(username);
        return this;
    }

    public RegistrationPage typeSurUserName(String usersurname) {
        driver.findElement(userSurName).sendKeys(usersurname);
        return this;
    }

    public String getErrorText() {

        return driver.findElement(error).getText();
    }

    public RegistrationPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public RegistrationPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public RegistrationPage typeSelectUserDay(String option1) {
        String listXpath = String.format(".//*[@id='day']");
        String optionXpath = String.format("(//option[text()='%s'])[1]", option1);
        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();
        return this;
    }

    public RegistrationPage typeSelectUserMonth(String option2) {
        String listXpath = String.format(".//*[@id='month']");
        String optionXpath = String.format("(//option[text()='%s'])[1]", option2);
        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();
        return this;
    }

    public RegistrationPage typeSelectUserYear(String option3) {
        String listXpath = String.format(".//*[@id='year']");
        String optionXpath = String.format("(//option[text()='%s'])[1]", option3);
        driver.findElement(By.xpath(listXpath)).click();
        driver.findElement(By.xpath(optionXpath)).click();
        return this;
    }


    public RegistrationPage clickSignUpFormButton() {
        driver.findElement(signUpButton).click();
        return this;
    }
    public LoginPage clickLoginUpFormButton() {
        driver.findElement(loginUpButton).click();
        return new LoginPage(driver);
    }


    public RegistrationPage typeSelectRadioButton(String name) {
        String rbXpath = "//label[text()='%s']";
        driver.findElement(By.xpath(String.format(rbXpath, name))).click();
        return this;

    }

    public RegistrationPage register(String username, String usersurname, String email, String password, String option1, String option2, String option3, String name) {
        this.typeUserName(username);
        this.typeSurUserName(usersurname);
        this.typeEmail(email);
        this.typePassword(password);
        this.typeSelectUserDay(option1);
        this.typeSelectUserMonth(option2);
        this.typeSelectUserYear(option3);
        this.typeSelectRadioButton(name);
        this.clickSignUpFormButton();
        return new RegistrationPage(driver);
    }


}
