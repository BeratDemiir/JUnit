package day17_jsexcutors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.IOException;

public class C01_JsExecutors_Scroll extends TestBase {

    @Test
    public void scrollIntoViewTest() throws IOException {

// 2)Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");

// 3)Programs elementi gorunur olacak sekilde uzerine scroll et ve ekran gorunturunu al
        // 1. Adim Elementi bul
        WebElement programs = driver.findElement(By.xpath("//h1[.='Programs']"));
        // 2. Adim JS executors objesi olustur
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // 3. Adim yapmak istedigim islemi js.executeScript method'u ile yap
        js.executeScript("arguments[0].scrollIntoView(true)", programs);
        waitFor(3);
        // Ekran goruntusu al
        takeScreenShotOfPage();

// 4)Ayni sayfada Blogs gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement blogs = driver.findElement(By.xpath("//h2[.='Blogs']"));
        scrollIntoViewJS(blogs);
        waitFor(3);
        takeScreenShotOfPage();

// 5)Ayni sayfada Testimonials elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        WebElement testimonials = driver.findElement(By.xpath("//h2[.='Testimonials']"));
        scrollIntoViewJS(testimonials);
        waitFor(3);
        takeScreenShotOfPage();

// 6)Ayni sayfada tekrar Enroll Free elementi gorunur olacak sekilde scroll et ve ekran goruntusunu al
        scrollIntoViewJS(blogs);
        waitFor(3);
        takeScreenShotOfPage();

        // En uste git
        scrollTabJs();
        waitFor(3);

        // En alta git
        scrollEndJS();
    }
}
