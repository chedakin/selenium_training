package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver, Properties properties) {
        super(driver, properties);
    }
/*
    public void homePage() {
        if (isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("home"));
    }

 */
    public void adminHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));;

        navigateLink("admin");
        wait.until(titleIs("My Store"));
        type(By.name("username"), properties.getProperty("web.adminLogin"));
        type(By.name("password"), properties.getProperty("web.adminPassword"));
        click(By.xpath("//button[@name='login']"));
        wait.until(titleIs("Dashboard | My Store"));
        click(By.xpath("//ul[@id='box-apps-menu']/li/a/span[2]"));
        //navigateLink("admin/?app=appearance&doc=template");
        wait.until(titleIs("Template | My Store"));
    }

    public String whereAmI(){
        return driver.getTitle();
    }
}
