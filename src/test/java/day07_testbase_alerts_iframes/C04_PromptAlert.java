package day07_testbase_alerts_iframes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C04_PromptAlert extends TestBase {

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

// ○ 3. butona tıklayın,
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(4000);
        // uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Berat");
        Thread.sleep(4000);
        // OK butonuna tıklayın
        driver.switchTo().alert().accept();
        Thread.sleep(4000);
        // ve result mesajında isminizin görüntülendiğini doğrulayın.
        String result = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expected = "You entered: Berat";
        Assert.assertTrue(result.contains(expected));
        Thread.sleep(4000);
    }
}
