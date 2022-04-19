package sc.stqa.pft.litecart.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sc.stqa.pft.litecart.models.Countries;
import sc.stqa.pft.litecart.models.Country;
import sc.stqa.pft.litecart.models.CountryZones;

import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;

public class CountriesTests extends TestBase {

    private Countries allCountries;

    @BeforeSuite
    public void countriesPageSetup() {
        app.goTo().adminHomePage();
        app.goTo().menu("countries");
        allCountries = app.countries().getAllCountries();
    }

    @Test(enabled = true)
    public void testCountriesListAlphabetical () {

        Countries countries = allCountries;
        Countries sortedCountries = new Countries(countries.stream().sorted((c1, c2)-> c1.getName().compareTo(c2.getName())).collect(Collectors.toSet()));
        assertEquals(countries, sortedCountries);

    }

    @Test(enabled = true)
    public void testZonesListAlphabetical() {

        Countries countriesWithZones = new Countries(allCountries.stream().filter((c) -> c.getZones() != 0).collect(Collectors.toSet()));
        for(Country country : countriesWithZones) {
            app.countries().editCountry(country);
            CountryZones zones = app.countries().getAllCountryZones();
            CountryZones sortedZones = new CountryZones(zones.stream().sorted((z1, z2)-> z1.getName().compareTo(z2.getName())).collect(Collectors.toSet()));
            assertEquals(zones, sortedZones);
            app.goTo().menu("countries");
        }

    }

}

