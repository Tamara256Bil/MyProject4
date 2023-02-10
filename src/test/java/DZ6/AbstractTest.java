package DZ6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

    private static WebDriver driver = new ChromeDriver();



    @BeforeEach
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.livejournal.com");
    }

    @BeforeEach
    void goTo(){

        WebDriver driver = new ChromeDriver();
        Assertions.assertDoesNotThrow( ()-> driver.navigate().to("https://www.livejournal.com"),
                "Страница не доступна");
    }



    @AfterAll
    static void close(){
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;}

}

