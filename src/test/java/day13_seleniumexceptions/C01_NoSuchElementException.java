package day13_seleniumexceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {

    /*
                 NoSuchElementException:
    Yanlis locator
    Popup, yeni pencere, iframe,…
    Sayfa dolmada problemler ve yavaslamalar
    Sakli olan elementler

Solution: COZUM
    Locatorin dogrulugunu tekrar kontrol et
    Manual test ile iframe, yeni pencere, alert,… gibi elementlerin varligini kontrol et.
    Bekleme problemi o

         */
    @Test
    public void NoSuchTest() {

       // https://www.techproeducation.com adresine gidelim
       driver.get("https://www.techproeducation.com");
       driver.findElement(By.xpath("//input[@type=' textt']"))// org.openqa.selenium.NoSuchElementException
               .sendKeys("QA"+ Keys.ENTER);
    }
}
