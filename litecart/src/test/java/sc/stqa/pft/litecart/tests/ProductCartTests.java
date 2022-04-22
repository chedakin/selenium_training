package sc.stqa.pft.litecart.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductCartTests extends TestBase {

    @BeforeSuite(alwaysRun = true)
    public void acceptCookies() {
        app.mainPage().acceptCookies();
    }

    @BeforeTest(alwaysRun = true)
    public void startTestFromMainPage() {
        app.goTo().mainPage();
    }

    @Test
    public void testAddProductToCart() throws InterruptedException {
        int productsInCart = app.product().productsInCart();

        app.goTo().mainPage();
        app.mainPage().viewPopularProduct();
        app.product().addProductToCart();
        assertEquals(app.product().productsInCart(), productsInCart+1);


        app.goTo().mainPage();
        app.mainPage().viewPopularProduct();
        app.product().addProductToCart();
        assertEquals(app.product().productsInCart(), productsInCart+2);

        app.goTo().mainPage();
        app.mainPage().viewPopularProduct();
        app.product().addProductToCart();
        assertEquals(app.product().productsInCart(), productsInCart+3);

        app.goTo().mainPage();
        app.goTo().cart();
        assertEquals(app.cart().calculateProductsInCart(), productsInCart+3);


    }

    @Test(enabled = false)
    public void testRemoveProductFromCart() throws InterruptedException {
        app.goTo().mainPage();
        if(app.product().productsInCart()<3) {
            app.mainPage().viewPopularProduct();
            app.product().addProductToCart();
            app.goTo().mainPage();
            app.mainPage().viewPopularProduct();
            app.product().addProductToCart();
            app.goTo().mainPage();
            app.mainPage().viewPopularProduct();
            app.product().addProductToCart();
            app.goTo().mainPage();
        }

        app.goTo().cart();
        int productsInCart = app.cart().calculateProductsInCart();

        while(productsInCart > 0) {
            app.cart().removeProductFromCart();
            productsInCart = app.cart().calculateProductsInCart();

        }
        app.cart().leaveBlankCart();

        assertEquals(app.product().productsInCart(), 0);

    }
}
