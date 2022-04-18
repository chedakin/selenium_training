package sc.stqa.pft.litecart.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sc.stqa.pft.litecart.models.Country;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CountriesTests extends TestBase {
    @BeforeSuite
    public void adminAccount() {
        app.goTo().adminHomePage();
        app.goTo().menu("countries");
    }

    @Test
    public void testCountriesListAlphabetical () {
        List<Country> countries = app.countries().getAllCountries();
        List<Country> sortedCountries = countries.stream().sorted((c1,c2)-> c1.getName().compareTo(c2.getName())).toList();

        assertEquals(countries, sortedCountries);

    }

}

