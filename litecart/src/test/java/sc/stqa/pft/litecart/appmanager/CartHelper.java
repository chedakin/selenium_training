package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Properties;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

public class CartHelper extends HelperBase {

    public CartHelper(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public void removeProductFromCart() {
        WebElement row = driver.findElement(By.cssSelector("section#box-checkout-cart li.item"));
        click(row.findElement(By.name("remove_cart_item")));
        wait.until(stalenessOf(row));

    }

    public int calculateProductsInCart() {
        int count = 0;
        List<WebElement> rows = driver.findElements(By.cssSelector("section#box-checkout-cart li.item"));

        if(rows.size() == 0) {
            count = 0;
        } else {
            for(WebElement row : rows) {
                count += Integer.parseInt(row.findElement(By.cssSelector("div.input-group input[type=number]")).getAttribute("value"));
            }
        }
        return count;
    }

    public void leaveBlankCart() {
        click(By.cssSelector("a.btn.btn-success.btn-lg"));
    }
}
