package pl.seleniumdemo.test;

import org.testng.annotations.Test;
import pl.seleniumdemo.pages.DemoMainPage;

public class RejestracjaTest extends BaseTest
{
    @Test
    public void rejestracjaOnSiteTest() throws InterruptedException {

        DemoMainPage demoMainPage = new DemoMainPage(driver);
        Thread.sleep(3000);
    }
}
