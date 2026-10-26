package pl.seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpPage {

    @FindBy(name="email")
    WebElement email;

    @FindBy(id="reg_password")
    WebElement password;

    @FindBy(name="register")
    WebElement register;

    @FindBy(name="username")
    WebElement loginemail;

    @FindBy(id="password")
    WebElement loginpassword;

    @FindBy (name="login")
    WebElement loginbutton;


    private final WebDriverWait wait;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setEmail(String emailtext) {
        email.sendKeys(emailtext);
        }

    public void setPassword(String passwordtext) {
        password.sendKeys(passwordtext);
        }

    public void registration(){

        register.click();
        }

    public void setLoginPassword(String passwordtext) {

        loginpassword.sendKeys(passwordtext);
    }

    public void setLoginEmail(String email) {

        loginemail.sendKeys(email);
    }

    public void login() {

        loginbutton.click();
    }
}
