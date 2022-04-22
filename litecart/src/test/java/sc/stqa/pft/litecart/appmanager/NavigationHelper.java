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

    public void adminHomePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));;

        navigateLink("admin");
        wait.until(titleIs("My Store"));
        type(By.name("username"), properties.getProperty("web.adminLogin"));
        type(By.name("password"), properties.getProperty("web.adminPassword"));
        click(By.xpath("//button[@name='login']"));
        wait.until(titleIs("Dashboard | My Store"));
    }

    public void menu(String title){
        click(By.cssSelector(String.format("ul#box-apps-menu li[data-code = %s] a span.name",title)));
        //click(By.xpath("//ul[@id='box-apps-menu']/li[@data-code='appearance']/a/span[@class='name']"));
    }

    public void subMenu(String title, String subTitle) {
        click(By.cssSelector(String.format("ul#box-apps-menu li[data-code = %s] li[data-code = %s]",title, subTitle)));
    }

    public void dashboard(){
        click(By.id("logotype"));
    }

    public void mainPage() {
        click(By.cssSelector("#header .logotype"));
    }

    public void cart() {
        click(By.cssSelector("div#cart"));
    }

    public String whereAmI(){
        return driver.getTitle();
    }

    public String getPageHeader() {
        return driver.findElement(By.cssSelector("div.panel-heading")).getText();
    }



}
