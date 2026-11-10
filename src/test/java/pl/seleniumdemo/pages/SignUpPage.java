package pl.seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.seleniumdemo.utils.SeleniumHelper;

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

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    WebElement errorMessage;


    private final WebDriverWait wait;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public SignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public SignUpPage setEmail(String emailtext) {
        email.sendKeys(emailtext);
        return this;
        }

    public SignUpPage setPassword(String passwordtext) {
        password.sendKeys(passwordtext);
        return this;
        }

    public ResultsSignUpPage registration(){
        register.click();
        return new ResultsSignUpPage(driver);
        }

    public SignUpPage registrationExisting(){
        register.click();
        return this;
    }

    public SignUpPage setLoginPassword(String passwordtext) {

        loginpassword.sendKeys(passwordtext);
        return this;
    }

    public SignUpPage setLoginEmail(String email) {

        loginemail.sendKeys(email);
        return new SignUpPage(driver);
    }

    public ResultsSignUpPage login() {

        loginbutton.click();
        return new ResultsSignUpPage(driver);
    }
    public SignUpPage loginInvalid() {

        loginbutton.click();
        return this;
    }



    public WebElement getErrorMessage() {

        SeleniumHelper.waitforVisible(errorMessage, driver);
        return errorMessage;
    }

}
