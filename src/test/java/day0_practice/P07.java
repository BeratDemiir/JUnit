package day0_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P07 {

    static WebDriver driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {
        driver.get("https://www.google.com");
        String actualTitle = driver.getTitle();
        String exceptedTitle = "Google";
        Assert.assertTrue(actualTitle.contains(exceptedTitle));
        WebElement search = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        search.sendKeys("nutella", Keys.ENTER);
        String[] sonuc = (driver.findElement(By.xpath("//*[@id='result-stats']")).getText().split(" "));
        String sonucSayisi = sonuc[1];
        System.out.println("sonucSayisi = " + sonucSayisi);

        sonucSayisi = sonucSayisi.replaceAll("\\D", "");
        int istenenSayi = 100000000;
        Assert.assertTrue(Integer.parseInt(sonucSayisi) > istenenSayi);
        driver.close();
    }
}
