package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class GenelTekrar extends TestBase {

    //  Test01 :
    //1- amazon gidin
    // 2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
    // 3. dropdown menude 40 eleman olduğunu doğrulayın
    // Test02
    // 1. dropdown menuden elektronik bölümü seçin
    // 2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
    // 3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
    // 4. ikinci ürüne relative locater kullanarak tıklayin
    // 5. ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
    // Test03
    // 1. yeni bir sekme açarak amazon anasayfaya gidin
    // 2. dropdown’dan bebek bölümüne secin
    // 3. bebek puset aratıp bulundan sonuç sayısını yazdırın
    // 4. sonuç yazsının puset içerdiğini test edin
    // 5-üçüncü ürüne relative locater kullanarak tıklayin
    // 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
    //Test 4
    // 1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    @Test
    public void test1() {
// TEST01:
        // 1- amazon gidin
        driver.get("https://www.amazon.com");

        // 2. Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement dropDown = driver.findElement(By.xpath("//select[@tabindex='0']"));
        Select select = new Select(dropDown);
        List<WebElement> tumList = select.getOptions();
        int sayac = 1;
        for (WebElement each : tumList) {
            System.out.println(sayac + "." + each.getText());
            sayac++;
        }
        // 3. dropdown menude 28 eleman olduğunu doğrulayın
        int eleman = 28;
        int tumElaman = tumList.size();
        Assert.assertEquals(eleman, tumElaman);

// TEST02:
        // 1. dropdown menuden elektronik bölümü seçin
        driver.findElement(By.xpath("//option[.='Electronics']")).click();

        // 2. arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone" + Keys.ENTER);

        // 3. sonuc sayisi bildiren yazinin iphone icerdigini test edin
        String sonucSaysi = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        String sonucYazisi = "iphone";
        Assert.assertTrue(sonucSaysi.contains(sonucYazisi));

        // 4. ikinci ürüne relative locater kullanarak tıklayin
        WebElement ilkUrun = driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]"));
        WebElement ikinciUrun = driver.findElement(with(By.xpath("(//div[@class='a-section a-spacing-base'])[2]")).toRightOf(ilkUrun));
        ikinciUrun.click();

        // 5. ürünün title'ni ve fiyatını variable’a  assign edip ürünü sepete ekleyelim
        String urunTitle = driver.getTitle();
        String urunFiyat = driver.findElement(By.xpath("(//span[@class='a-offscreen'])[1]")).getText();

        WebElement sepeteEkle = driver.findElement(By.xpath("(//span[@class='a-button-inner'])[5]"));
        sepeteEkle.click();

// TEST03:
        // 1. yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");

        // 2. dropdown’dan bebek bölümüne secin
        driver.findElement(By.xpath("//option[.='Baby']")).click();

        // 3. bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bebek puset" + Keys.ENTER);

        // 4. sonuç yazsının puset içerdiğini test edin
        String sonucSaysi1 = driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText();
        String sonucYazisi1 = "puset";
        Assert.assertTrue(sonucSaysi.contains(sonucYazisi));

        // 5-üçüncü ürüne relative locater kullanarak tıklayin
        // 6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
    }
}
