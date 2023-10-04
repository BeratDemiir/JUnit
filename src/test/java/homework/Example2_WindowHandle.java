package homework;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Example2_WindowHandle extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        // ● https://testcenter.techproeducation.com/index.php?page=multiple-windows
        driver.get("https://testcenter.techproeducation.com/index.php?page=multiple-windows");

        // ● Title in ‘Windows’ oldugunu test edin
       String windowTitle = driver.getTitle();
        Assert.assertEquals("Windows" , windowTitle);

       String wHandle1 = driver.getWindowHandle();

        // ● Click here a tiklayin
        driver.findElement(By.xpath("//a[.='Click Here']")).click();
        Thread.sleep(3000);

        String wHandle2 = driver.getWindowHandle();

        switchToWindow(1); // Index ile ikinci pencereye gecis
       //   switchToWindow("New Window"); // String reusable ile ikinci pencereye gecis.

        // ● Sonra açılan sayfadaki title in ‘New Window’ oldugunu dogrulayin
        Assert.assertEquals("New Window",driver.getTitle());
    }
}
