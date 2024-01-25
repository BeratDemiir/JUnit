package day17_jsexcutors;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecutorsSetAttribute extends TestBase {

    @Test
    public void typeTest() {

//        Techpro education ana sayfasina git
        driver.get("https://www.techproeducation.com");
        waitFor(4);
//        Arama kutusuna programs yaz
        WebElement search = driver.findElement(By.id("searchHeaderInput"));
        typeWithJS(search, "programs");
        waitFor(3);
    }
}
