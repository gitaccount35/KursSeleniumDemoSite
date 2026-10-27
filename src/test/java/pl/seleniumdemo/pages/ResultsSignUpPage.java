package pl.seleniumdemo.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResultsSignUpPage {

    @FindBy(xpath = "//h1[@class='entry-title']")
    WebElement heading;
    @FindBy(xpath = "//a[text()='Dashboard']")
    WebElement dashboard;

    private final WebDriverWait wait;
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger();

    public ResultsSignUpPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getHeadingText() {
        return heading.getText();
    }

    public WebElement getDashBoard() {
        return dashboard;
    }

}





