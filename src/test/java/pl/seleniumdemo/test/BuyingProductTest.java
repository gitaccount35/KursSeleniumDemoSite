package pl.seleniumdemo.test;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.models.Customer;
import pl.seleniumdemo.pages.*;

public class BuyingProductTest extends BaseTest {

    @Test
    public void BuyingProduct() throws InterruptedException {

        ExtentTest test = extentReports.createTest("BuyingProduct");
        Customer  customer = new Customer();

        WebElement order = new DemoMainPage(driver)
                .gotoShop()
                .gotoProductPage("Java Selenium WebDriver")
                .addtoCart()
                .gotoCart()
                .checkout()
                .setCustData(customer)
                .placeOrder()
                .getOrderSummary();

        /*
        DemoMainPage demoMainPage = new DemoMainPage(driver);
       // Thread.sleep(3000);
        demoMainPage.gotoShop();
        //Thread.sleep(3000);

        ShopPage shopPage = new ShopPage(driver);
        shopPage.gotoProductPage("Java Selenium WebDriver");
        ProductPage productPage = new ProductPage(driver);
        productPage.addtoCart();
        //Thread.sleep(3000);

        productPage.gotoCart();
        //Thread.sleep(3000);

        CartPage cartPage= new CartPage(driver);
        cartPage.checkout();
        //Thread.sleep(3000);

        Customer customer = new Customer();
        cartPage.setCustData(customer);

        //Thread.sleep(3000);
        cartPage.placeOrder();
        //Thread.sleep(5000);
        OrdersPage ordersPage = new OrdersPage(driver);
         */

        Assert.assertTrue(order.getText()
                .contains("Thank you. Your order has been received."));
        //Thread.sleep(3000);


    }
}