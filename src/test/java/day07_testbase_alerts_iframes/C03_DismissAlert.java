package day07_testbase_alerts_iframes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C03_DismissAlert extends TestBase {

    @Test
    public void test1() {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        // ○ 2. butona tıklayın,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        // uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss(); // cancel methoduna tiklar

        // ve result mesajının “You clicked: Cancel” oldugunu test edin.
        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expected ="You clicked: Cancel";
        Assert.assertEquals(result,expected);

    }
}
