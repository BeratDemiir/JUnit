package day0_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.List;

public class P16_WindowHandle extends TestBase {

    @Test
    public void test1() {

        // https://html.com/tags/iframe/ adresine gidin
        driver.get(" https://html.com/tags/iframe/");
        waitFor(3);
        String htmlHandle = driver.getWindowHandle();

        // Youtube wideosunu calistirin
//       WebElement iframe1 = driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
//       driver.switchTo().frame(iframe1);
        driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']")).click();

        // uc saniye calistiktan sonra sayfayi yenileyin
        waitFor(3);
        driver.navigate().refresh();

        // yeni sekmede amazon adresine gidiniz
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com/");

        // iphone aratiniz
        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
        search.sendKeys("iphone", Keys.ENTER);

        // arama sonucu olarak sadece sonuc sayisini yazdirin
        String[] aramaSonuc = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText().split(" ");
        System.out.println(aramaSonuc[2]);

        // ilk sekmeye geri donup url'ini konsola yazdiralim
        driver.switchTo().window(htmlHandle);
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);

        // ilk sekmeyi kapatalim
        driver.close();

        // sonra diger sekmeyi de kapatalim
       //  Test base de reusable code olarak yazildigi icin gerek kalmadi.
    }
}
