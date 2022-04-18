package sc.stqa.pft.litecart.tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TemporaryTests extends TestBase{

    @Test
    public void testTemporary() {

        app.goTo().adminHomePage();
        app.goTo().menu("countries");




    }

}
