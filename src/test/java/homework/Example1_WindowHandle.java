package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class Example1_WindowHandle extends TestBase {
    @Test
    public void test1() throws InterruptedException {

        // 1) https://the-internet.herokuapp.com/iframe  sitesine gidiniz
            driver.get("https://the-internet.herokuapp.com/iframe");

        // 2) sayfadaki toplam iframe sayısını bulunuz.
     int toplamIframe = driver.findElements(By.tagName("iframe")).size();
        System.out.println(toplamIframe);

        // 3) Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
         String actualEditorText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(actualEditorText.contains("Editor"));

        // 4) Paragrafdaki yaziyi silelim

        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//p[text()='Your content goes here.']")).clear();

        waitFor(3);

        // 5) Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
       driver.findElement(By.xpath("//*[@id='tinymce']")).sendKeys("iframenin icindeyim");
        waitFor(3);

        // 6) Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim
        driver.switchTo().defaultContent();
       String text = driver.findElement(By.xpath("//a[.='Elemental Selenium']")).getText();
       Assert.assertTrue(text.contains("Elemental Selenium"));

    }
}
