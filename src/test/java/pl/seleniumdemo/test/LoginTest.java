package pl.seleniumdemo.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.DemoMainPage;
import pl.seleniumdemo.pages.ResultsSignUpPage;
import pl.seleniumdemo.pages.SignUpPage;


public class LoginTest extends BaseTest  {

        @Test
        public void LoginTestFunction() throws InterruptedException {

            DemoMainPage demoMainPage = new DemoMainPage(driver);
            Thread.sleep(3000);
            demoMainPage.setMyAccount();
            Thread.sleep(3000);
            SignUpPage signUpPage = new SignUpPage(driver);

            signUpPage.setLoginEmail("piotr_email1235@gmail.com");
            signUpPage.setLoginPassword("1234567890AbCdEfGh!@");
            Thread.sleep(3000);
            signUpPage.login();

            ResultsSignUpPage resultsSignUpPage = new ResultsSignUpPage(driver);
            Assert.assertTrue(resultsSignUpPage.getDashBoard().getText().contains("Dashboard"));
            Thread.sleep(3000);

        }
    @Test
    public void LoginIncorrectPasswordTest() throws InterruptedException {

        DemoMainPage demoMainPage = new DemoMainPage(driver);
        Thread.sleep(3000);
        demoMainPage.setMyAccount();
        Thread.sleep(3000);
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.setLoginEmail("piotr_email1235@gmail.com");
        signUpPage.setLoginPassword("1234567890AbCdEf");
        Thread.sleep(3000);
        signUpPage.login();

        Assert.assertTrue(signUpPage.getErrorMessage().getText()
                .contains("Incorrect username or password"));
        Thread.sleep(3000);
    }





}
