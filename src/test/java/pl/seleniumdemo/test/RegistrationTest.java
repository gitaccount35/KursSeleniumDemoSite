package pl.seleniumdemo.test;

import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.DemoMainPage;
import pl.seleniumdemo.pages.ResultsSignUpPage;
import pl.seleniumdemo.pages.SignUpPage;

public class RegistrationTest extends BaseTest {
    @Test
    public void registrationOnSiteTest() throws InterruptedException {

        ExtentTest test = extentReports.createTest("registrationOnSiteTest");

        DemoMainPage demoMainPage = new DemoMainPage(driver);
        Thread.sleep(3000);
        demoMainPage.setMyAccount();
        Thread.sleep(3000);
        SignUpPage signUpPage = new SignUpPage(driver);

        int randomNumber = (int) (Math.random() * 10000);
        String emailaddress = "piotrmail" + randomNumber + "@gmail.com";
        signUpPage.setEmail(emailaddress);
        signUpPage.setPassword("1234567890AbCdEfGh!@");
        Thread.sleep(3000);
        signUpPage.registration();

        ResultsSignUpPage resultsSignUpPage = new ResultsSignUpPage(driver);
        Assert.assertTrue(resultsSignUpPage.getDashBoard().getText().contains("Dashboard"));
        Thread.sleep(3000);
    }

    @Test
    public void registExistingUserOnSiteTest() throws InterruptedException {

        ExtentTest test = extentReports.createTest("registExistingUserOnSiteTest");

        DemoMainPage demoMainPage = new DemoMainPage(driver);
        Thread.sleep(3000);
        demoMainPage.setMyAccount();
        Thread.sleep(3000);
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.setEmail("piotr_email1235@gmail.com");
        signUpPage.setPassword("1234567890AbCdEfGh!@");
        Thread.sleep(3000);
        signUpPage.registration();
        Assert.assertTrue(signUpPage.getErrorMessage().getText()
                .contains("An account is already registered with your email address. "));
        Thread.sleep(3000);
    }
}