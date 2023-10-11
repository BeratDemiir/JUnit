package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Iframe extends TestBase {

    @Test
    public void test1() {

        //  https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");

        //  video’yu gorecek kadar asagi inin
        new Actions(driver).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        waitFor(3);

        //  videoyu izlemek icin Play tusuna basin
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']")).click();

        //  videoyu calistirdiginizi test edin
        WebElement youtubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazisi.isDisplayed());

        // "Poweful,but easy to misuse" yazisinin gorunur oldugunu test ediniz.
        driver.switchTo().defaultContent();
        WebElement powefullYazisi = driver.findElement(By.id("Powerful_but_easy_to_misuse"));
        Assert.assertTrue(powefullYazisi.isDisplayed());
    }
}
