package day0_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class P20_Actions extends TestBase {

    @Test
    public void test1() {

        // https://www.spicejet.com/ adresine gidin
        driver.get("https://www.spicejet.com/");

        // Sayfanin altindaki about us bolumu altindaki fleet linkine tiklayalim
        WebElement aboutUs = driver.findElement(By.xpath("//div[.='About Us']"));
        new Actions(driver).moveToElement(aboutUs).perform();
        driver.findElement(By.xpath("//div[.='Fleet']")).click();

        // Sayfa basliginin Fleet icerdigini test edelim.

    }
}
