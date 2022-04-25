package sc.stqa.pft.litecart.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import sc.stqa.pft.litecart.models.CountryData;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AdminCountriesExternalLinksTests extends TestBase {

    @BeforeSuite
    private void startFromAdminPage() {
        app.goTo().adminHomePage();
    }

    @DataProvider
    public Iterator<Object[]> listOfLabelsWithExternalLinks() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new String[] {"Number (ISO 3166-1 numeric) "});
        list.add(new String[] {"Code (ISO 3166-1 alpha-2) "});
        list.add(new String[] {"Code (ISO 3166-1 alpha-3) "});
        list.add(new String[] {"Address Format (?) "});
        list.add(new String[] {"Tax ID Format "});
        list.add(new String[] {"Postcode Format "});
        list.add(new String[] {"Language Code "});
        list.add(new String[] {"Currency Code "});
        list.add(new String[] {"Phone Country Code "});
        return list.iterator();
    }


    @Test(dataProvider = "listOfLabelsWithExternalLinks")
    private void testExternalLinksInCountryEditPage(String linkLabel) {
        logger.info(String.format("Start test for label: %s", linkLabel));
        app.goTo().menu("countries");
        CountryData country = new CountryData().withName("Argentina");
        app.countries().editCountry(country);
        String mainWindow = app.window().getCurrentWindow();
        Set<String> oldWindows = app.window().getAllWindows();
        app.countries().openExternalLink(linkLabel);
        String newWindow = app.window().waitForAnyWindowOtherThen(oldWindows);
        app.window().switchTo(newWindow);
        app.window().close();
        app.window().switchTo(mainWindow);

    }
}
