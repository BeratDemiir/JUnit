package day0_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class P15_WindowHandle extends TestBase {

    @Test
    public void test1() {

        //   Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");

        // Sayfanin window handle degerini String bir degiskene atayin
        String amazonWindow = driver.getWindowHandle();

        // Sayfa title'nin Amazon icerdigini test edin
        String amazonTitle = driver.getTitle();
        Assert.assertTrue(amazonTitle.contains("Amazon"));

        // Yeni bir tab olusturup, acilan tab'da techproeducation.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB); // yeni bir sekme olusturuldu
        driver.get("https://www.techproeducation.com");

        // Sayfa title'nin "TECHPROEDUCATION" icerdigini test edin
        String tehproTitle = driver.getTitle();
        Assert.assertFalse(tehproTitle.contains("TECHPROEDUCATION"));
        waitFor(5);

        // Yeni bir window olusturup acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);// Yeni bir pencere acildi
        driver.get("https://www.walmart.com/");

        // Sayfa title'nin Walmart icerdigini test edin
        String walmartTitle = driver.getTitle();
        Assert.assertTrue(walmartTitle.contains("Walmart"));

        // ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin.
        driver.switchTo().window(amazonWindow);
        String actualUrl = driver.getCurrentUrl();
        String amzUrl = "https://www.amazon.com/";
        Assert.assertEquals(amzUrl, actualUrl);
    }
}