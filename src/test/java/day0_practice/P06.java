package day0_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P06 {

    static WebDriver driver;
    @BeforeClass
    public static void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() {

        driver.get("https://ebay.com");
        driver.findElement(By.xpath("(//*[@_sp='p2481888.m1379.l3250'])[1]")).click();
        List<WebElement> urunlerSize = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
        for (int i = 1; i < urunlerSize.size(); i++) {
            List<WebElement> urunler = driver.findElements(By.xpath("//*[@width='225' and @height='225']"));
            urunler.get(i).click();
            System.out.println(i+ " baslik : "+driver.getTitle());
            driver.navigate().back();
        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.close();
    }
}
