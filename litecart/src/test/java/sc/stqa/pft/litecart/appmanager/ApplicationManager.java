package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Objects;
import java.util.Properties;
import static org.testng.Assert.fail;

public class ApplicationManager {

    private final Properties properties;
    public WebDriver driver;

    private NavigationHelper navigationHelper;
    private MainPageHelper mainPageHelper;
    private CountriesHelper countriesHelper;
    private GeoZonesHelper geoZonesHelper;
    private ProductHelper productHelper;
    private CatalogHelper catalogHelper;
    private CartHelper cartHelper;

    public StringBuffer verificationErrors = new StringBuffer();
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }



    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if (Objects.equals(browser, Browser.FIREFOX.browserName())) {
            driver = new FirefoxDriver();
        } else if (Objects.equals(browser, Browser.CHROME.browserName())) {
            driver = new ChromeDriver();
        } else if (Objects.equals(browser, Browser.EDGE.browserName())) {
            driver = new EdgeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("web.baseUrl"));

        navigationHelper = new NavigationHelper(driver, properties);
        mainPageHelper = new MainPageHelper(driver,properties);
        countriesHelper = new CountriesHelper(driver, properties);
        geoZonesHelper = new GeoZonesHelper(driver, properties);
        productHelper = new ProductHelper(driver, properties);
        catalogHelper = new CatalogHelper(driver, properties);
        cartHelper = new CartHelper(driver,properties);

    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public MainPageHelper mainPage() {
        return mainPageHelper;
    }

    public CountriesHelper countries() {
        return countriesHelper;
    }

    public  GeoZonesHelper geoZone() {
        return geoZonesHelper;
    }

    public  ProductHelper product() {
        return productHelper;
    }

    public  CatalogHelper catalog() {
        return catalogHelper;
    }

    public CartHelper cart() {
        return cartHelper;
    }
}

