package pl.seleniumdemo.test;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.DemoMainPage;


public class RegistrationTest extends BaseTest {
    @Test
    public void registrationOnSiteTest() {

        ExtentTest test = extentReports.createTest("registrationOnSiteTest");

        int randomNumber = (int) (Math.random() * 10000);
        String emailaddress = "piotrmail" + randomNumber + "@gmail.com";

        WebElement dashboard = new DemoMainPage(driver)
                .setMyAccount()
                .setEmail(emailaddress)
                .setPassword("1234567890AbCdEfGh!@")
                .registration()
                .getDashBoard();

        /*
        DemoMainPage demoMainPage = new DemoMainPage(driver);
        //Thread.sleep(3000);
        demoMainPage.setMyAccount();
       // Thread.sleep(3000);
        SignUpPage signUpPage = new SignUpPage(driver);

        int randomNumber = (int) (Math.random() * 10000);
        String emailaddress = "piotrmail" + randomNumber + "@gmail.com";
        signUpPage.setEmail(emailaddress);
        signUpPage.setPassword("1234567890AbCdEfGh!@");
        //Thread.sleep(3000);
        signUpPage.registration();

        ResultsSignUpPage resultsSignUpPage = new ResultsSignUpPage(driver);
        */

        Assert.assertTrue(dashboard.getText().contains("Dashboard"));

        //Thread.sleep(3000);
    }

    @Test
    public void registExistingUserOnSiteTest()  {

        ExtentTest test = extentReports.createTest("registExistingUserOnSiteTest");

        WebElement error = new DemoMainPage(driver)
                .setMyAccount()
                .setEmail("piotr_email1235@gmail.com")
                .setPassword("1234567890AbCdEfGh!@")
                .registrationExisting()
                .getErrorMessage();

        /*
        DemoMainPage demoMainPage = new DemoMainPage(driver);
       // Thread.sleep(3000);
        demoMainPage.setMyAccount();
        //Thread.sleep(3000);
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.setEmail("piotr_email1235@gmail.com");
        signUpPage.setPassword("1234567890AbCdEfGh!@");
       // Thread.sleep(3000);
        signUpPage.registration();

         */

        Assert.assertTrue(error.getText()
                .contains("An account is already registered with your email address. "));
        //Thread.sleep(3000);
    }
}