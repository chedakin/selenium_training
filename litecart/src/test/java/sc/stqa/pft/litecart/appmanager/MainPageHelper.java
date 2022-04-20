package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
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

    public int getPriceSize(String priceType, String dimension ) {

        WebElement price;
        if(priceType.equals("regular")) {
            price = driver.findElement(By.cssSelector("section#box-campaign-products article.product del.regular-price"));

        } else if (priceType.equals("campaign")) {
            price = driver.findElement(By.cssSelector("section#box-campaign-products article.product strong.campaign-price"));

        } else {
            return -1;
        }

        if(dimension.equals("width")){
            return Integer.parseInt(price.getAttribute("offsetWidth"));
        } else if (dimension.equals("height")) {
            return Integer.parseInt(price.getAttribute("offsetHeight"));
        } else {
            return -1;
        }
    }

    public Color getPriceColor(String priceType ) {

        WebElement price;
        if(priceType.equals("regular")) {
            price = driver.findElement(By.cssSelector("section#box-campaign-products article.product del.regular-price"));
            return Color.fromString(price.getCssValue("color"));

        } else if (priceType.equals("campaign")) {
            price = driver.findElement(By.cssSelector("section#box-campaign-products article.product strong.campaign-price"));
            return Color.fromString(price.getCssValue("color"));

        } else {
            return null;
        }
    }

    public boolean isPriceBold(String priceType) {
        WebElement price;
        if(priceType.equals("regular")) {
            price = driver.findElement(By.cssSelector("section#box-campaign-products article.product .regular-price"));

        } else if (priceType.equals("campaign")) {
            price = driver.findElement(By.cssSelector("section#box-campaign-products article.product .campaign-price"));
        } else {
            return false;
        }

        if(price.getTagName().equals("strong")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPriceLineThrough(String priceType) {
        WebElement price;
        if(priceType.equals("regular")) {
            price = driver.findElement(By.cssSelector("section#box-campaign-products article.product .regular-price"));

        } else if (priceType.equals("campaign")) {
            price = driver.findElement(By.cssSelector("section#box-campaign-products article.product .campaign-price"));
        } else {
            return false;
        }

        if(price.getTagName().equals("del")) {
            return true;
        } else {
            return false;
        }
    }

}
