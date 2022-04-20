package sc.stqa.pft.litecart.tests;

import org.openqa.selenium.support.Color;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class MainPagePriceTests extends TestBase {

    @BeforeTest
    public void startTestFromMainPage() {
        app.goTo().mainPage();
    }

    @Test(enabled = true)
    public void testCheckPriceColor() {
        Color regularPriceView = app.mainPage().getPriceColor("regular");
        Color campaignPriceView = app.mainPage().getPriceColor("campaign");

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
    public void testCheckPriceSize () {
        int regularWidth = app.mainPage().getPriceSize("regular", "width");
        int regularHeight = app.mainPage().getPriceSize("regular", "height");
        int campaignWidth = app.mainPage().getPriceSize("campaign", "width");
        int campaignHeight = app.mainPage().getPriceSize("campaign", "height");

        logger.info(String.format("Regular Price: H = %s, W = %s", regularHeight, regularWidth));
        logger.info(String.format("Campaign Price: H = %s, W = %s", campaignHeight, campaignWidth));

        assertTrue(campaignWidth > regularWidth);
        assertTrue(campaignHeight > regularHeight);
    }

    @Test(enabled = true)
    public void testCampaignPriceBold() {

        assertTrue(app.mainPage().isPriceBold("campaign"));
        assertFalse(app.mainPage().isPriceBold("regular"));

    }

    @Test(enabled = true)
    public void testRegularPriceLineThrough() {

        assertFalse(app.mainPage().isPriceLineThrough("campaign"));
        assertTrue(app.mainPage().isPriceLineThrough("regular"));

    }

}
