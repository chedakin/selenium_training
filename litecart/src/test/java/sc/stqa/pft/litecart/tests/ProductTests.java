package sc.stqa.pft.litecart.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sc.stqa.pft.litecart.models.ProductData;
import sc.stqa.pft.litecart.models.Products;

import static org.testng.Assert.assertEquals;

public class ProductTests extends TestBase {

    @BeforeTest
    public void startFromMainPage() {
        app.goTo().mainPage();
    }

    @Test
    public void testCompareCampaignProductDataWithMainPage(){
        Products mainProducts = app.mainPage().getCampaignProducts();
        ProductData mainProduct = mainProducts.stream().toList().get(0);

        app.mainPage().viewCampaignProduct();
        ProductData product = app.product().getProductData();

        logger.info("From Main: " + mainProduct);
        logger.info("From view: " + product);

        assertEquals(mainProduct, product);

    }
}
