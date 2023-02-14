package DZ6;

import org.example.DZ6.AccountPage;
import org.example.DZ6.LoginPage;
import org.example.DZ6.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest extends AbstractTest {

    @Test
    void loginIn(){
        new MainPage(getDriver()).goToAccountPage();
        Assertions.assertTrue(getDriver().getTitle().equals("livejournal – Sign in"), "страница входа недоступна");
        new LoginPage(getDriver())
                .setLogin("tamasya17@rambler.ru")
                .setPassword("335577Roman")
                .loginIn();
        Assertions.assertTrue(getDriver().findElement(By.id("id-username")).getText().equals("Your account"));

    }

    @Test
    void loginInSecond(){
        new MainPage(getDriver()).goToAccountPage();
        Assertions.assertTrue(getDriver().getTitle().equals("livejournal – Sign in"), "страница входа недоступна");
        new LoginPage(getDriver())
                .loginIn("tamasya17@rambler.ru","335577Roman");
        Assertions.assertTrue(getDriver().findElement(By.id("id-username")).getText().equals("Your account"));
    }



    @AfterEach
    void logout(){
        new MainPage(getDriver()).goToAccountPage();
        Assertions.assertTrue(getDriver().getTitle().equals("livejournal – account overview"), "страница аккаунта не доступна");
        new AccountPage(getDriver()).logOut();
        new WebDriverWait(getDriver(),Duration.ofSeconds(5));
        Assertions.assertTrue(getDriver().findElement(By.id("id-username")).getText().equals("Sign in"));
    }



}