package sc.stqa.pft.litecart.tests;

import org.openqa.selenium.support.Color;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ProductCardPriceTests extends TestBase {

    @BeforeTest
    public void startTestFromProductCard() {
        app.goTo().mainPage();
        app.mainPage().viewCampaignProduct();
    }

    @Test(enabled = true)
    public void testPriceColor() {
        Color regularPriceView = app.product().getPriceColor("regular");
        Color campaignPriceView = app.product().getPriceColor("campaign");

        logger.info(String.format("Regular Price: %s", regularPriceView));
        logger.info(String.format("Campaign Price: %s", campaignPriceView));

        //Regular Price
        //Color grey:

        assertTrue(regularPriceView.getColor().getRed() == regularPriceView.getColor().getBlue()
                && regularPriceView.getColor().getBlue() == regularPriceView.getColor().getGreen());

        //Campaign Price
        //Color red:

        assertTrue(campaignPriceView.getColor().getRed() != 0
                && campaignPriceView.getColor().getBlue() == 0
                && campaignPriceView.getColor().getGreen() == 0);

    }

    @Test(enabled = true)
    public void testPriceSize() {
        int regularWidth = app.product().getPriceSize("regular", "width");
        int regularHeight = app.product().getPriceSize("regular", "height");
        int campaignWidth = app.product().getPriceSize("campaign", "width");
        int campaignHeight = app.product().getPriceSize("campaign", "height");

        logger.info(String.format("Regular Price: H = %s, W = %s", regularHeight, regularWidth));
        logger.info(String.format("Campaign Price: H = %s, W = %s", campaignHeight, campaignWidth));

        assertTrue(campaignWidth > regularWidth);
        assertTrue(campaignHeight > regularHeight);

    }

    @Test(enabled = true)
    public void testCampaignPriceBold() {

        assertTrue(app.product().isPriceBold("campaign"));
        assertFalse(app.product().isPriceBold("regular"));

    }

    @Test(enabled = true)
    public void testRegularPriceLineThrough() {

        assertFalse(app.product().isPriceLineThrough("campaign"));
        assertTrue(app.product().isPriceLineThrough("regular"));

    }

}
