package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {

    //  1.Adım: Actions class’ta bir object oluşturulur.
            // Actions actions= new Actions(driver);

    //  2. Adım: Üzerinde çalışmak istediğiniz WebElement öğesini bulunur.
           // WebElement element = driver.findElement(locator);

    //  3.Adim : perform() kullanarak bu webelement üzerinde action  gerçekleştirilir.
          // actions.contextClick(element).perform( );
    @Test
    public void test1() {

        //   https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //   Kutuya sag tıklayın
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(By.id("hot-spot"));
        // Tum actionslar "actions" objesi ile baslar "perform()" ile biter.
        actions.contextClick(element).perform();

        //   Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
          // Alert deki mesaji test etmek icin alert'in icine girmemiz gerekiyor.
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());

        //   Tamam diyerek alert’i kapatın
        driver.switchTo().alert().accept();
    }
}
