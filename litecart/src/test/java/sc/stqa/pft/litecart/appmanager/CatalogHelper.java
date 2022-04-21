package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import sc.stqa.pft.litecart.models.ProductData;

import java.util.Properties;

public class CatalogHelper extends HelperBase {

    public CatalogHelper(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public void openAddingProductForm() {
        click(By.linkText("Add New Product"));
    }

    public void openTab(String tabName) {
        WebElement navPanel = driver.findElement(By.cssSelector("ul[class='nav nav-tabs']"));
        click(navPanel.findElement(By.linkText(tabName)));
    }

    public void addNewProduct(ProductData product) {
        openAddingProductForm();
// tab General
        openTab("General");
        WebElement tabGeneral = driver.findElement(By.cssSelector("div#tab-general"));
        //Status
        WebElement status = tabGeneral.findElement(By.cssSelector("input[name=status][value = '1']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click(); arguments[0].dispatchEvent(new Event('change'))", status);
        //Categories
        click(tabGeneral.findElement(By.cssSelector("input[type=search]")));
        WebElement category = tabGeneral.findElement(By.cssSelector
                (String.format("ul.dropdown-menu li[data-name='%s']", product.getCategory())));
        click(category.findElement(By.cssSelector("button")));
        //Dates
        type(tabGeneral.findElement(By.name("date_valid_from")),product.getValidFrom());
        type(tabGeneral.findElement(By.name("date_valid_to")),product.getValidTo());
        //text fields
        type(tabGeneral.findElement(By.name("name[en]")),product.getProductName());
        type(tabGeneral.findElement(By.name("code")),product.getCode());
        type(tabGeneral.findElement(By.name("sku")),product.getSku());
        //brand
        Select brand = new Select(tabGeneral.findElement(By.name("manufacturer_id")));
        brand.selectByVisibleText(product.getCompany());
        //keywords
        type(tabGeneral.findElement(By.name("keywords")),product.getKeywords());
        //attach file
        attach(tabGeneral.findElement(By.name("new_images[]")),product.getPhoto());

        System.out.println("1");

// tab Information
        openTab("Information");
        WebElement tabInformation = driver.findElement(By.cssSelector("div#tab-information"));
        //Short Description
        type(tabInformation.findElement(By.name("short_description[en]")),product.getShortDescription());
        //Description
        type(tabInformation.findElement(By.cssSelector("div[dir=ltr]")),product.getDescription());
        //Technical Data
        type(tabInformation.findElement(By.name("technical_data[en]")),"25x25x25");

// tab Prices
        openTab("Prices");
        WebElement tabPrices = driver.findElement(By.cssSelector("div#tab-prices"));
        type(tabPrices.findElement(By.name("purchase_price")),product.getRegularPrice());
        Select currency = new Select(tabPrices.findElement(By.name("purchase_price_currency_code")));
        currency.selectByVisibleText("US Dollars");
        type(tabPrices.findElement(By.name("recommended_price")),product.getRegularPrice());
        Select taxes = new Select(tabPrices.findElement(By.name("tax_class_id")));
        taxes.selectByVisibleText("Standard");
        type(tabPrices.findElement(By.name("prices[USD]")),product.getRegularPrice());

// Save
        click(By.cssSelector("button[type=submit]"));
    }

    public boolean productPresents(ProductData product) {
        click(By.linkText(product.getCategory()));
        return isElementPresent(By.linkText(product.getProductName()));
    }
}
