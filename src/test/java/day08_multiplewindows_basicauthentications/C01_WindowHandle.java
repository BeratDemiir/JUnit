package day08_multiplewindows_basicauthentications;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class C01_WindowHandle extends TestBase {

    @Test
    public void handleWindows() {

        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        // ● Click Here butonuna basın.
        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu  doğrulayın.

    }
}
