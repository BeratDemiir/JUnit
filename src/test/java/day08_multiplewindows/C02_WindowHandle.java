package day08_multiplewindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_WindowHandle extends TestBase {

    @Test
    public void test1() {

        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
       String  actualWindow1Text = driver.findElement(By.xpath("//h3[.='Opening a new window']")).getText();
       String expectedW1Text = "Opening a new window";
        Assert.assertEquals(expectedW1Text,actualWindow1Text);


        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualW1Title = driver.getTitle();
        String expectedW1Title ="The Internet";

        String window1Handle = driver.getWindowHandle();

        // ● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        waitFor(3);// diger sayfaya gecmeden once 3 sn bekler.

    //    IKINCI PENCERE ACILIR VE IKINCI PENCEREDE ISLEM YAPMAK ISTEDIGIMDEN, O PENCEREYE SWITCH-GECIS-YAPMALIYIZ

        switchToWindow(1);

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window", driver.getTitle());

        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualW2Text = driver.findElement(By.xpath("//h3[.='New Window']")).getText();
        String expectedW2Text = "New Window";

        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.
        switchToWindow(0);
        Assert.assertEquals("The Internet" , driver.getTitle());
    }
}
