package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class C02_FluentWait extends TestBase {

    @Test
    public void fluenWaitTest() {

//        https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//        Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

//        Hello World! Yazının sitede oldugunu test et

        //  1.Adim: Fluent wait icin bir obje olusturun
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30)) // Maximum bekleme suresi
                .pollingEvery(Duration.ofSeconds(3)) // Deneme araliklari
                .withMessage("IGNORE EXPECTION")// Mesaj yazdirabilirim zorunlu degil
                .ignoring(NoSuchMethodException.class);// Expection u handle et zorunlu degil.

        // 2.Adim: wait objesini kullanarak bekleme problemini coz
       WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);
    }
}
