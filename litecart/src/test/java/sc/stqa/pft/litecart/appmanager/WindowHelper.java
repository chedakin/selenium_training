package sc.stqa.pft.litecart.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Properties;
import java.util.Set;

public class WindowHelper extends HelperBase {

    public WindowHelper(WebDriver driver, Properties properties) {
        super(driver, properties);
    }

    public void close() {
        driver.close();
    }

    public void switchTo(String window) {
        driver.switchTo().window(window);
    }

    public String getCurrentWindow() {
        return driver.getWindowHandle();
    }

    public Set<String> getAllWindows () {
        return driver.getWindowHandles();
    }

    public ExpectedCondition<String> AnyWindowOtherThen(Set<String> windows) {
        return new ExpectedCondition<String>() {
            @Override
            public String apply(WebDriver input) {
                Set<String> windowsNow = input.getWindowHandles();
                windowsNow.removeAll(windows);
                return windowsNow.size()>0 ? windowsNow.iterator().next() : null;
            }
        };
    }

    public String waitForAnyWindowOtherThen(Set<String> windows) {
        return wait.until(AnyWindowOtherThen(windows));
    }

}
