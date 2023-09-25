package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Maven {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://www.amazon.com/ sayfasina gidelim
        // arama kutusunu locate edelim
        // “Samsung headphones” ile arama yapalim
        // Bulunan sonuc sayisini yazdiralim
        // Ilk urunu tiklayalim
        // Sayfadaki tum basliklari yazdiralim
    }
}
