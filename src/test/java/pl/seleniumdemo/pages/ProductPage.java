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
import java.util.List;

public class ProductPage {

    @FindBy(name = "add-to-cart")
    WebElement addToCart;

    @FindBy(xpath = "//span[text()= 'Cart']")
    List<WebElement> cart;
    

    private final WebDriverWait wait;
    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public ProductPage addtoCart() {
        addToCart.click();
        return this;
    }

    public CartPage gotoCart() {

        //SeleniumHelper.waitforVisible((WebElement) cart, driver);

        cart.stream().filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);
    return new CartPage(driver);
    }
}
