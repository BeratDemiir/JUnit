package day0_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P19_Actions extends TestBase {

    @Test
    public void test1() {
        //  https://www.google.com/ sayfasina gidelim
        driver.get("https://www.google.com");

        //  Buyuk kucuk harf olucak sekilde "HeLlo" yazdiralim
        WebElement search = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        search.sendKeys(Keys.SHIFT, "h", Keys.SHIFT, "e", Keys.SHIFT, "l");

    }
}
