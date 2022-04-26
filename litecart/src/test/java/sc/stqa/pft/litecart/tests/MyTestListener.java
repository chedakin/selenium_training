package sc.stqa.pft.litecart.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestListener implements WebDriverListener {
    Logger logger = LoggerFactory.getLogger(MyTestListener.class);

/*
    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        logger.info(String.format("find element by: %s", locator));
    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        logger.info(String.format("Element by %s found", locator));
    }
*/
    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        logger.error(String.valueOf(e));
    }

}
