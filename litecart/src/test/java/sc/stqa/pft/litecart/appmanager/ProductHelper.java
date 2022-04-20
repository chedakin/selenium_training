package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
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

    public int getPriceSize(String priceType, String dimension ) {

        WebElement price;
        if(priceType.equals("regular")) {
            price = driver.findElement(By.cssSelector("article#box-product del.regular-price"));

        } else if (priceType.equals("campaign")) {
            price = driver.findElement(By.cssSelector("article#box-product strong.campaign-price"));

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
            price = driver.findElement(By.cssSelector("article#box-product del.regular-price"));
            return Color.fromString(price.getCssValue("color"));

        } else if (priceType.equals("campaign")) {
            price = driver.findElement(By.cssSelector("article#box-product strong.campaign-price"));
            return Color.fromString(price.getCssValue("color"));

        } else {
            return null;
        }
    }

    public boolean isPriceBold(String priceType) {
        WebElement price;
        if(priceType.equals("regular")) {
            price = driver.findElement(By.cssSelector("article#box-product .regular-price"));

        } else if (priceType.equals("campaign")) {
            price = driver.findElement(By.cssSelector("article#box-product .campaign-price"));
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
            price = driver.findElement(By.cssSelector("article#box-product .regular-price"));

        } else if (priceType.equals("campaign")) {
            price = driver.findElement(By.cssSelector("article#box-product .campaign-price"));
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
