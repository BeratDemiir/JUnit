package day0_practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P16_WindowHandle extends TestBase {

    @Test
    public void test1() {

        // https://the-internet.herokuapp.com/iframe/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        String theIntHandle = driver.getWindowHandle();

        // An iframe conteining... basligi altindaki Text Box'a "Techproeducation" yazin.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
      WebElement textBox = driver.findElement(By.xpath("//p"));
      textBox.clear();
      textBox.sendKeys("Berat Demir");

        // TextBox'in altinda bulunan "Elemental Selenium" linkinin gorunur oldugunu test edin
        driver.switchTo().defaultContent();
       WebElement eSelenium = driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
        Assert.assertTrue(eSelenium.isDisplayed());

        // "Elemental Selenium" linkine tiklayin
        eSelenium.click();

        // Acilan sayfada sayfa basligini yazdirin
        String acilanSayfaHandle = driver.getWindowHandle();
        driver.switchTo().window(acilanSayfaHandle);
        System.out.println(driver.getTitle());

        // ilk sekmeye geri donelim ve url'ini yazdiralim
        driver.switchTo().window(theIntHandle);
        String ilkUrl = driver.getCurrentUrl();
        System.out.println(ilkUrl);

        // ilk sekmeyi kapatalim.
        driver.close();
    }
}
