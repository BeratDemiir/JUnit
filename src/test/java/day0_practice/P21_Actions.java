package day0_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class P21_Actions extends TestBase {

    @Test
    public void test1() {

       // https://demoqa.com/ url'ine gidin
        driver.get("https://demoqa.com/");
        String handle1 = driver.getWindowHandle();

       // Alerts, frame & Windows Butonuna click yap
        WebElement kutu = driver.findElement(By.xpath("(//div[@class='card-up'])[6]"));
        new Actions(driver).moveToElement(kutu).perform();
        driver.findElement(By.xpath("(//div[@class='card-up'])[3]")).click();

       // Please select an item from left to start practice. yazisinin gorunur oldugunu dogrula
        WebElement yazi = driver.findElement(By.xpath("//div[.='Please select an item from left to start practice.']"));
        Assert.assertTrue(yazi.isDisplayed());

       // Sol da acilan  Menu den "Browser Windows" butonuna click yap
        driver.findElement(By.xpath("//span[.='Browser Windows']")).click();

       // New tab butonunun gorunur oldugunu dogrula
        WebElement tabBuuton = driver.findElement(By.id("tabButton"));
        Assert.assertTrue(tabBuuton.isDisplayed());

       // New tab butonuna click yap
        tabBuuton.click();

     // Acilan yeni tab da "This is a sample page" yazisinin gorunur oldugunu test edin
//        List<String> allWindow = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window(allWindow.get(1));
        switchToWindow(1);
       WebElement newText = driver.findElement(By.id("sampleHeading"));
        Assert.assertTrue(newText.isDisplayed());

     // ilk tab a geri donun
        switchToWindow(0);

     // New tab butonunun gorunur oldugunu test edin
        Assert.assertTrue(tabBuuton.isDisplayed());
    }
}
