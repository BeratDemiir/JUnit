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
        System.out.println("Sayfada " + cookieSaysi + " tane cookie var");

        // sayfadaki cookie lerin isim ve degerlerini yazdirin
        for (Cookie c : allCookies) {
            System.out.println(c.getName() + " " + c.getValue());
        }

        // yeni bir cookie ekleyin
        Cookie myCookie = new Cookie("mtCookie", "123456789");
        driver.manage().addCookie(myCookie);

        // yeni cookie ekledikten sonra cookie saysisini ve isimlerini yazdirin
        Set<Cookie> allCookies2 = driver.manage().getCookies();
        int cookieSayisi = allCookies2.size();
        System.out.println("Sayfada " + cookieSayisi + " tane cookie var");

        for (Cookie c : allCookies2) {
            System.out.println(c.getName() + " " + c.getValue());
        }

        // olusturdugumuz cookie i silelim
        driver.manage().deleteCookie(myCookie);

        // Tum cookieleri  silelim
        driver.manage().deleteAllCookies();
        Set<Cookie> allCookies3 = driver.manage().getCookies();
        System.out.println(allCookies3.size());
    }
}
