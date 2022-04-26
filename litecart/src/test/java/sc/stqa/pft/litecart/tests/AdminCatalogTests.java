package sc.stqa.pft.litecart.tests;

import org.openqa.selenium.logging.LogEntries;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sc.stqa.pft.litecart.models.ProductData;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class AdminCatalogTests extends TestBase {

    @BeforeSuite
    public void startTestsFromAdminPage() {
        app.goTo().adminHomePage();
        //app.catalog().acceptCookies();
    }
    @DataProvider
    public Iterator<Object[]> listOfProducts() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new String[] {"Bear"});
        list.add(new String[] {"Blue Duck"});
        list.add(new String[] {"Green Duck"});
        list.add(new String[] {"Monkey"});
        list.add(new String[] {"monkey1650558079008"});
        list.add(new String[] {"monkey1650972641809"});
        list.add(new String[] {"monkey1650973132780"});
        list.add(new String[] {"Purple Duck"});
        list.add(new String[] {"Red Duck"});
        list.add(new String[] {"Yellow Duck"});
        return list.iterator();
    }

    @Test(enabled = true)
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

    @Test(enabled = true, dataProvider = "listOfProducts")
    public void testEditProductPageJSErrors(String productName) {
        app.goTo().menu("catalog");
        ProductData product = new ProductData().withProductName(productName).withCategory("Rubber Ducks");
        app.catalog().editProduct(product);
        LogEntries logs = app.catalog().getBrowserLogs();
        logs.forEach(l -> logger.error(String.format("Product %s: \n%s", product, String.valueOf(l))));
        assertEquals(logs.getAll().size(), 0);
    }
}
