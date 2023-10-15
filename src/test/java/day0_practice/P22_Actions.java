package day0_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P22_Actions extends TestBase {

    @Test
    public void test1() {

        // https://szimek.github.io/signature_pad/ sayfasina gidiniz
        driver.get("https://szimek.github.io/signature_pad/");

        // Cikan ekrana istediginiz cizgi yada sekli ciziniz
        WebElement yaziEkrani = driver.findElement(By.xpath("//div[@class='signature-pad--body']"));

        // Son olarak sayfayi temizleyin
    }
}
