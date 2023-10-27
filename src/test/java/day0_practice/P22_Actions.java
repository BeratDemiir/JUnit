package day0_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class P22_Actions extends TestBase {

    @Test
    public void test1() {

        // https://szimek.github.io/signature_pad/ sayfasina gidiniz
        driver.get("https://szimek.github.io/signature_pad/");

        // Cikan ekrana istediginiz cizgi yada sekli ciziniz
        WebElement yaziEkrani = driver.findElement(By.xpath("//canvas"));
        Actions actions = new Actions(driver);
        actions.moveToElement(yaziEkrani).clickAndHold();

        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(5,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(0,5);
        }
        for (int i = 0; i < 10; i++) {
            actions.moveByOffset(10,-15);
        }
        actions.release().build().perform();

        // Cizimden sonra clear butonuna basalim ve sayfayi temizleyin
        driver.findElement(By.xpath("//button[.='Clear']")).click();
        waitFor(2);

    }

    @Test
    public void test2() {

        // https://jqueryui.com/slider/#colorpicker adresine gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
       WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
       driver.switchTo().frame(iframe);

        // kutucuk icindeki rengi once kirmizi sonra sari yapin
        WebElement slydr1 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement slydr2 = driver.findElement(By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slydr1,-175,0).perform();
        actions.dragAndDropBy(slydr2,-90,0).perform();
        actions.dragAndDropBy(slydr1,310,0).release().build().perform();

        waitFor(2);
        // sari oldugunu test edelim
        WebElement sari = driver.findElement(By.xpath("//div[@style='background-color: rgb(255, 255, 0);']"));
        assert sari.isDisplayed();
    }
}
