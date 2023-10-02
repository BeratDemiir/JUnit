package day07_testbase_alerts_iframes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_IFrame extends TestBase {

    @Test
    public void iframeTest() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        // Ana sayfadaki "An iframe with a thin black border:" metnindeki black border yazisini oldugunu test edelim
      String anaMetin = driver.findElement(By.xpath("//p[.='An iframe with a thin black border:']")).getText();
      String expectedMetin ="An iframe with a thin black border:";
      Assert.assertTrue(anaMetin.contains(expectedMetin));

        // Ayrica "Applications lists" yazisinin sayfada oldugunu test edelim
        // Application lists elementi iframe in icinde. Iframe switch yapmam sart
        driver.switchTo().frame(0);
        String icMetin = driver.findElement(By.xpath("//*[.='Applications lists']")).getText();
        String expectedIcMetin ="Applications lists";
        Assert.assertTrue(expectedIcMetin.contains(icMetin));

        // Son olarak footer deki "Povered By" yazisinin varligini test edelim
        // Ana sayfadaki Povered By yazisini test etmek icin Iframe nin disina cikmak gerekir
        // Bunuda "driver.switchTo().defaultContent();/driver.switchTo().parentFrame(); methodu ile Iframe nin disina cikariz.
        driver.switchTo().defaultContent();
       String footerText = driver.findElement(By.xpath("(//footer[@class='blog-footer'][1])//p")).getText();
        System.out.println(footerText);
        Assert.assertTrue(footerText.contains("Povered By"));
    }
}
