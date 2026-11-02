package pl.seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    @FindBy(xpath = "//a[contains(text(),'Proceed to checkout')]")
    WebElement checkoutButton;

    @FindBy(id = "billing_first_name")
    WebElement firstName;

    @FindBy(id="billing_last_name")
    WebElement lastName;

    @FindBy(id="billing_address_1")
    WebElement address1;

    @FindBy(id="billing_postcode")
    WebElement postcode;

    @FindBy(id="billing_city")
    WebElement city;

    @FindBy(id="billing_phone")
    WebElement phone;

    @FindBy(id="billing_email")
    WebElement email;

    @FindBy(id="place_order")
    WebElement order;

    private final WebDriverWait wait;
    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkout() {
        checkoutButton.click();
    }

    public void setFirstName(String firstNameValue) {
        firstName.sendKeys(firstNameValue);
    }

    public void setLastName(String lastNameValue) {
        lastName.sendKeys(lastNameValue);
    }

    public void setAddress(String addressValue) {
        address1.sendKeys(addressValue);
    }

    public void setPostCode(String postCodeValue) {
        postcode.sendKeys(postCodeValue);
    }

    public void setCity(String cityValue) {
        city.sendKeys(cityValue);
    }

    public void setPhone(String number) {
        phone.sendKeys(number);
    }

    public void setEmail(String mail) {
        email.sendKeys(mail);
    }

    public void placeOrder() {
        order.click();
    }
}
