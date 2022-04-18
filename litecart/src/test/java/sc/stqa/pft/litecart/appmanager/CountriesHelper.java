package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sc.stqa.pft.litecart.models.Country;

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

        for(WebElement row : rows) {
            countries.add(new Country()
                    .withName(row.findElement(By.tagName("a")).getAttribute("textContent"))
                    .withZones(Integer.parseInt(row.findElement(By.className("text-center")).getText())));
        }
        return countries;

    }

}
