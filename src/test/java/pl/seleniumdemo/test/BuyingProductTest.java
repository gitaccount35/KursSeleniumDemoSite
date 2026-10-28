package pl.seleniumdemo.test;

import org.testng.annotations.Test;
import pl.seleniumdemo.pages.CartPage;
import pl.seleniumdemo.pages.DemoMainPage;
import pl.seleniumdemo.pages.SeleniumWebdrvPage;
import pl.seleniumdemo.pages.ShopPage;

public class BuyingProductTest extends BaseTest {

    @Test
    public void BuyingSelenium() throws InterruptedException {

        DemoMainPage demoMainPage = new DemoMainPage(driver);
        Thread.sleep(3000);
        demoMainPage.gotoShop();
        Thread.sleep(3000);

        ShopPage shopPage = new ShopPage(driver);
        shopPage.gotoSelenium();
        SeleniumWebdrvPage  seleniumWebdrvPage = new SeleniumWebdrvPage(driver);
        seleniumWebdrvPage.addtoCart();
        Thread.sleep(3000);

        seleniumWebdrvPage.gotoCart();
        Thread.sleep(3000);

        CartPage cartPage= new CartPage(driver);
        cartPage.checkout();
        Thread.sleep(3000);


    }
}