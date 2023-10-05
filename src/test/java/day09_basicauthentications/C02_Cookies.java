package day09_basicauthentications;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C02_Cookies extends TestBase {

    @Test
    public void cookiesTest() {

        //    Amazona git
        driver.get("https://www.amazon.com");

        //    toplam cookie sayisini bul
        Set<Cookie> allCookies = driver.manage().getCookies();// Toplam cookies(cerez) sayisini verir.
        int cookieSayisi = allCookies.size();
        System.out.println("Sayfada " + cookieSayisi + " adet cookie var");

        //    Bir Cookie yi ismiyle bul
                 // Tum cerezleri  yazdiralim.
        //     allCookies.stream().forEach(t -> System.out.println(t.getName())); // Lamda ile
        for (Cookie eachCookies : allCookies){
            System.out.println(eachCookies); // Cookie nin tamamini yaz.
            System.out.println(eachCookies.getName());
        }
        System.out.println(driver.manage().getCookieNamed("i18n-prefs"));// sadece girilen cookie'yi al.

        //    Yeni bir cookie ekle
        Cookie favoriCookiem= new Cookie("Cikolatam","antep-fistikli-cikolata");
        driver.manage().addCookie(favoriCookiem);
        System.out.println("Yeni Cookie sayisi: " + driver.manage().getCookies().size()); // 8

        //    Bir Cookie yi ismiyle sil
        driver.manage().deleteCookieNamed("Cikolatam");
        System.out.println("Yeni Cookie sayisi: " + driver.manage().getCookies().size());// 7

        //    Tum cookie leri sil
        driver.manage().deleteAllCookies();
        System.out.println("Yeni Cookie sayisi: " + driver.manage().getCookies().size());// 0
    }
}
