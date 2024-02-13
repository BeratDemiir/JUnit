package day08_multiplewindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class C01_WindowHandle extends TestBase {

    @Test
    public void handleWindows() throws InterruptedException {

        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        // ILK SAYFANIN IDSINI ALALIM
        String window1Handle = driver.getWindowHandle();

        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String actualText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Opening a new window";
        Assert.assertTrue(expectedText.contains(actualText));

        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String theInternet = driver.getTitle();
        Assert.assertEquals("The Internet", theInternet);

        // ● Click Here butonuna basın.
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        // Note: Bu noktada 2 pencere acik ve ikincisine gecis yapmak istiyorum bunun icin driver.getWindowHandles ile tum pencerelerin ID'sini alalim.
        Set<String> allWindowsHandles = driver.getWindowHandles();
        System.out.println(allWindowsHandles);
        for (String eachHandle : allWindowsHandles) {
            // Eger listedeki id window1 e esit degilse otamatik olarak bir sonraki window a esit olur.
            if (!eachHandle.equals(window1Handle)) {
                driver.switchTo().window(eachHandle);
                break;
            }
        }

        // BU NOKTADA DRIVER 2. PENCEREDE

        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Assert.assertEquals("New Window", driver.getTitle());

        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String newWindow = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window", newWindow);

        String window2Handle = driver.getWindowHandle();

        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.

        Thread.sleep(3000);
        // 1. windowa gecis yapiyorum
        driver.switchTo().window(window1Handle);
        String theInternet1 = driver.getTitle();
        Assert.assertEquals("The Internet", theInternet1);

        Thread.sleep(3000);
        // 2. windowa gecis yapalim
        driver.switchTo().window(window2Handle);

        Thread.sleep(3000);
        // 1. Windowa gecis yapalim
        driver.switchTo().window(window1Handle);
    }
}
