package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;

public class MainPageHelper extends HelperBase {

    public MainPageHelper(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(By.cssSelector("article.product"));
    }
}
