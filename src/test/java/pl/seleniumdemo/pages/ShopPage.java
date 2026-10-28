package pl.seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopPage {

    @FindBy(xpath = "//h2[text()= 'Java Selenium WebDriver']")
    WebElement selenium;

    private final WebDriverWait wait;
    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public ShopPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void gotoSelenium() {

            selenium.click();

    }
}
