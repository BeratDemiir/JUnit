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
      WebElement iframeSonuc = driver.findElement(By.tagName("iframe"));
        System.out.println(iframeSonuc.getSize());

        Set<String> allWindowsHandles = driver.getWindowHandles();
        System.out.println(allWindowsHandles);

        // 3) Sayfa basliginda ‘Editor’ yazını içerdiğini test edelim.
        String editorTitle = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
        String expectedTitle ="Editor";
        Assert.assertTrue(expectedTitle.contains(editorTitle));
        // 4) Paragrafdaki yaziyi silelim
//        WebElement dlt = driver.findElement(By.xpath("//*[@id='tinymce']"));
//        dlt.clear();
//        Thread.sleep(3000);
        // 5) Sonrasinda paragrafa “iframein icindeyim” yazisini yazdıralım
        // 6) Alt kısımdaki yazının ‘Elemental Selenium’ yazisini içerdiğini test edelim

    }
}
