package sc.stqa.pft.litecart.tests;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AdminLogin extends TestBase{
    private WebDriverWait wait;

    @Test
    public void testAdminLogin() {
        wait = new WebDriverWait(app.driver, 10);

    }
}
