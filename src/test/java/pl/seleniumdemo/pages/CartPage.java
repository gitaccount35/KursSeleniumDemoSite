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
}
