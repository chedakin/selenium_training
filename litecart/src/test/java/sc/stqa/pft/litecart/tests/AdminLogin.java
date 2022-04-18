package sc.stqa.pft.litecart.tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class AdminLogin extends TestBase{

    @Test
    public void testAdminLogin() {
        app.goTo().adminHomePage();
        assertEquals(app.goTo().whereAmI(),"Dashboard | My Store");

    }
}
