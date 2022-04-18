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


    }

}
