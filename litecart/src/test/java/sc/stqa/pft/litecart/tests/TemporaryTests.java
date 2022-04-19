package sc.stqa.pft.litecart.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import sc.stqa.pft.litecart.models.Country;
import sc.stqa.pft.litecart.models.CountryZone;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class TemporaryTests extends TestBase{

    @Test
    public void testTemporary() {

        app.goTo().adminHomePage();
        app.goTo().menu("countries");

        Country country = new Country().withName("Australia").withCode("AU").withZones(8);

        app.countries().editCountry(country);

        System.out.println(country);

        List<CountryZone> zones = app.countries().getAllCountryZones();

        System.out.println(zones);




    }

}
