package day0_practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class P05 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        // AddElement butonuna 100 defa basin
       WebElement addButton = driver.findElement(By.xpath("//*[@onclick='addElement()']"));
        for (int i = 0; i < 100 ; i++) {
            addButton.click();
        }

        List<WebElement> deleteButton = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        Assert.assertEquals(100,deleteButton.size());

        for (int i = 0; i < 90; i++) {
            driver.findElement(By.xpath("//*[@onclick='deleteElement()']")).click();
        }

        List<WebElement> delete = driver.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int kalanButton =deleteButton.size()-90;
        Assert.assertEquals(kalanButton,delete.size());

        driver.close();
    }
}
