package sc.stqa.pft.litecart.tests;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import sc.stqa.pft.litecart.models.UserData;

public class UserRegistrationTests extends TestBase {

    @BeforeSuite
    public void startFromMainPage() {
        app.goTo().mainPage();
    }

    @Test
    public void testRegisterNewUser() {

        long now = System.currentTimeMillis();
        String email = String.format("user%s@localdomain.net", now);
        String firstName = String.format("FN%s",now);
        String lastName = String.format("LN%s",now);
        UserData user = new UserData().withFirstName(firstName).withLastName(lastName)
                .withEmail(email).withCountry("United States").withState("Alabama").withPostalCode("12345")
                .withPassword("123pwd123");

        app.mainPage().registerUser(user);
        app.mainPage().logoutUser();
        app.mainPage().loginUser(user.getEmail(), user.getPassword());
        app.mainPage().logoutUser();
    }
}
