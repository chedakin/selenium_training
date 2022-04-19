package sc.stqa.pft.litecart.tests;

import org.testng.annotations.Test;
import sc.stqa.pft.litecart.models.Products;


public class TemporaryTests extends TestBase{

    @Test
    public void testTemporary() {

        Products cp = app.mainPage().getCampaignProducts();

        System.out.println(cp);

    }

}
