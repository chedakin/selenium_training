package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.Properties;

public class HelperBase {

    public boolean acceptNextAlert = true;
    protected WebDriver driver;
    protected Properties properties;
    protected WebDriverWait wait;

    public HelperBase(WebDriver driver, Properties properties) {
        this.driver = driver;
        this.properties = properties;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null){
            String existingText = driver.findElement(locator).getAttribute("value");
            if (! text.equals(existingText)) {
                driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    protected void type(WebElement element, String text) {
        element.click();
        if (text != null){
            String existingText = element.getAttribute("value");
            if (! text.equals(existingText)) {
                element.clear();
                element.sendKeys(text);
            }
        }
    }

    protected void attach(By locator, File file) {
        if (file != null){
            driver.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }

    protected void attach(WebElement element, File file) {
        if (file != null){
            element.sendKeys(file.getAbsolutePath());
        }
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void click(WebElement element) {
        element.click();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void navigateLink(String url){
        driver.get(String.format("%s%s", properties.getProperty("web.baseUrl"), url));
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void acceptCookies() {
        if(isElementPresent(By.name("accept_cookies"))) {
            click(By.name("accept_cookies"));
        }
    }
}