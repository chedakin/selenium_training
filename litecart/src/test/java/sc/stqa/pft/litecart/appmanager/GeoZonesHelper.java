package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sc.stqa.pft.litecart.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class GeoZonesHelper extends HelperBase {

    public GeoZonesHelper(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public GeoZones getAllGeoZones() {
        GeoZones geoZones = new GeoZones();
        WebElement table = driver.findElement(By.tagName("tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for(WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            geoZones.add(new GeoZoneData()
                    .withName(cells.get(2).findElement(By.tagName("a")).getAttribute("textContent"))
                    .withZones(Integer.parseInt(cells.get(3).getAttribute("textContent"))));
        }
        return geoZones;
    }

    public void editGeoZone(GeoZoneData geoZone) {
        click(By.linkText(geoZone.getName()));
    }

    public List<String> getCountriesForZone(){
        List<String> countries = new ArrayList<String>();
        WebElement table = driver.findElement(By.tagName("tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for(WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            countries.add(cells.get(1).getAttribute("textContent"));
        }
        return countries;
    }
}
