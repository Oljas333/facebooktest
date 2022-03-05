import org.openqa.selenium.OutputType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;

    public static void main(String[] args)  {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oljas\\IdeaProjects\\Driver\\chromedriver.exe");

//
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
//        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://ru-ru.facebook.com");


        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.createAccount();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.register("ola", "Kyss", "dfjjkksd", "1221", "23", "дек", "1980", "Мужчина");

        LoginPage loginPage1 = PageFactory.initElements(driver, LoginPage.class);
        loginPage1.clickPasswordReset();

        IdentifyPage identifyPage = new IdentifyPage(driver);
        identifyPage.register("hhfhh", "kfkufku");

        LoginPage loginPage2 = PageFactory.initElements(driver, LoginPage.class);
        loginPage2.clickSignInFormButton();

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.register("hhgffg", "fgdgf");



        Date dateNow = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yy_MM_dd_hh_mm_ss");
        String fileName = format.format(dateNow) + ".png";
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("C:\\Users\\oljas\\Pictures\\screenshots\\" + fileName ));
        } catch (IOException e){
            e.printStackTrace();
        }


       driver.quit();
    }
}

