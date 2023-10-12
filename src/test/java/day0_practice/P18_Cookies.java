package day0_practice;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.HashSet;
import java.util.Set;

public class P18_Cookies extends TestBase {

    @Test
    public void test1() {

        // https://techproeducation.com/ adresine gidin
        driver.get("https://techproeducation.com");

        // sayfadaki cookie lerin sayisini yazdirin
        Set<Cookie> allCookies = driver.manage().getCookies();
        int cookieSaysi = allCookies.size();
        System.out.println("Sayfada "+cookieSaysi+" tane cookie var");

        // sayfadaki cookie lerin isim ve degerlerini yazdirin
        // yeni bir cookie ekleyin
        // yeni cookie ekledikten sonra cookie saysisini ve isimlerini yazdirin
        // olusturdugumuz cookie i silelim
        // Tum cookieleri  silelim

    }
}
