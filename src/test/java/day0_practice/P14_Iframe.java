package day0_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P14_Iframe extends TestBase {

    @Test
    public void test1() {

        // https://demo.guru99.com/test/guru99home/ sitesine gidin.
        driver.get("https://demo.guru99.com/test/guru99home/");

        // sayfadaki iframe sayisini bulunuz
      int toplamIframe = driver.findElements(By.tagName("iframe")).size();
        System.out.println(toplamIframe);

        // ilk iframe'deki (youtube) play butonuna tiklayin.
        WebElement frame1 = driver.findElement(By.xpath("//*[@wmode='transparent']"));
        driver.switchTo().frame(frame1);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        waitFor(3);

        // ilk iframeden cikip anasayfaya donun.
        driver.switchTo().defaultContent();
        waitFor(3);

        // ikinci iframedeki (Jmeter Mode Easy) linke (https://demo.guru99.com/live-selenium-project.html) tiklayiniz
        WebElement frame2 = driver.findElement(By.xpath("//*[@id='a077aa5e']"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        waitFor(3);
    }
}
