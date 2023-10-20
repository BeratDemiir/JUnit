package day17_jsexcutors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JsExecutors_Scroll extends TestBase {

    @Test
    public void scrollIntoViewTest() {

// 2)Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");

// 3)We Offer elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
           // 1. Adim Elementi bul
        WebElement programs = driver.findElement(By.xpath("//h1[.='Programs']"));
           // 2. Adim JS executors objesi olustur
        JavascriptExecutor js = (JavascriptExecutor)driver;
           // 3. ADim yapmak istedigim islemi js.executeScript method'u ile yap
        js.executeScript("arguments[0].scrollIntoView(true)",programs);

// 4)Ayni sayfada Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
// 5)Ayni sayfada WHY US? elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
// 6)Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
    }
}
