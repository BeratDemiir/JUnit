package day0_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://testpages.herokuapp.com/styled/index.html");
        driver.findElement(By.xpath("//*[@id='calculatetest']")).click();

        WebElement firstNumber = driver.findElement(By.id("number1"));
        firstNumber.sendKeys("30", Keys.TAB,Keys.TAB,"30",Keys.ENTER);

        WebElement sonuc = driver.findElement(By.xpath("//*[@id='answer']"));
        System.out.println(sonuc.getText());
        driver.close();
    }
}
