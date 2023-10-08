package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {

    @Test
    public void dragAndDropTest() {

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        //  iframe icinde islem yapmak icin iframe'in icine girmek gerekir
        driver.switchTo().frame(0);
      WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
      WebElement hedef  = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(kaynak,hedef).perform(); // En cok kullanilan method budur.
    }

    @Test
    public void clickAndHoldTest() {

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        //  iframe icinde islem yapmak icin iframe'in icine girmek gerekir
        driver.switchTo().frame(0);
        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement hedef  = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions = new Actions(driver);
        actions
                .clickAndHold(kaynak)// Kaynagi tut
                .moveToElement(hedef)// hedefe koy
                .release()// kaynagi hedefe birak.
                .build()// onceki methodlarin iliskisini guclendirir. kullanilmasi tercih edilir.
                .perform();// islemi gerceklestir.
    }

    @Test
    public void moveByOffSetTest() {

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable/");

        //And user moves the target element(Drag me to my target) in to  destination(Drop here)
        //  iframe icinde islem yapmak icin iframe'in icine girmek gerekir
        driver.switchTo().frame(0);
        WebElement kaynak = driver.findElement(By.xpath("//*[@id='draggable']"));

        Actions actions = new Actions(driver);
        // Bu method kaynagi istenilen kordinata surukler
        actions.clickAndHold(kaynak).moveByOffset(430,30).release().build().perform();

    }
}
