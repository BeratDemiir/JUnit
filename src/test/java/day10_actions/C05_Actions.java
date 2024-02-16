package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions extends TestBase {

    @Test
    public void keyboardActionsTest() {

        //  Google a gidin https://www.google.com
        driver.get("https://www.google.com");

        // ‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)

        // ‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
        // Ve ENTER tusuna bas

        WebElement aramaKutusu = driver.findElement(By.id("APjFqb"));
        // aramaKutusu.sendKeys("iphone x fiyatlari" + Keys.ENTER);

        Actions actions = new Actions(driver);
        actions
                .keyDown(aramaKutusu, Keys.SHIFT)// Arama kutusunun ustunde Shift tusuna bas
                .sendKeys("iphone x fiyatlari")// shifte basiliyken bu yaziyi yaz
                .keyUp(aramaKutusu, Keys.SHIFT)// shifte artik basma
                .sendKeys(" cok pahali!" + Keys.ENTER)// normal halde yaz ve enter tusuna bas.
                .build()// Birden fazla actions method kullanildiginda build() kullanilmasi onerilir.
                .perform();
    }
}
