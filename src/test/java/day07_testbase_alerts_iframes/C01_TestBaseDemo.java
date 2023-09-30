package day07_testbase_alerts_iframes;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {

    /*
                     UTILITIES:
         # Utilities tekrar tekrar kullanacagimiz class'lari koydugumuz paketin adidir.
           -) TestBase -> Bugun
           -) Driver -> Sonra
           -) ExcelUtil -> Sonra
           -) Configuration -> Sonra
         # Utilities paketinde Test case ler yazilmaz
         # Sadece tekrar kullanilabilecek desdek siniflari(support class) olusturulur
         # Bu support classlar test caselerin yazilmasini hizlandirir.
     */

    @Test
    public void test1() {
        //  techproeducation ana sayfasina git
        driver.get("https://www.techproeducation.com");

        //  ve titlein Programs kelimesini icerdigini test edelim
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("Programs"));

    }
}
