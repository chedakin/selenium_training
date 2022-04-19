package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sc.stqa.pft.litecart.models.ProductData;

import java.util.Properties;

public class ProductHelper extends HelperBase{

    public ProductHelper(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public ProductData getProductData() {
        return new ProductData()
                .withProductName(driver.findElement(By.cssSelector("article#box-product h1.title")).getAttribute("textContent"))
                .withRegularPrice(driver.findElement(By.cssSelector("article#box-product del.regular-price")).getAttribute("textContent"))
                .withCampaignPrice(driver.findElement(By.cssSelector("article#box-product strong.campaign-price")).getAttribute("textContent"))
                .withCompany(driver.findElement(By.cssSelector("article#box-product div.manufacturer img")).getAttribute("title"));
    }

}
