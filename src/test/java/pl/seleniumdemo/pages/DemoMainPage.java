package pl.seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DemoMainPage {


    @FindBy(xpath = "//span[text()= 'My account']")
    List<WebElement> myaccount;



    private final WebDriverWait wait;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    public DemoMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void setMyAccount() {

        myaccount.stream().filter(WebElement::isDisplayed)
                .findFirst().ifPresent(WebElement::click);
    }
}
