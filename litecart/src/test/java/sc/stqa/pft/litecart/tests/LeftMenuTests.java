package sc.stqa.pft.litecart.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LeftMenuTests extends TestBase{

    @BeforeSuite
    public void adminAccount(){
        app.goTo().adminHomePage();
    }

    @BeforeTest
    public void startFromDashboard(){
        app.goTo().dashboard();
    }

    @Test
    public void testAppearance() {
        app.goTo().menu("appearance");
        assertEquals(app.goTo().whereAmI(),"Template | My Store");

        app.goTo().subMenu("appearance", "template");
        assertEquals(app.goTo().whereAmI(),"Template | My Store");

        app.goTo().subMenu("appearance", "logotype");
        assertEquals(app.goTo().whereAmI(),"Logotype | My Store");

        app.goTo().subMenu("appearance", "edit_styling");
        assertEquals(app.goTo().whereAmI(),"My Store");


    }

    @Test
    public void testCatalog() {
        app.goTo().menu("catalog");
        assertEquals(app.goTo().whereAmI(),"Catalog | My Store");

        app.goTo().subMenu("catalog", "catalog");
        assertEquals(app.goTo().whereAmI(),"Catalog | My Store");

        app.goTo().subMenu("catalog", "attribute_groups");
        assertEquals(app.goTo().whereAmI(),"Attribute Groups | My Store");

        app.goTo().subMenu("catalog", "manufacturers");
        assertEquals(app.goTo().whereAmI(),"Manufacturers | My Store");

        app.goTo().subMenu("catalog", "suppliers");
        assertEquals(app.goTo().whereAmI(),"Suppliers | My Store");

        app.goTo().subMenu("catalog", "delivery_statuses");
        assertEquals(app.goTo().whereAmI(),"Delivery Statuses | My Store");

        app.goTo().subMenu("catalog", "sold_out_statuses");
        assertEquals(app.goTo().whereAmI(),"Sold Out Statuses | My Store");

        app.goTo().subMenu("catalog", "quantity_units");
        assertEquals(app.goTo().whereAmI(),"Quantity Units | My Store");

        app.goTo().subMenu("catalog", "csv");
        assertEquals(app.goTo().whereAmI(),"Import/Export CSV | My Store");
    }

    @Test
    public void testCountries() {
        app.goTo().menu("countries");
        assertEquals(app.goTo().whereAmI(),"Countries | My Store");
    }

    @Test
    public void testCurrencies() {
        app.goTo().menu("currencies");
        assertEquals(app.goTo().whereAmI(),"Currencies | My Store");
    }

    @Test
    public void testCustomers() {
        app.goTo().menu("customers");
        assertEquals(app.goTo().whereAmI(),"Customers | My Store");

        app.goTo().subMenu("customers", "customers");
        assertEquals(app.goTo().whereAmI(),"Customers | My Store");

        app.goTo().subMenu("customers", "csv");
        assertEquals(app.goTo().whereAmI(),"CSV Import/Export | My Store");

        app.goTo().subMenu("customers", "newsletter_recipients");
        assertEquals(app.goTo().whereAmI(),"My Store");
    }

    @Test
    public void testGeoZones() {
        app.goTo().menu("geo_zones");
        assertEquals(app.goTo().whereAmI(),"Geo Zones | My Store");
    }

    @Test
    public void testLanguages() {
        app.goTo().menu("languages");
        assertEquals(app.goTo().whereAmI(),"Languages | My Store");

        app.goTo().subMenu("languages", "languages");
        assertEquals(app.goTo().whereAmI(),"Languages | My Store");

        app.goTo().subMenu("languages", "storage_encoding");
        assertEquals(app.goTo().whereAmI(),"Storage Encoding | My Store");

    }

    @Test
    public void testModules() {
        app.goTo().menu("modules");
        assertEquals(app.goTo().whereAmI(),"Customer Modules | My Store");

        app.goTo().subMenu("modules", "customer");
        assertEquals(app.goTo().whereAmI(),"Customer Modules | My Store");

        app.goTo().subMenu("modules", "shipping");
        assertEquals(app.goTo().whereAmI(),"Shipping Modules | My Store");

        app.goTo().subMenu("modules", "payment");
        assertEquals(app.goTo().whereAmI(),"Payment Modules | My Store");

        app.goTo().subMenu("modules", "order");
        assertEquals(app.goTo().whereAmI(),"Order Modules | My Store");

        app.goTo().subMenu("modules", "order_total");
        assertEquals(app.goTo().whereAmI(),"Order Total Modules | My Store");

        app.goTo().subMenu("modules", "jobs");
        assertEquals(app.goTo().whereAmI(),"Job Modules | My Store");
    }

    @Test
    public void testOrders() {
        app.goTo().menu("orders");
        assertEquals(app.goTo().whereAmI(),"Orders | My Store");

        app.goTo().subMenu("orders", "orders");
        assertEquals(app.goTo().whereAmI(),"Orders | My Store");

        app.goTo().subMenu("orders", "order_statuses");
        assertEquals(app.goTo().whereAmI(),"Order Statuses | My Store");
    }

    @Test
    public void testPages() {
        app.goTo().menu("pages");
        assertEquals(app.goTo().whereAmI(),"Pages | My Store");

        app.goTo().subMenu("pages", "pages");
        assertEquals(app.goTo().whereAmI(),"Pages | My Store");

        app.goTo().subMenu("pages", "csv");
        assertEquals(app.goTo().whereAmI(),"CSV Import/Export | My Store");
    }

    @Test
    public void testReports() {
        app.goTo().menu("reports");
        assertEquals(app.goTo().whereAmI(),"Monthly Sales | My Store");

        app.goTo().subMenu("reports", "monthly_sales");
        assertEquals(app.goTo().whereAmI(),"Monthly Sales | My Store");

        app.goTo().subMenu("reports", "most_sold_products");
        assertEquals(app.goTo().whereAmI(),"Most Sold Products | My Store");

        app.goTo().subMenu("reports", "most_shopping_customers");
        assertEquals(app.goTo().whereAmI(),"Most Shopping Customers | My Store");
    }

    @Test
    public void testSettings() {
        app.goTo().menu("settings");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader().substring(11), "Store Info");

        app.goTo().subMenu("settings", "store_info");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader().substring(11), "Store Info");

        app.goTo().subMenu("settings", "defaults");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader().substring(11), "Defaults");

        app.goTo().subMenu("settings", "email");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader().substring(11), "Email");

        app.goTo().subMenu("settings", "listings");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader().substring(11), "Listings");

        app.goTo().subMenu("settings", "customer_details");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader().substring(11), "Customer Details");

        app.goTo().subMenu("settings", "legal");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader().substring(11), "Legal");

        app.goTo().subMenu("settings", "images");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader().substring(11), "Images");

        app.goTo().subMenu("settings", "checkout");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader().substring(11), "Checkout");

        app.goTo().subMenu("settings", "advanced");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader().substring(11), "Advanced");

        app.goTo().subMenu("settings", "security");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader().substring(11), "Security");
    }

    @Test
    public void testSlides() {
        app.goTo().menu("slides");
        assertEquals(app.goTo().whereAmI(),"Slides | My Store");
    }

    @Test
    public void testTax() {
        app.goTo().menu("tax");
        assertEquals(app.goTo().whereAmI(),"Tax Rates | My Store");

        app.goTo().subMenu("tax", "tax_rates");
        assertEquals(app.goTo().whereAmI(),"Tax Rates | My Store");

        app.goTo().subMenu("tax", "tax_classes");
        assertEquals(app.goTo().whereAmI(),"Tax Classes | My Store");
    }

    @Test
    public void testTranslations() {
        app.goTo().menu("translations");
        assertEquals(app.goTo().whereAmI(),"Search Translations | My Store");

        app.goTo().subMenu("translations", "search");
        assertEquals(app.goTo().whereAmI(),"Search Translations | My Store");

        app.goTo().subMenu("translations", "scan");
        assertEquals(app.goTo().whereAmI(),"Scan Translations | My Store");

        app.goTo().subMenu("translations", "csv");
        assertEquals(app.goTo().whereAmI(),"Import/Export CSV | My Store");
    }

    @Test
    public void testUsers() {
        app.goTo().menu("users");
        assertEquals(app.goTo().whereAmI(),"Users | My Store");
    }

    @Test
    public void testvQmods() {
        app.goTo().menu("vqmods");
        assertEquals(app.goTo().whereAmI(),"vQmods | My Store");
    }
}
