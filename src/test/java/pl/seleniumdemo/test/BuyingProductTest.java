package pl.seleniumdemo.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.*;

public class BuyingProductTest extends BaseTest {

    @Test
    public void BuyingProduct() throws InterruptedException {

        DemoMainPage demoMainPage = new DemoMainPage(driver);
        Thread.sleep(3000);
        demoMainPage.gotoShop();
        Thread.sleep(3000);

        ShopPage shopPage = new ShopPage(driver);
        shopPage.gotoProductPage("Java Selenium WebDriver");
        ProductPage productPage = new ProductPage(driver);
        productPage.addtoCart();
        Thread.sleep(3000);

        productPage.gotoCart();
        Thread.sleep(3000);

        CartPage cartPage= new CartPage(driver);
        cartPage.checkout();
        Thread.sleep(3000);

        cartPage.setFirstName("Piotr");
        cartPage.setLastName("Testowy");
        cartPage.setAddress("Warszawska 17");
        cartPage.setPostCode("00-100");
        cartPage.setCity("Warszawa");
        cartPage.setPhone("48500700800");
        cartPage.setEmail("piotr_email1235@gmail.com");
        Thread.sleep(3000);
        cartPage.placeOrder();
        Thread.sleep(5000);

        OrdersPage ordersPage = new OrdersPage(driver);
        Assert.assertTrue(ordersPage.getOrderSummary().getText()
                .contains("Thank you. Your order has been received."));
        Thread.sleep(3000);


    }
}