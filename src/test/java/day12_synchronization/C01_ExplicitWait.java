package day12_synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {

    @Test
    public void synchronizationTest() {

//        https://the-internet.herokuapp.com/dynamic_loading/1  adresine gidin
        driver.get(" https://the-internet.herokuapp.com/dynamic_loading/1");

//        Start buttonuna tıkla
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

//        Hello World! Yazının sitede oldugunu test et
//       WebElement helloWorldElement = driver.findElement(By.xpath("//div[@id='finish']//h4"));
//        Assert.assertEquals("Hello World!",helloWorldElement.getText());
//     IMPLICIT WAIT ILE TEST CASE CALISMADI
//        COZUM EXPLICIT WAIT

        // 1. Adim:  WebDriverWait objesini olustur
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // 2.Adim: wait objesini kullanarak bekleme problemini coz
      WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        String helloWorldText = helloWorldElement.getText();
        Assert.assertEquals("Hello World!",helloWorldText);
    }
}
