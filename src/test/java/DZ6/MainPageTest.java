package DZ6;


import org.example.DZ6.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainPageTest extends AbstractTest {


    @Test
    void clickToMedia(){
        new MainPage(getDriver()).navigateToMedia();
        Assertions.assertEquals("https://www.livejournal.com/media",getDriver().getCurrentUrl());
    }

    @Test
    void clickToCard(){
        new MainPage(getDriver()).navigateToCard();

    }

    @Test
    void clickToCard2(){
        new MainPage(getDriver()).navigateToCard2();
    }


}
