package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sc.stqa.pft.litecart.models.Country;
import sc.stqa.pft.litecart.models.CountryZone;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CountriesHelper extends HelperBase{

    public CountriesHelper(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public List<Country> getAllCountries() {
        WebElement table = driver.findElement(By.cssSelector("form[name=countries_form] tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<Country> countries = new ArrayList<Country>();
/*
        for(WebElement row : rows) {
            countries.add(new Country()
                    .withName(row.findElement(By.tagName("a")).getAttribute("textContent"))
                    .withCode(row.findElement())
                    .withZones(Integer.parseInt(row.findElement(By.className("text-center")).getText())));
        }


 */
        for(WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            countries.add(new Country()
                    .withName(cells.get(4).getAttribute("textContent"))
                    .withCode(cells.get(3).getAttribute("textContent"))
                    .withZones(Integer.parseInt(cells.get(5).getAttribute("textContent"))));
        }
        return countries;
    }

    public void editCountry(Country country) {
        click(By.linkText(country.getName()));
    }

    public List<CountryZone> getAllCountryZones(){
        List<CountryZone> zones = new ArrayList<CountryZone>();
        WebElement table = driver.findElement(By.tagName("tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for(WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            zones.add(new CountryZone()
                    .withName(cells.get(2).findElement(By.tagName("input")).getAttribute("value"))
                    .withCode(cells.get(1).findElement(By.tagName("input")).getAttribute("value")));
        }
        return zones;
     }

}
