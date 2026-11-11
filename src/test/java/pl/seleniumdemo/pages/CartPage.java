package pl.seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.seleniumdemo.models.Customer;
import pl.seleniumdemo.utils.SeleniumHelper;

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

    @FindBy(id="billing_country")
    WebElement country;

    private final WebDriverWait wait;
    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public CartPage checkout() {

        SeleniumHelper.waitforVisible(checkoutButton, driver);
        checkoutButton.click();
        return this;
        }

    public CartPage setCustData(Customer customer){

        firstName.sendKeys(customer.getFirstName());
        lastName.sendKeys(customer.getLastName());
        address1.sendKeys(customer.getAddress());
        postcode.sendKeys(customer.getPostcode());
        city.sendKeys(customer.getCity());
        phone.sendKeys(customer.getPhone());
        email.sendKeys(customer.getEmail());

        Select countrySelect = new Select(country);
        countrySelect.selectByVisibleText(customer.getCountry());

        return this;
    }


    public OrdersPage placeOrder() {
        order.click();
    return new OrdersPage(driver);
    }
}

