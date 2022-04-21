package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import sc.stqa.pft.litecart.models.ProductData;
import sc.stqa.pft.litecart.models.Products;
import sc.stqa.pft.litecart.models.UserData;

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

    public void loginUser(String email, String password) {
        click(By.cssSelector("div#default-menu li[class='account dropdown'] a.dropdown-toggle"));
        type(By.cssSelector("form[name=login_form] input[type=email]"), email);
        type(By.cssSelector("form[name=login_form] input[type=password]"), password);
        click(By.cssSelector("form[name=login_form] button[type=submit]"));
    }

    public void logoutUser () {
        click(By.cssSelector("div#default-menu li[class='account dropdown'] a.dropdown-toggle"));
        click(By.linkText("Logout"));
    }

    public void registerUser(UserData user) {
        click(By.cssSelector("div#default-menu li[class='account dropdown'] a.dropdown-toggle"));
        click(By.linkText("New customers click here"));

        acceptCookies();

        WebElement creteAccount = driver.findElement(By.cssSelector("section#box-create-account"));

        type(creteAccount.findElement(By.name("firstname")), user.getFirstName());
        type(creteAccount.findElement(By.name("lastname")), user.getLastName());
        type(creteAccount.findElement(By.name("postcode")), user.getPostalCode());

        Select country = new Select(creteAccount.findElement(By.name("country_code")));
        country.selectByVisibleText(user.getCountry());
        Select state = new Select(creteAccount.findElement(By.name("zone_code")));
        state.selectByVisibleText(user.getState());

        type(creteAccount.findElement(By.name("email")), user.getEmail());
        type(creteAccount.findElement(By.name("password")), user.getPassword());
        type(creteAccount.findElement(By.name("confirmed_password")), user.getPassword());

        click(creteAccount.findElement(By.name("terms_agreed")));
        click(creteAccount.findElement(By.name("create_account")));

    }



}
