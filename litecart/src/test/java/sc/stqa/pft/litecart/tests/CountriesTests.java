package sc.stqa.pft.litecart.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sc.stqa.pft.litecart.models.Country;
import sc.stqa.pft.litecart.models.CountryZone;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CountriesTests extends TestBase {

    private List<Country> allCountries;

    @BeforeSuite
    public void adminAccount() {
        app.goTo().adminHomePage();
        app.goTo().menu("countries");
        allCountries = app.countries().getAllCountries();
    }

    @Test(enabled = true)
    public void testCountriesListAlphabetical () {

        List<Country> countries = allCountries;
        List<Country> sortedCountries = countries.stream().sorted((c1,c2)-> c1.getName().compareTo(c2.getName())).toList();
        assertEquals(countries, sortedCountries);

    }

    @Test(enabled = true)
    public void testZonesListAlphabetical() {

        List<Country> countriesWithZones = allCountries.stream().filter((c) -> c.getZones() != 0).toList();
        for(Country country : countriesWithZones) {
            app.countries().editCountry(country);
            List<CountryZone> zones = app.countries().getAllCountryZones();
            List<CountryZone> sortedZones = zones.stream().sorted((z1,z2)-> z1.getName().compareTo(z2.getName())).toList();
            assertEquals(zones, sortedZones);
            app.goTo().menu("countries");
        }

    }

}

