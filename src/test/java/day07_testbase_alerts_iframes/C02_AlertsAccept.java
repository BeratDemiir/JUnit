package day07_testbase_alerts_iframes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_AlertsAccept extends TestBase {

    @Test
    public void acceptAlertTest() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
// ○1. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        // uyarıdaki OK butonuna tıklayın
        driver.switchTo().alert().accept(); // ok secenegine tiklar

        // ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expected ="You successfully clicked an alert";
        Assert.assertEquals(result,expected);
    }

    /*
      Alertleri nasil automate edersin?
       -> Alertler javascript ile olusur inspect edilemezler. oncelikle alerti switch etmemiz gerekir.
    */
}
