package day0_practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class P24_ExplicitWait extends TestBase {

    @Test
    public void test1() {

        // https://the-internet.herokuapp.com/dynamic_loading/1 sayfasina gidelim
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        // start buttonuna basalim
        driver.findElement(By.xpath("//div[@id='start']//button")).click();

        // Hello World! yazisinin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
        assert driver.findElement(By.id("finish")).isDisplayed();
    }
}
