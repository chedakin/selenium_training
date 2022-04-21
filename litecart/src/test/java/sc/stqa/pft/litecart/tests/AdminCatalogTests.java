package sc.stqa.pft.litecart.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sc.stqa.pft.litecart.models.ProductData;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.Assert.assertTrue;


public class AdminCatalogTests extends TestBase {

    @BeforeSuite
    public void startTestsFromAdminPage() {
        app.goTo().adminHomePage();
        //app.catalog().acceptCookies();
    }

    @Test
    public void testCreateNewProduct() throws MalformedURLException {
        app.goTo().menu("catalog");
        long now = System.currentTimeMillis();
        ProductData product = new ProductData()
                .withProductName(String.format("monkey%s",now))
                .withCategory("Rubber Ducks")
                .withValidFrom("01/01/2022")
                .withValidTo("12/31/2025")
                .withCode(String.format("MK%s",now))
                .withSku(String.format("RD%s",now))
                .withCompany("ACME Corp.")
                .withKeywords("monkey").withPhoto(new File("src/test/resources/1.jpg"))
                .withShortDescription("Monkey For Sale")
                .withDescription("some test product to check creation")
                .withRegularPrice("25");

        app.catalog().addNewProduct(product);

        app.goTo().menu("catalog");
        assertTrue(app.catalog().productPresents(product));

    }
}
