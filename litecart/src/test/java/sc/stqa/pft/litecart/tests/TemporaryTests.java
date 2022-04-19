package sc.stqa.pft.litecart.tests;

import org.testng.annotations.Test;
import sc.stqa.pft.litecart.models.Country;
import sc.stqa.pft.litecart.models.CountryZones;
import sc.stqa.pft.litecart.models.GeoZones;

import java.util.stream.Collectors;


public class TemporaryTests extends TestBase{

    @Test
    public void testTemporary() {

        app.goTo().adminHomePage();
        app.goTo().menu("geo_zones");

        GeoZones geoZones = app.geoZone().getAllGeoZones();

        System.out.println(geoZones);




    }

}
