package sc.stqa.pft.litecart.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sc.stqa.pft.litecart.models.GeoZoneData;
import sc.stqa.pft.litecart.models.GeoZones;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class GeoZonesTests extends TestBase {

    private GeoZones allGeoZones;

    @BeforeSuite
    public void geoZonesPageSetup() {
        app.goTo().adminHomePage();
        app.goTo().menu("geo_zones");
        allGeoZones = app.geoZone().getAllGeoZones();
    }

    @Test
    public void testZonesListAlphabetical(){
        if(allGeoZones.size() == 0) {
            logger.info("No Geo Zones detected");
            return;
        }

        for(GeoZoneData geoZone : allGeoZones) {
            app.goTo().menu("geo_zones");
            app.geoZone().editGeoZone(geoZone);
            List<String> countries = app.geoZone().getCountriesForZone();
            List<String> sortedCountries = countries.stream().sorted().toList();
            assertEquals(countries, sortedCountries);
        }
    }
}
