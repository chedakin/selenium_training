package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import sc.stqa.pft.litecart.models.ProductData;
import sc.stqa.pft.litecart.models.Products;

import java.util.List;
import java.util.Properties;

public class MainPageHelper extends HelperBase {

    public MainPageHelper(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public List<WebElement> getAllProducts() {
        return driver.findElements(By.cssSelector("article.product"));
    }

    public void viewCampaignProduct() {
        click(By.cssSelector("section#box-campaign-products article.product a.link"));
    }

    public Products getCampaignProducts() {

        List<WebElement> products = driver.findElements(By.cssSelector("section#box-campaign-products article.product"));
        Products campaignProducts = new Products();

        for(WebElement product : products) {
            campaignProducts.add(new ProductData()
                    .withProductName(product.findElement(By.cssSelector("div.info h4.name")).getAttribute("textContent"))
                    .withRegularPrice(product.findElement(By.cssSelector("del.regular-price")).getAttribute("textContent"))
                    .withCampaignPrice(product.findElement(By.cssSelector("strong.campaign-price")).getAttribute("textContent"))
                    .withCompany(product.findElement(By.cssSelector("div.info div.manufacturer-name")).getAttribute("textContent")));
        }
        return campaignProducts;
    }
}
