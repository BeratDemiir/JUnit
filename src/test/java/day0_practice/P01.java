package day0_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P01 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.get("https://www.amazon.com");
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();
        System.out.println("Sayfa basligi : "+ actualTitle);
        System.out.println("Sayfa url: " + actualUrl);

        Assert.assertFalse(actualTitle.contains("spend") && actualUrl.contains("spend"));

        driver.get("https://www.trendyol.com");
        String trendyolTitle = driver.getTitle();
        Assert.assertFalse(trendyolTitle.contains("sitesi"));

        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();
        driver.quit();
    }
}
