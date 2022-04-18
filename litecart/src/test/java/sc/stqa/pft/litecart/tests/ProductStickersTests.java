package sc.stqa.pft.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ProductStickersTests extends TestBase {

    @Test
    public void testProductsHaveSticker() {

        app.goTo().mainPage();
        List<WebElement> products = app.mainPage().getAllProducts();

        for(WebElement product : products) {
            assertEquals(product.findElements(By.cssSelector("[class^=sticker]")).size(), 1);
        }

    }
}
