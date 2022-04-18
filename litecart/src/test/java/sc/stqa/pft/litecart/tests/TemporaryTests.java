package sc.stqa.pft.litecart.tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TemporaryTests extends TestBase{

    @Test
    public void testTemporary() {

        app.goTo().adminHomePage();
        app.goTo().dashboard();
        app.goTo().menu("appearance");

        System.out.println(app.goTo().getPageHeader());

        app.goTo().menu("settings");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader().substring(11), "Store Info");

        app.goTo().subMenu("settings", "store_info");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader().substring(11), "Store Info");
/*
        app.goTo().subMenu("settings", "defaults");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader(), "Settings – Defaults");

        app.goTo().subMenu("settings", "email");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader(), "Settings – Email");

        app.goTo().subMenu("settings", "listings");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader(), "Settings – Listings");

        app.goTo().subMenu("settings", "customer_details");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader(), "Settings – Customer Details");

        app.goTo().subMenu("settings", "legal");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader(), "Settings – Legal");

        app.goTo().subMenu("settings", "images");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader(), "Settings – Images");

        app.goTo().subMenu("settings", "checkout");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader(), "Settings – Checkout");

        app.goTo().subMenu("settings", "advanced");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader(), "Settings – Advanced");

        app.goTo().subMenu("settings", "security");
        assertEquals(app.goTo().whereAmI(),"Settings | My Store");
        assertEquals(app.goTo().getPageHeader(), "Settings – Security");

 */

    }

}
