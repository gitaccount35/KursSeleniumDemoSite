package pl.seleniumdemo.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.DemoMainPage;
import pl.seleniumdemo.pages.ResultsSignUpPage;
import pl.seleniumdemo.pages.SignUpPage;

public class RegistrationTest extends BaseTest
{
    @Test
    public void registrationOnSiteTest() throws InterruptedException {

        DemoMainPage demoMainPage = new DemoMainPage(driver);
        Thread.sleep(3000);
        demoMainPage.setMyAccount();
        Thread.sleep(3000);
        SignUpPage signUpPage = new SignUpPage(driver);

        int randomNumber=(int)(Math.random()*10000);
        String emailaddress="piotrmail"+randomNumber+"@gmail.com";
        signUpPage.setEmail(emailaddress);
        signUpPage.setPassword("1234567890AbCdEfGh!@");
        Thread.sleep(3000);
        signUpPage.registration();

        ResultsSignUpPage resultsSignUpPage = new ResultsSignUpPage(driver);
        Assert.assertTrue(resultsSignUpPage.getHeadingText().contains("My account"));
        Thread.sleep(3000);
    }
}
