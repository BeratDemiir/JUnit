package day07_testbase_alerts_iframes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class C06_Iframe_InterwiewSorulari extends TestBase {

    @Test
    public void test1() {

//   ● How do you find the number of iframe on a page? Bir sayfadaki toplan iframe sayisini basil buluruz?
        // ●  Iframe ler iframe tagi kullanılarak oluşturulur. Bu durumda find elements by frame locatorini kullanarak tum iframeleri bulurum
        // ● driver.findElements(By.tagName(“iframe”));
        // ● driver.findElements(By.xpath(“//iframe”));


// ● Explain how you can switch back from a main page? Tekrar ana sayfaya nasil donersin?
        // ●  2 farkli yol vardır.
        // ●  defaultContent yada parentFrame metotlarını kullarak gecis yapabiliriz.


//● What is the difference between defaultContent and parentFrame? defaultContent ve parentFrame arasindaki farklar nelerdi?
        //  Oncelikle her ikiside framein misina cikmamizi saglar. Ama defaultContent direk ana sayfaya atlatır, parentFrame ise bir üst seviyeye atlatir


// ● What might be the reason for your test case to fail?Bir test case in fail etme sebepleri neler olabilir?
        // 1. Yanlis locator. Cozum : Tekrar elementi locate etmek. Değişken element var ise ona gore dynamic bir xpath yazarız.
        //  2. Wait / Syncronization /Bekleme problemi: Cozum : implicit wait de yeterli sure oldugundan emin oluruz. O sureyi arttırabiliriz. 30 saniye verilebilir. Explicit wait kullanilabilir(sonra gore).
        //  3. Iframe. Cozum : switch to iframe
        //   4. Alert. Cozum : switch to alert
        //   5. New window(Yeni pencere) : switch to window
    }
}
