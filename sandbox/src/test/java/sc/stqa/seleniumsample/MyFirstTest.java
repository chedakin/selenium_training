package sc.stqa.seleniumsample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void start() {
        //don't need anymore since added into %PATH%
        //System.setProperty("webdriver.gecko.driver","C:\\JavaTmp\\geckodriver.exe");
        //System.setProperty("webdriver.chrome.driver","C:\\JavaTmp\\chromedriver.exe");
        //System.setProperty("webdriver.edge.driver","C:\\JavaTmp\\msedgedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void myFirstTest() {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnG")).click();
        wait.until(titleIs("webdriver - Поиск в Google"));
    }

    @AfterTest
    public void stop() {
        driver.quit();
        driver = null;
    }


}
