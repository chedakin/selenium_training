package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sc.stqa.pft.litecart.models.Countries;
import sc.stqa.pft.litecart.models.CountryData;
import sc.stqa.pft.litecart.models.CountryZoneData;
import sc.stqa.pft.litecart.models.CountryZones;

import java.util.List;
import java.util.Properties;

public class CountriesHelper extends HelperBase{

    public CountriesHelper(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public void editCountry(CountryData country) {
        click(By.linkText(country.getName()));
    }

    public CountryZones getAllCountryZones(){
        CountryZones zones = new CountryZones();
        WebElement table = driver.findElement(By.tagName("tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for(WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            zones.add(new CountryZoneData()
                    .withName(cells.get(2).findElement(By.tagName("input")).getAttribute("value"))
                    .withCode(cells.get(1).findElement(By.tagName("input")).getAttribute("value")));
        }
        return zones;
     }

    public Countries getAllCountries() {
        WebElement table = driver.findElement(By.cssSelector("form[name=countries_form] tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        Countries countries = new Countries();

        for(WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            countries.add(new CountryData()
                    .withName(cells.get(4).getAttribute("textContent"))
                    .withCode(cells.get(3).getAttribute("textContent"))
                    .withZones(Integer.parseInt(cells.get(5).getAttribute("textContent"))));
        }
        return countries;
    }

    public void openExternalLink (String label) {
        List<WebElement> allLabels = driver.findElements(By.tagName("label"));
        for(WebElement linkLabel : allLabels) {
            if(linkLabel.getAttribute("textContent").equals(label)){
                click(linkLabel.findElement(By.cssSelector("a[href*=http]")));
                break;
            }
        }
    }

}
