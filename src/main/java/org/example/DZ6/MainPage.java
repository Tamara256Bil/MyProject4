package org.example.DZ6;

import org.example.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbstractPage {


    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/div[4]/div[1]/div[1]/div/div/ul/li[2]/a")
    private WebElement media;

    @FindBy(xpath = "//*[@id=\"js\"]/body/div[2]/div[4]/div[1]/section[1]/div/div[1]/div[1]/div[1]/div[1]/div/article/a")
    private WebElement card;

    @FindBy(id = "image_smapse_42043")
    private WebElement card2;


    @FindBy(id = "id-username")
    private WebElement signIn;

    public MainPage(WebDriver driver){
        super(driver);

    }

    public void goToAccountPage(){
        signIn.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("account.livejournal.com/"));

    }

    public void navigateToMedia(){
        this.media.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("media"));
    }

    public void navigateToCard(){
        this.card.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("card"));
    }

    public void navigateToCard2(){
        this.card2.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("card2"));
    }


}
