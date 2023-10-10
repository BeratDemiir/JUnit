package homework;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class KeyboardBaseActions1 extends TestBase {

    @Test
    public void KeyboardBaseActionsTest() {

        //  1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //  2- Hover over "Me First" kutusunun ustune gelin
        WebElement kutuyagit = driver.findElement(By.xpath("//button[.='Hover Over Me First!']"));
        new Actions(driver).moveToElement(kutuyagit).perform();

        // 3. Link 1" e tiklayin
        driver.findElement(By.xpath("(//a[.='Link 1'])[1]")).click();

        // 4. Popup mesajini yazdirin
      String popupMessage = driver.switchTo().alert().getText();
        System.out.println(popupMessage);

        // 5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        // 6. “Click and hold" kutusuna basili tutun
        WebElement basiliTut = driver.findElement(By.id("click-box"));
        new Actions(driver).clickAndHold(basiliTut).perform();// basili tut

        // 7-“Click and hold" kutusunda cikan yaziyi yazdirin
        String mesaj = driver.findElement(By.xpath("//div[.='Well done! keep holding that click now.....']")).getText();
        System.out.println(mesaj);
        new Actions(driver).release().perform(); // basili tutmayi birak

        // 8- “Double click me" butonunu cift tiklayin
        WebElement doubleClick = driver.findElement(By.xpath("//h2[.='Double Click Me!']"));
        new Actions(driver).doubleClick(doubleClick).perform();
    }
}
